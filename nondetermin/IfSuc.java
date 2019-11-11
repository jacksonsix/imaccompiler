package nondetermin;

import environment.Env;

public class IfSuc implements ISucObject{
	Env env;
	
	
	public Env getEnv() {
		return env;
	}

	public void setEnv(Env env) {
		this.env = env;
	}


	@Override
	public Object success(Object val, IFailObject fail) {
		
		return val;
	}
}
