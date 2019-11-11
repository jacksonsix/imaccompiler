package machine;

import environment.Env;

public class SetExpression extends AbstractExpression {
	String name;
	IIExpression val;
	public SetExpression() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SetExpression(String name, IIExpression val) {
		super();
		this.name = name;
		this.val = val;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IIExpression getVal() {
		return val;
	}
	public void setVal(IIExpression val) {
		this.val = val;
	}
	
	@Override
	public Object run(Env env) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
