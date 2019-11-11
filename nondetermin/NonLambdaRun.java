package nondetermin;

import java.util.List;
import environment.Env;

public class NonLambdaRun extends AbstractNonRun{
	List<String> paras;
	NonSequenceRun body;
	
	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		NonAnalyzeProcedure proc = new NonAnalyzeProcedure(env,paras,body);
		return suc.success(proc,fail);
	}

	public List<String> getParas() {
		return paras;
	}

	public void setParas(List<String> paras) {
		this.paras = paras;
	}

	public NonSequenceRun getBody() {
		return body;
	}

	public void setBody(NonSequenceRun body) {
		this.body = body;
	}
	

}
