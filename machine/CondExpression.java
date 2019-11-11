package machine;

import java.util.List;

import environment.Env;

public class CondExpression extends AbstractExpression{

	List<IIExpression> branches;
	IIExpression elsego;
	
	public CondExpression() {}
	public CondExpression(List<IIExpression> bras, IIExpression e) {
		this.branches = bras;
		this.elsego =e;
	}
	
	@Override
	public Object run(Env env) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IIExpression> getBranches() {
		return branches;
	}

	public void setBranches(List<IIExpression> branches) {
		this.branches = branches;
	}

	public IIExpression getElsego() {
		return elsego;
	}

	public void setElsego(IIExpression elsego) {
		this.elsego = elsego;
	}
    
}
