package nondetermin;

import environment.Env;
import environment.False;
import machine.IIExpression;

public class NonIfRun extends AbstractNonRun{
    IIExpression parent;
	INonRunObject pred ;
	INonRunObject alt ;
	INonRunObject first ;
	
	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		
		IfSuc ifsuc = new IfSuc();
		SimpleFailObject fail2 = new SimpleFailObject();
		
		if((boolean)pred.run(env,ifsuc,fail) == False.value()){
			
			return alt.run(env,suc,fail2);
		}else{
			return  first.run(env,suc,fail2);
		}
		
	}

	public IIExpression getParent() {
		return parent;
	}

	public void setParent(IIExpression parent) {
		this.parent = parent;
	}

	public INonRunObject getPred() {
		return pred;
	}

	public void setPred(INonRunObject pred) {
		this.pred = pred;
	}

	public INonRunObject getAlt() {
		return alt;
	}

	public void setAlt(INonRunObject alt) {
		this.alt = alt;
	}

	public INonRunObject getFirst() {
		return first;
	}

	public void setFirst(INonRunObject first) {
		this.first = first;
	}
	
	

}
