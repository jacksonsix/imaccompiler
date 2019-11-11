package nondetermin;

import java.util.List;

import environment.Env;


public class NonSequenceRun extends AbstractNonRun{
	 List<INonRunObject> runs;

	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		Object result =null;
		for(INonRunObject o: runs) {
			 result = o.run(env,suc,fail);
		}
		return result;
	}

	public List<INonRunObject> getRuns() {
		return runs;
	}

	public void setRuns(List<INonRunObject> runs) {
		this.runs = runs;
	}
	 
	 
	 
}
