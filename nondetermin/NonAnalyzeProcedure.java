package nondetermin;


import java.util.List;

import environment.Env;

public class NonAnalyzeProcedure {

	Env env;
	List<String> paras;
	NonSequenceRun body;	
	boolean isPrim = false;
	
	public NonAnalyzeProcedure() {}
	public NonAnalyzeProcedure(Env env, List<String> paras, NonSequenceRun body) {
		this.env = env;
		this.paras = paras;
		this.body = body;
	}
	public Env getEnv() {
		return env;
	}
	public void setEnv(Env env) {
		this.env = env;
	}

	public NonSequenceRun getBody() {
		return body;
	}
	public void setBody(NonSequenceRun body) {
		this.body = body;
	}
	public List<String> getParas() {
		return paras;
	}
	public void setParas(List<String> paras) {
		this.paras = paras;
	}


	
	

}
