package compileMachine;

import java.util.List;

import environment.Env;

public class AnalyzeProcedure {

	Env env;
	List<String> paras;
	SequenceRun body;	
	boolean isPrim = false;
	
	public AnalyzeProcedure() {}
	public AnalyzeProcedure(Env env, List<String> paras, SequenceRun body) {
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

	public SequenceRun getBody() {
		return body;
	}
	public void setBody(SequenceRun body) {
		this.body = body;
	}
	public List<String> getParas() {
		return paras;
	}
	public void setParas(List<String> paras) {
		this.paras = paras;
	}


	
	

}
