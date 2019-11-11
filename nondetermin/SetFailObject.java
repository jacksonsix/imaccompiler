package nondetermin;

import environment.Env;

public class SetFailObject implements IFailObject{
    IFailObject nextfail;
    Object oldval;
    Env env;
   
    public SetFailObject(Env env, Object old, IFailObject next) {
    	this.nextfail = next;
    	this.oldval = old;
    	this.env = env;
    }
	public IFailObject getNextfail() {
		return nextfail;
	}
	
	public void setNextfail(IFailObject nextfail) {
		this.nextfail = nextfail;
	}

	
	@Override
	public void fail() {
		
		
	    nextfail.fail();
		
	}
   
   
}
