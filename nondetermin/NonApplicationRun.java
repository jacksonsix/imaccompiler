package nondetermin;

import java.util.LinkedList;
import java.util.List;
import environment.Env;

public class NonApplicationRun extends AbstractNonRun{

	   INonRunObject proc;
	   List<INonRunObject>  paras;
	   NonDeterEval machine;
	   
	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		 List<Object> args = new LinkedList<Object>();
		    for(INonRunObject o :paras) {
		    	args.add(o.run(env,suc,fail));
		    }
			try {
				ApplictionSuc asuc = new ApplictionSuc();
				return machine.apply(proc.run(env,asuc,fail),args,env);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

	private Object get_args(List<Object> args, Env env ,ISucObject suc,IFailObject fail) {
		
		return null;
	}
	public INonRunObject getProc() {
		return proc;
	}

	public void setProc(INonRunObject proc) {
		this.proc = proc;
	}

	public List<INonRunObject> getParas() {
		return paras;
	}

	public void setParas(List<INonRunObject> paras) {
		this.paras = paras;
	}

	public NonDeterEval getMachine() {
		return machine;
	}

	public void setMachine(NonDeterEval machine) {
		this.machine = machine;
	}
	
	

}
