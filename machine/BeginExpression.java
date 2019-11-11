

package machine;

import java.util.LinkedList;
import java.util.List;

import environment.Env;

public class BeginExpression extends AbstractExpression {

	List<IIExpression> exps;
	
	@Override
	public Object run(Env env) {
		Object result=null;
		for(IIExpression ex: exps) {
			result = ex.run(env);
		}
		return  result;
	}
	
    public BeginExpression(){
    	exps = new LinkedList<IIExpression>();
    	
    }
    public BeginExpression(List<IIExpression> exps){    	
    	this.exps = exps;
    }
	public List<IIExpression> getSequence(){
		return exps;
	}


	
}
