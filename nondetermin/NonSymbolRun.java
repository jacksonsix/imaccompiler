package nondetermin;

import environment.Env;
import machine.IIExpression;
import machine.SymbolExpression;


public class NonSymbolRun extends AbstractNonRun{

	IIExpression exp;

	public IIExpression getExp() {
		return exp;
	}
	public void setExp(IIExpression exp) {
		this.exp = exp;
	}
	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		try {
			SymbolExpression sexp = (SymbolExpression) exp;
			String name = sexp.getName() ;
			Object o =  env.search(name);
			return suc.success(o, fail);
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
