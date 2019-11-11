package compileMachine;

import environment.Env;

public class DefineRun extends AbstractRunObject{

	String name;
	IRunObject val;
	
	@Override
	public Object run(Env env) {
		env.defineVarible(name, val.run(env));
		return "ok";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IRunObject getVal() {
		return val;
	}

	public void setVal(IRunObject val) {
		this.val = val;
	}

}
