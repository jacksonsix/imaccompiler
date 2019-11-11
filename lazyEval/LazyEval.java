package lazyEval;


import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import environment.Env;
import environment.False;
import environment.LowerBox;
import machine.*;


public class LazyEval {
	public int steps=0;
	private String history="";
	public String getHistory() {
		return history;
	}
    private void  log(String str){
    	System.out.println(str);
    }
    public  void traceExpression(IIExpression exp, Env env) throws Exception {
    	//System.out.println(exp.getClass().getSimpleName() +"@ "+ exp.getLine() +"call|: "+ exp.getParent()+"->"+exp.hashCode());
    	System.out.println( exp.getParent()+"->"+exp.hashCode()+";");
    	writefile("2.txt",exp.getParent()+"->"+exp.hashCode()+";");
    	
    	System.out.println(exp.getText());
    	writefile("1.txt",exp.getText());
    	
    	
    }
    public void traceEnv(Env env,boolean open) throws Exception {
    	if(open) {
    		writefile("env.txt", "(" + env.getName()  +"->" + env.uplinkFrameName() + " " + env.printTailFrame()+": " + env.printTailValues() );
    	}else {
    		writefile("env.txt", env.getName() + ")");
    	}
    	
    	
    }
	public Object eval(Object exp, Env env) throws Exception{
		steps++;
		String hint = exp.getClass().getSimpleName();
		if("SymbolExpression".equals(exp.getClass().getSimpleName())){
			hint = ((SymbolExpression)exp).getName();
		}
		this.history += "(" + exp.hashCode()+ " " + hint +" " ;
		String type="";
		if( exp instanceof  IIExpression){
		   type= exp.getClass().getSimpleName();	
		}		
		else{		
			System.out.println("eval : object " +exp);
			this.history += exp.hashCode() +")";
			return exp;
		}
		//log("eval :");
		traceExpression((IIExpression)exp,env);
		switch(type){
		case "SelfExpression":
			Object self = ((SelfExpression)exp).getValue();
			this.history += exp.hashCode() +")";
			return self;
		case "SymbolExpression":
			
			Object symbol =((SymbolExpression)exp).getValue(env);
			this.history += exp.hashCode() +")";
			return symbol;
		case "DefineExpression":
			EvalDefineExpression((DefineExpression)exp,env);
			this.history += exp.hashCode() +")";
			return "ok";
		case "SetExpression":
			EvalSetExpression((SetExpression)exp,env);
			this.history += exp.hashCode() +")";
			return "ok";
		case "IfExpression":	
			Object ifo = EvalIf((IIExpression)exp, env);	
			this.history += exp.hashCode() +")";
			return ifo;
		case "LambdaExpression":
			
			Object lambdao = EvalLambda((IIExpression)exp,env);
			this.history += exp.hashCode() +")";
			return lambdao;
		case "SequenceExpression":
			
			Object seqo= EvalSequenceExpression((IIExpression)exp,env);
			this.history += exp.hashCode() +")";
			return seqo;
		case "BeginExpression":
			
			Object begino= EvalSequenceExpression((IIExpression)exp,env);
			this.history += exp.hashCode() +")";
			return begino;
		case "CondExpression":
			//convert to if, then eval again
			IfExpression nif = new IfExpression();
			nif = convertCondToIf(exp);
			return eval(nif,env);
			
		case "LetExpression":
			// convert to lambda , eval again
			CompoundExpression nlexp = new CompoundExpression();
			nlexp = converToCompound(exp);
			return eval(nlexp,env);
			
		case "CompoundExpression":
			Object lexp = ((CompoundExpression)exp).getOperator();
			
			ILispObject proc = (ILispObject)eval(forceit(lexp),env);
			List<IIExpression> paras = ((CompoundExpression)exp).getParalist();

			Object applyo =  apply(proc,paras,env);	
			this.history += exp.hashCode() +")";
			return applyo;
		default:
			log("something wrong, not in eval scope");
			throw new Exception("");
		}
	}
	
	public Object forceit(Object obj){
		Object temp = obj;
		if(obj instanceof Thunk) {
			temp = ((Thunk)obj).force_it();
			return forceit(temp);
		}else {
			return obj;
		}
		
	}
	
	private CompoundExpression converToCompound(Object exp) {
		CompoundExpression com = new CompoundExpression();
		LambdaExpression lexp = new LambdaExpression();
		LetExpression le = (LetExpression)exp;
		List<XPair> ps = le.getPairs();
		List<String> args = new LinkedList<String>();
		List<IIExpression> comargs = new LinkedList<IIExpression>();
		for(int i=0;i<ps.size();i++) {
			XPair<String,IIExpression> xp = (XPair<String,IIExpression>)ps.get(i);
			args.add(xp.getLeft());
			comargs.add(xp.getRight());
		}
			
	
		lexp.setParas(args);
		lexp.setBody(le.getBody());
		
		com.setOperator(lexp);
		com.setParalist(comargs);
		
		return com;
	}
	private IfExpression convertCondToIf(Object exp) {
		CondExpression cp = (CondExpression)exp;
		IfExpression nif = new IfExpression();
		IfExpression pointer = nif;
		for(int i=0;i< cp.getBranches().size();i++) {
			XPair<IIExpression,IIExpression> br = (XPair<IIExpression, IIExpression>) cp.getBranches().get(i);
			pointer.setPredicate(br.getLeft());
			pointer.setFirstexp(br.getRight());
			IfExpression n = new IfExpression();
			pointer.setAlternate(n);
			pointer = n;
		}
		pointer.setAlternate(cp.getElsego());
		return nif;
	}
	private void EvalSetExpression(SetExpression exp, Env env) throws Exception {
		String name = exp.getName();
		IIExpression val = exp.getVal(); 
		Object o =  eval(val,env);
		env.setVarible(name, o);
		
	}
	private void EvalDefineExpression(DefineExpression exp, Env env) throws Exception {
		// TODO Auto-generated method stub
		String name = exp.getName();
		IIExpression val = exp.getVal(); 
		Object o =  eval(val,env);
		env.defineVarible(name, o);
	}
	
