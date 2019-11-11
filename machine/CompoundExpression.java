package machine;

import java.util.LinkedList;
import java.util.List;

import environment.Env;

public class CompoundExpression extends AbstractExpression {
    IIExpression operator;
    List<IIExpression> paralist;
    
    public CompoundExpression(){}
	public CompoundExpression(IIExpression operator, List<IIExpression> paralist) {
		super();
		this.operator = operator;
		this.paralist = paralist;
		
	}
	public IIExpression getOperator() {
		return operator;
	}
	public void setOperator(IIExpression operator) {
		this.operator = operator;
	}
	public List<IIExpression> getParalist() {
		return paralist;
	}
	public void setParalist(List<IIExpression> paralist) {
		this.paralist = paralist;
	}
	
	
   
	@Override
	public Object run(Env env) {
		Object result=null;
		Object op = operator.run(env);
		List<Object> ps = new LinkedList<Object>();
		for(int i=0;i< paralist.size();i++) {
			IIExpression p = paralist.get(i);
			Object oo =p.run(env);
			ps.add(oo);
		}
		
		// call proc ,ps here
		return  result;
	}
    
}
