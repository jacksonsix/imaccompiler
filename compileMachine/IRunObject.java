package compileMachine;

import environment.Env;
import machine.IIExpression;

public interface IRunObject {
  Object run(Env env);
  IIExpression getParent();
  void setParent(IIExpression exp);
}
