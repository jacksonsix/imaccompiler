package compileMachine;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import environment.Env;
import machine.PrimitiveProc;
import machine.SelfExpression;

public class AnalyzeMethods{
	static List<PrimitiveProc> prims;
	public static List<PrimitiveProc> collectPrim() throws NoSuchMethodException, SecurityException{
		prims = new LinkedList<PrimitiveProc>();		
		
		Class[] parameterTypes = new Class[1];
        parameterTypes[0] = AnalyzeMethods.class;

		Method method1 = AnalyzeMethods.class.getMethod("car", parameterTypes);
		PrimitiveProc prim1 = new PrimitiveProc("car",method1);
		prims.add(prim1);
		
		Method method2 = AnalyzeMethods.class.getMethod("cdr", parameterTypes);
		PrimitiveProc prim2 = new PrimitiveProc("cdr",method2);
		prims.add(prim2);	
		
		Class[] parameterTypes3 = new Class[2];
        parameterTypes3[0] = Object.class;
        parameterTypes3[1] = Object.class;
		Method method3 = AnalyzeMethods.class.getMethod("cons", parameterTypes3);
		PrimitiveProc prim3 = new PrimitiveProc("cons",method3);
		prims.add(prim3);
		
		addOther();
		return prims;
		
		
	}
	
	private static void addOther() throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Class[] parameterTypes = new Class[2];
		parameterTypes[0] = Integer.class;
		parameterTypes[1] = Integer.class;
		Method madd = AnalyzeMethods.class.getMethod("add", parameterTypes);
		PrimitiveProc proc = new PrimitiveProc("+",madd);
		prims.add(proc);

		Method subadd = AnalyzeMethods.class.getMethod("subtract", parameterTypes);
		PrimitiveProc proc1 = new PrimitiveProc("-",subadd);
		prims.add(proc1);
		
	}

	public static  Object analyze_self(Env env){
		return null;
	}
	public static  Object analyze_quoted(Object o){
		return null;
	}
	public static  Object analyze_variable(Object o){
		return null;
	}
	
	
}


/*
 *     Object[] parameters = new Object[1];
        parameters[0] = message;
        method.invoke(object, parameters);
 */

