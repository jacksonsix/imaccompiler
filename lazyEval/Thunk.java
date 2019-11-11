package lazyEval;

import environment.Env;
import machine.IIExpression;

public class Thunk {
	IIExpression exp;
	Env env;
	LazyEval machine;
	Object value;
	boolean memorized=true;
	
	public Thunk() {}
	public Thunk(IIExpression exp,Env env,LazyEval machine) {
		this.exp = exp;
		this.env = env;
		this.machine = machine;
		this.value = null;
	}
	public Object force_it() {
       if(isMemorized()) {
    	   return force_memory();
       }else {
    	  
    	   return force_no_memory();
       }
	}
	
	private Object force_memory() {
		
		try {
			if(this.value != null) {
				return this.value;
			}else {
				Object o = machine.eval(exp, env);
				if(o instanceof Thunk) {
					return ((Thunk) o).force_it();
				}else {
					this.value = o;
				}
				return this.value;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	private Object force_no_memory() {
		try {
			
			Object o = machine.eval(exp, env);
			if(o instanceof Thunk) {
				return ((Thunk) o).force_it();
			}else {	
				return o;
			}
	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isMemorized() {
		return memorized;
	}
	public void setMemorized(boolean memorized) {
		this.memorized = memorized;
	}
	

}
