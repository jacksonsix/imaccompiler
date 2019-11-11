package machine;

import java.util.List;

import environment.Env;

public class LambdaExpression extends AbstractExpression {
	List<String> paras;
	List<IIExpression> body;
	public LambdaExpression() {}
	public LambdaExpression(List<String> paras, List<IIExpression> body) {
		super();
		this.paras = paras;
		this.body = body;
	}
	public List<String> getParas() {
		return paras;
	}
	public void setParas(List<String> paras) {
		this.paras = paras;
	}
	public List<IIExpression> getBody() {
		return body;
	}
	public void setBody(List<IIExpression> body) {
		this.body = body;
	}
	@Override
	public Object run(Env env) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
