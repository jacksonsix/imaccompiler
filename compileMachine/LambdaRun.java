package compileMachine;

import java.util.List;

import environment.Env;
import machine.Procedure;


public class LambdaRun extends AbstractRunObject{
	List<String> paras;
	SequenceRun body;
	
	@Override
	public Object run(Env env) {
		
		AnalyzeProcedure proc = new AnalyzeProcedure(env,paras,body);
		return proc;
	}

	public List<String> getParas() {
		return paras;
	}

	public void setParas(List<String> paras) {
		this.paras = paras;
	}

	public SequenceRun getBody() {
		return body;
	}

	public void setBody(SequenceRun body) {
		this.body = body;
	}

	
}
