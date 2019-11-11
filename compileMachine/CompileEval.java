package compileMachine;


import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

import environment.Env;
import environment.LowerBox;
import machine.*;

public class CompileEval {
	public int steps=0;
	private String history="";
	public String getHistory() {
		return history;
	}
    public static void  log(String str){
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
    		writefile("env.txt", "(" + env.getName()  +"->" + env.uplinkFrameName() + " " + env.printTailFrame() );
    	}else {
    		writefile("env.txt", env.getName() + ")");
    	}
    	
    	
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
    
    public Object eval(Object exp, Env env) throws Exception{
    	IRunObject obj = analyze(exp);
    	Object result = null;
    	
    	result = ((IRunObject)obj).run(env);
    	
    	return  result;
    }
    
    //analyze return lambda or Proc ??
    //try with lambda first
    // try with proc
    // java work best with class, first citizen, not function
    // use another data structure runobject to save analyze result
	public IRunObject analyze(Object exp) throws Exception{
		String type="";
		if( exp instanceof  IIExpression){
		   type= exp.getClass().getSimpleName();	
		}else {
			throw new Exception("analyze type error");
		}		
		
		switch(type){
		case "SelfExpression":
			IRunObject ro = analyze_self((SelfExpression)exp);
			return ro;
		case "SymbolExpression":
			IRunObject symro = analyze_symbol((SymbolExpression)exp);
			return symro;
		case "DefineExpression":
			IRunObject iro =analyze_DefineExpression((DefineExpression)exp);
			return iro;
		case "SetExpression":
			IRunObject sro = analyze_SetExpression((SetExpression)exp);
			return sro;
		case "IfExpression":
			IRunObject ifro = analyze_If((IIExpression)exp);	
			return ifro;
		case "LambdaExpression":
			IRunObject lamro = analyze_lambda((LambdaExpression)exp);
			return  lamro;
		case "SequenceExpression":
			IRunObject seqro = analyze_sequence((SequenceExpression)exp);
			return  seqro;
		case "BeginExpression":
			IRunObject beginro = analyze_begin((BeginExpression)exp);
			return beginro;
		case "CompoundExpression":
			IRunObject appro = analyze_application((CompoundExpression)exp);
			return appro;		
		default:
			log("something wrong, not in analyze scope");
			throw new Exception("");
		}
	}
	
	public Object apply(Object proc,List<Object> args, Env env) throws Exception{
		
		if(proc instanceof PrimitiveProc){
			return applyPrimitive((PrimitiveProc)proc,args, env);
		}else{
			
			SequenceRun cbody = ((AnalyzeProcedure)proc).getBody();
			Env defenv = ((AnalyzeProcedure)proc).getEnv();
			if(args.size() > 0){
				defenv = defenv.Extend(defenv, ((AnalyzeProcedure)proc).getParas(), args,proc.hashCode());
				defenv.setName("E" + Integer.toString(steps));
			}		
			traceEnv(defenv,true);
			Object o = cbody.run(defenv);
			traceEnv(defenv,false);
			return o;
		}
	}
	
	private Object applyPrimitive(PrimitiveProc proc,List<Object> paras, Env env) throws Exception{
		
        int size = paras.size();
        Object[] parameters = new Object[size];
        for(int i=0;i< size; i++){
        	 parameters[i] =  paras.get(i);
        }
       
        Object test = proc.getProc().invoke(LowerBox.class,parameters);
		return test;
	}
	
	private IRunObject analyze_application(CompoundExpression exp ) throws Exception {
		Object lexp = exp.getOperator();
		
		IRunObject proc = analyze(lexp);
		List<IIExpression> paras = exp.getParalist();
		List<IRunObject> objs = new LinkedList<IRunObject>();
		if(paras != null){
			for(IIExpression ex: paras){
				IRunObject o = analyze(ex);
				objs.add(o);
			}
		}
		ApplicationRun ar = new ApplicationRun();
		ar.setParas(objs);
		ar.setProc(proc);
		ar.setParent(exp);
		ar.setMachine(this);
		return ar;
	}
	
	private IRunObject analyze_begin(BeginExpression exp) throws Exception {
		List<IIExpression> exps = exp.getSequence();
		List<IRunObject> runs = new LinkedList<IRunObject>();
		for(IIExpression ex: exps) {
			IRunObject e = analyze(ex);
			runs.add(e);
		}
		SequenceRun sr = new SequenceRun();
		sr.setRuns(runs);
		sr.setParent(exp);
		return  sr;
		
	}
	private IRunObject analyze_sequence(SequenceExpression exp) throws Exception {
		
		List<IIExpression> exps = exp.getSequence();
		List<IRunObject> runs = new LinkedList<IRunObject>();
		for(IIExpression ex: exps) {
			IRunObject e = analyze(ex);
			runs.add(e);
		}
		SequenceRun sr = new SequenceRun();
		sr.setRuns(runs);
		return  sr;
	}
	
	
	private IRunObject analyze_lambda(LambdaExpression lexp) throws Exception {
		LambdaRun lrun = new LambdaRun();
		List<String> paras = lexp.getParas();
        SequenceExpression sbody = new SequenceExpression(lexp.getBody());
		IRunObject body = analyze(sbody);
		
		lrun.setParent(lexp);
		lrun.setParas(paras);
		lrun.setBody((SequenceRun)body);
		
		return lrun;
	}
	private IRunObject analyze_If(IIExpression exp) throws Exception {
		IfRun ro = new IfRun();
		IfExpression iexp = (IfExpression)exp;
		IIExpression pred = iexp.getPredicate();
		IIExpression alt = iexp.getAlternate();
		IIExpression first = iexp.getFirstexp();
		
		ro.setParent(exp);
		IRunObject rp = analyze(pred);
		IRunObject ralt = analyze(alt);
		IRunObject rfirst = analyze(first);
		ro.setAlt(ralt);
		ro.setPred(rp);
		ro.setFirst(rfirst);
		
		return ro;
		
	}
	private IRunObject analyze_symbol(SymbolExpression exp) {
		SymbolRun ro = new SymbolRun();
		ro.setParent(exp);
		ro.setExp(exp.getName());
		return ro;
	}
	private IRunObject analyze_DefineExpression(DefineExpression exp) throws Exception {
		String name = exp.getName();
		IIExpression val = exp.getVal(); 
		IRunObject o =  analyze(val);
		
		DefineRun ro = new DefineRun();
        ro.setParent(exp);
		ro.setName(name);
		ro.setVal(o);
		return ro;
	}
	private IRunObject analyze_self(SelfExpression exp) {
		
		SelfRun ro = new SelfRun();
		ro.setParent(exp);
		ro.setExp(exp);
		return ro;
		
	}
	
	private IRunObject analyze_SetExpression(SetExpression exp) throws Exception {
		String name = exp.getName();
		IIExpression val = exp.getVal(); 
		IRunObject o =  analyze(val);
		
		SetRun ro = new SetRun();
        ro.setParent(exp);
		ro.setName(name);
		ro.setVal(o);
		return ro;
		
	}
	

	
}

