package nondetermin;

import environment.Env;
import machine.IIExpression;
import machine.SelfExpression;

public class NonSelfRun extends AbstractNonRun{

	IIExpression exp;

	public IIExpression getExp() {
		return exp;
	}

	public void setExp(IIExpression exp) {
		this.exp = exp;
	}

	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		return suc.success( ((SelfExpression)exp).getValue(), fail);
	}
}
