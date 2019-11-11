package compileMachine;

import machine.IIExpression;

public abstract class AbstractRunObject implements IRunObject {

	IIExpression parent = null;
	
	public IIExpression getParent() {
		return parent;
	}
	public void setParent(IIExpression parent) {
		this.parent = parent;
	}
	

}
