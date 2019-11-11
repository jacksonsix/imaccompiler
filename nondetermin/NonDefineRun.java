package nondetermin;

import compileMachine.IRunObject;
import environment.Env;
import machine.IIExpression;

public class NonDefineRun extends AbstractNonRun{
	IIExpression exp;
	String name;
	INonRunObject val;
	
	public IIExpression getExp() {
		return exp;
	}
	public void setExp(IIExpression exp) {
		this.exp = exp;
	}
	
	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		
		DefineSuc suc2 = new DefineSuc();
		suc2.setEnv(env);
		suc2.setName(name);
		SimpleFailObject fail2 = new SimpleFailObject();
		//env.defineVarible(name, val.run(env));
		val.run(env,suc2,fail2);
		return  suc.success("ok", fail);
		
	}
	public INonRunObject getVal() {
		return val;
	}
	public void setVal(INonRunObject val) {
		this.val = val;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
