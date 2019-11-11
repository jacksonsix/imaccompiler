package compileMachine;

import environment.Env;
import machine.IIExpression;
import machine.SelfExpression;

public class SelfRun extends AbstractRunObject{

	IIExpression exp;
	@Override
	public Object run(Env env) {
		return ((SelfExpression)exp).getValue();
		
	}
	public IIExpression getExp() {
		return exp;
	}
	public void setExp(IIExpression exp) {
		this.exp = exp;
	}
	
	

}
