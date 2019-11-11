package machine;

import java.util.LinkedList;
import java.util.List;

import environment.Env;

public class SequenceExpression extends AbstractExpression {
    List<IIExpression> exps;
    public SequenceExpression(){
    	exps = new LinkedList<IIExpression>();
    }
    public SequenceExpression(List<IIExpression> exps){    	
    	this.exps = exps;
    }
	public List<IIExpression> getSequence(){
		return exps;
	}
	
	@Override
	public Object run(Env env) {
		// TODO Auto-generated method stub
		return null;
	}
}
