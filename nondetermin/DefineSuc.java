package nondetermin;

import environment.Env;

public class DefineSuc implements ISucObject {

	Env env;
	String name;
	
	public Env getEnv() {
		return env;
	}

	public void setEnv(Env env) {
		this.env = env;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object success(Object val, IFailObject fail) {
		env.defineVarible(name, val);
		return val;
	}

}
