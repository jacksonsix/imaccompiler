package machine;

import java.util.List;

import environment.Env;

public class LetExpression extends AbstractExpression{
    List<XPair> pairs;
    List<IIExpression> body;
    
    public LetExpression() {}
    
    
    
	public List<XPair> getPairs() {
		return pairs;
	}



	public void setPairs(List<XPair> pairs) {
		this.pairs = pairs;
	}



	public List<IIExpression> getBody() {
		return body;
	}



	public void setBody(List<IIExpression> bodys) {
		this.body = bodys;
	}



	@Override
	public Object run(Env env) {
		// TODO Auto-generated method stub
		return null;
	}

}


