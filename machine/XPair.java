package machine;

import environment.Env;

public class XPair<L,R>  extends AbstractExpression{

	private L left;
	private R right;
	public XPair(L left, R right) {
		this.left = left;
		this.right = right;
	}
	
	public L getLeft() {
		return this.left;
	}
	public R getRight() {
		return this.right;
	}

	@Override
	public Object run(Env env) {
		// TODO Auto-generated method stub
		return null;
	}
}
