package machine;

import java.util.LinkedList;
import java.util.List;

import environment.Env;

public class DefineExpression extends AbstractExpression {
    String name;
    IIExpression val;
   
    
    public DefineExpression() {}
    public DefineExpression(String name, IIExpression val) {
    	this.name = name;
    	this.val= val;
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
		Object result=null;
		
		
		// call proc ,ps here
		return  result;
	}
    
}