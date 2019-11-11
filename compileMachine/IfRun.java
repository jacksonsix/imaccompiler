package compileMachine;

import environment.Env;
import environment.False;
import machine.IIExpression;
import machine.IfExpression;

public class IfRun extends AbstractRunObject{
    IIExpression parent;
	IRunObject pred ;
	IRunObject alt ;
	IRunObject first ;
	
	
	
	public IIExpression getParent() {
		return parent;
	}



	public void setParent(IIExpression parent) {
		this.parent = parent;
	}



	public IRunObject getPred() {
		return pred;
	}



	public void setPred(IRunObject pred) {
		this.pred = pred;
	}



	public IRunObject getAlt() {
		return alt;
	}



	public void setAlt(IRunObject alt) {
		this.alt = alt;
	}



	public IRunObject getFirst() {
		return first;
	}



	public void setFirst(IRunObject first) {
		this.first = first;
	}



	@Override
	public Object run(Env env) {

		if((boolean)pred.run(env) == False.value()){
			
			return alt.run(env);
		}else{
			return  first.run(env);
		}
	}

}