	private Object EvalIf(IIExpression exp, Env env) throws Exception{
		//log("Eval If");
		IfExpression iexp = (IfExpression)exp;
		IIExpression pred = iexp.getPredicate();
		IIExpression alt = iexp.getAlternate();
		IIExpression first = iexp.getFirstexp();
		boolean v = true;
		try {
			v = (boolean)eval(forceit(pred),env) ;
		}catch(Exception e) {
			v = true;
		}
		
		if(v == False.value()){
			alt.setParent(exp.hashCode());
			return eval(alt,env);
		}else{
			first.setParent(exp.hashCode());
			return eval(first,env);
		}
		
	}
	
	private Object EvalSequenceExpression(IIExpression exp, Env env) throws Exception{
		List<IIExpression> exps = ((SequenceExpression)exp).getSequence();
		List<IIExpression> dup = new LinkedList<IIExpression>(exps);
		return rEvalSequenceExpression(dup,env);
	}
	private Object rEvalSequenceExpression(List<IIExpression> exps, Env env) throws Exception{
		if(exps == null) return IIExpression.NullExpression();
		
		IIExpression first = exps.get(0);
		if(first == null){
			return IIExpression.NullExpression();
		}else if(exps.size() == 1){
			first.setParent(exps.hashCode());
			return eval(first,env);
		}else {
			first.setParent(exps.hashCode());
			eval(first,env);
			exps.remove(0);
			return rEvalSequenceExpression(exps, env);
		}
	}
	private Object EvalLambda(IIExpression exp, Env env){
		//log("Eval Lambda: ");
		//traceExpression(exp,env);
		LambdaExpression lexp = (LambdaExpression)exp; 
		List<String> paras = lexp.getParas();
		List<IIExpression> body = lexp.getBody();
		Procedure proc = new Procedure(env,paras,body);
		return proc;
	}
	
	public Object apply(ILispObject proc,List<IIExpression> args, Env env) throws Exception{
		String timestamp = Long.toString(System.nanoTime());
		if(proc instanceof PrimitiveProc){		
			  List<Object> objs = new LinkedList<Object>(); 
			  if(args != null){
		        for(IIExpression ex: args){ 
			      Object o = eval(ex,env); 
			      objs.add(o);
			    } 
			  }
			 
			return applyPrimitive((PrimitiveProc)proc,objs, env);
		}else{
			log("*** apply compound " +timestamp +" proc:"+ Integer.toString(proc.hashCode()) +" step number:" + Integer.toString(this.steps));
			
			SequenceExpression cbody = ((Procedure)proc).getBody();
			Env defenv = ((Procedure)proc).getEnv();
			
			if(args.size() > 0){
				List<Thunk> ts = new LinkedList<Thunk>();
				for(int j=0;j<args.size();j++) {
					Thunk t = new Thunk(args.get(j),env,this);
					ts.add(t);
				}
				List<Object> objectList = new ArrayList<Object>(ts);
				defenv = defenv.Extend(defenv, ((Procedure)proc).getParas(), objectList, proc.hashCode());
				defenv.setName("E" + Integer.toString(steps));
			}	
			cbody.setParent(proc.hashCode());
			traceEnv(defenv,true);
			Object o = eval(cbody,defenv);
			traceEnv(defenv,false);
			log("*** apply compound  finish " +timestamp +" proc:"+ Integer.toString(proc.hashCode())+" step number:" + Integer.toString(this.steps));
			return o;			
		}
	}
	
	private Object applyPrimitive(PrimitiveProc proc,List<Object> paras, Env env) throws Exception{
		
        int size = paras.size();
        Object[] parameters = new Object[size];
        for(int i=0;i< size; i++){
        	  if( paras.get(i) instanceof Thunk) {
        		  parameters[i] = ((Thunk)paras.get(i)).force_it();
        	  }else {
        		  parameters[i] = paras.get(i);
        	  }
        }
       
        Object test = proc.getProc().invoke(LowerBox.class,parameters);
		return test;
	}
	
	public static void writefile(String file,String msg) throws Exception {
		String folder ="/Users/bigtree/Documents/scriptwork/";
		String mes = msg + System.lineSeparator();
		try {
			Files.write(Paths.get(folder + file), mes.getBytes(), StandardOpenOption.APPEND);
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	public static void clearfile() throws Exception {
		String folder ="/Users/bigtree/Documents/scriptwork/";
		String mes = "";
		List<String> files = new LinkedList<String>();
		files.add("1.txt");
		files.add("2.txt");
		files.add("3.txt");
		files.add("4.txt");
		files.add("env.txt");
		for(String file : files) {
			try {
				File f = new File(folder + file);
				if(f.exists()) {
					f.delete();
					f.createNewFile();
				}
				
			}catch(Exception e) {
				throw e;
			}
		}

	}
	
}
