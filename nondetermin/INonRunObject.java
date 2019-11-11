package nondetermin;

import environment.Env;
import machine.IIExpression;

public interface INonRunObject {
	  Object run(Env env,ISucObject suc, IFailObject fail);
	  IIExpression getParent();
	  void setParent(IIExpression exp);
}
