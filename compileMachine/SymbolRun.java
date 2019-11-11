package compileMachine;

import environment.Env;
import machine.IIExpression;

public class SymbolRun extends AbstractRunObject{
    IIExpression parent;
    String exp;
    
    
	public IIExpression getParent() {
		return parent;
	}


	public void setParent(IIExpression parent) {
		this.parent = parent;
	}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
	}


	@Override
	public Object run(Env env) {
		
		try {
			Object o =  env.search(this.exp);
			return o;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
	}
	

}
