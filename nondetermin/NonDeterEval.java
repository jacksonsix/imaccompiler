package nondetermin;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

import compileMachine.AnalyzeProcedure;
import compileMachine.ApplicationRun;
import compileMachine.DefineRun;
import nondetermin.INonRunObject;
import compileMachine.IfRun;
import compileMachine.LambdaRun;
import compileMachine.SelfRun;
import compileMachine.SequenceRun;
import compileMachine.SetRun;
import compileMachine.SymbolRun;
import environment.Env;
import environment.LowerBox;
import machine.BeginExpression;
import machine.CompoundExpression;
import machine.DefineExpression;
import machine.IIExpression;
import machine.IfExpression;
import machine.LambdaExpression;
import machine.PrimitiveProc;
import machine.SelfExpression;
import machine.SequenceExpression;
import machine.SetExpression;
import machine.SymbolExpression;


public class NonDeterEval {
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
    	INonRunObject obj = analyze(exp);
    	Object result = null;
    	ISucObject so = new SimpleSucObject();
    	IFailObject fo = new SimpleFailObject();
    	result = ((INonRunObject)obj).run(env,so,fo);
    	
    	return  result;
    }
    
    //analyze return lambda or Proc ??
    //try with lambda first
    // try with proc
    // java work best with class, first citizen, not function
    // use another data structure runobject to save analyze result
	public INonRunObject analyze(Object exp) throws Exception{
		String type="";
		if( exp instanceof  IIExpression){
		   type= exp.getClass().getSimpleName();	
		}else {
			throw new Exception("analyze type error");
		}		
		
		switch(type){
		case "SelfExpression":
			INonRunObject ro = analyze_self((SelfExpression)exp);
			return ro;
		case "SymbolExpression":
			INonRunObject symro = analyze_symbol((SymbolExpression)exp);
			return symro;
		case "DefineExpression":
			INonRunObject iro =analyze_DefineExpression((DefineExpression)exp);
			return iro;
		case "SetExpression":
			INonRunObject sro = analyze_SetExpression((SetExpression)exp);
			return sro;
		case "IfExpression":
			INonRunObject ifro = analyze_If((IIExpression)exp);	
			return ifro;
		case "LambdaExpression":
			INonRunObject lamro = analyze_lambda((LambdaExpression)exp);
			return  lamro;
		case "SequenceExpression":
			INonRunObject seqro = analyze_sequence((SequenceExpression)exp);
			return  seqro;
		case "BeginExpression":
			INonRunObject beginro = analyze_begin((BeginExpression)exp);
			return beginro;
		case "CompoundExpression":
			INonRunObject appro = analyze_application((CompoundExpression)exp);
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
	
	private INonRunObject analyze_application(CompoundExpression exp ) throws Exception {
		Object lexp = exp.getOperator();
		
		INonRunObject proc = analyze(lexp);
		List<IIExpression> paras = exp.getParalist();
		List<INonRunObject> objs = new LinkedList<INonRunObject>();
		if(paras != null){
			for(IIExpression ex: paras){
				INonRunObject o = analyze(ex);
				objs.add(o);
			}
		}
		NonApplicationRun ar = new NonApplicationRun();
		ar.setParas(objs);
		ar.setProc(proc);
		ar.setParent(exp);
		ar.setMachine(this);
		return ar;
	}
	
	private INonRunObject analyze_begin(BeginExpression exp) throws Exception {
		List<IIExpression> exps = exp.getSequence();
		List<INonRunObject> runs = new LinkedList<INonRunObject>();
		for(IIExpression ex: exps) {
			INonRunObject e = analyze(ex);
			runs.add(e);
		}
		NonSequenceRun sr = new NonSequenceRun();
		sr.setRuns(runs);
		sr.setParent(exp);
		return  sr;
		
	}
	private INonRunObject analyze_sequence(SequenceExpression exp) throws Exception {
		
		List<IIExpression> exps = exp.getSequence();
		List<INonRunObject> runs = new LinkedList<INonRunObject>();
		for(IIExpression ex: exps) {
			INonRunObject e = analyze(ex);
			runs.add(e);
		}
		NonSequenceRun sr = new NonSequenceRun();
		sr.setRuns(runs);
		return  sr;
	}
	
	
	private INonRunObject analyze_lambda(LambdaExpression lexp) throws Exception {
		NonLambdaRun lrun = new NonLambdaRun();
		List<String> paras = lexp.getParas();
        SequenceExpression sbody = new SequenceExpression(lexp.getBody());
		INonRunObject body = analyze(sbody);
		
		lrun.setParent(lexp);
		lrun.setParas(paras);
		lrun.setBody((NonSequenceRun)body);
		
		return lrun;
	}
	private INonRunObject analyze_If(IIExpression exp) throws Exception {
		NonIfRun ro = new NonIfRun();
		IfExpression iexp = (IfExpression)exp;
		IIExpression pred = iexp.getPredicate();
		IIExpression alt = iexp.getAlternate();
		IIExpression first = iexp.getFirstexp();
		
		ro.setParent(exp);
		INonRunObject rp = analyze(pred);
		INonRunObject ralt = analyze(alt);
		INonRunObject rfirst = analyze(first);
		
		ro.setAlt(ralt);
		ro.setPred(rp);
		ro.setFirst(rfirst);
		
		return ro;
		
	}
	private INonRunObject analyze_symbol(SymbolExpression exp) {
		NonSymbolRun ro = new NonSymbolRun();
		//ro.setParent(exp);
		ro.setExp(exp);
		return ro;
	}
	private INonRunObject analyze_DefineExpression(DefineExpression exp) throws Exception {
		String name = exp.getName();
		IIExpression val = exp.getVal(); 
		INonRunObject o =  analyze(val);
		
		NonDefineRun ro = new NonDefineRun();
        ro.setParent(exp);
		ro.setName(name);
		ro.setVal(o);
		return ro;
	}
	private INonRunObject analyze_self(SelfExpression exp) {
		
		NonSelfRun ro = new NonSelfRun();
		ro.setParent(exp);
		ro.setExp(exp);
		return ro;
		
	}
	
	private INonRunObject analyze_SetExpression(SetExpression exp) throws Exception {
		String name = exp.getName();
		IIExpression val = exp.getVal(); 
		INonRunObject o =  analyze(val);
		
		NonSetRun ro = new NonSetRun();
        ro.setParent(exp);
		ro.setName(name);
		ro.setVal(o);
		return ro;
		
	}
	

	
}