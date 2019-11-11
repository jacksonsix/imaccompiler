package compileMachine;

import java.util.LinkedList;
import java.util.List;

import environment.Env;
import environment.LowerBox;
import machine.ILispObject;
import machine.PrimitiveProc;
import machine.Procedure;
import machine.SequenceExpression;

public class ApplicationRun extends AbstractRunObject{
   IRunObject proc;
   List<IRunObject>  paras;
   CompileEval machine;
   
   
   public IRunObject getProc() {
	return proc;
}


public void setProc(IRunObject proc) {
	this.proc = proc;
}
public void setMachine(CompileEval machine) {
	this.machine = machine;
}

public List<IRunObject> getParas() {
	return paras;
}


public void setParas(List<IRunObject> paras) {
	this.paras = paras;
}


   @Override
   public Object run(Env env) {
	    List<Object> args = new LinkedList<Object>();
	    for(IRunObject o :paras) {
	    	args.add(o.run(env));
	    }
		try {
			return machine.apply(proc.run(env),args,env);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   }
   

   
   
}
