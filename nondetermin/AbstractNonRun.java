package nondetermin;

import compileMachine.IRunObject;
import machine.IIExpression;


public abstract class AbstractNonRun implements INonRunObject {

	IIExpression parent = null;
	
	public IIExpression getParent() {
		return parent;
	}
	public void setParent(IIExpression parent) {
		this.parent = parent;
	}
	

}
