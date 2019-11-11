package compileMachine;

import java.util.List;

import environment.Env;

public class SequenceRun extends AbstractRunObject{
	 List<IRunObject> runs;

	public List<IRunObject> getRuns() {
		return runs;
	}
	public void setRuns(List<IRunObject> runs) {
		this.runs = runs;
	}
	@Override
	public Object run(Env env) {
		Object result =null;
		for(IRunObject o: runs) {
			 result = o.run(env);
		}
		return result;
	}
	

}
