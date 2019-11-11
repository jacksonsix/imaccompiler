package compileMachine;

import environment.Env;

public class SetRun extends AbstractRunObject{

	String name;
	IRunObject val;
	
	@Override
	public Object run(Env env) {
		try {
			env.setVarible(name, val.run(env));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
