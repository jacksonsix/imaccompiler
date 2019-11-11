package environment;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import machine.LispObject;
import machine.PrimitiveProc;

public class LowerBox {
	static List<PrimitiveProc> prims;
	public static List<PrimitiveProc> collectPrim() throws NoSuchMethodException, SecurityException{
		prims = new LinkedList<PrimitiveProc>();		
		
		Class[] parameterTypes = new Class[1];
        parameterTypes[0] = LispObject.class;

		Method method1 = LowerBox.class.getMethod("car", parameterTypes);
		PrimitiveProc prim1 = new PrimitiveProc("car",method1);
		prims.add(prim1);
		
		Method method2 = LowerBox.class.getMethod("cdr", parameterTypes);
		PrimitiveProc prim2 = new PrimitiveProc("cdr",method2);
		prims.add(prim2);	
		
		Class[] parameterTypes3 = new Class[2];
        parameterTypes3[0] = Object.class;
        parameterTypes3[1] = Object.class;
		Method method3 = LowerBox.class.getMethod("cons", parameterTypes3);
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
		Method madd = LowerBox.class.getMethod("add", parameterTypes);
		PrimitiveProc proc = new PrimitiveProc("+",madd);
		prims.add(proc);

		Method subadd = LowerBox.class.getMethod("subtract", parameterTypes);
		PrimitiveProc proc1 = new PrimitiveProc("-",subadd);
		prims.add(proc1);
		

		Method multi = LowerBox.class.getMethod("multi", parameterTypes);
		PrimitiveProc proc2 = new PrimitiveProc("*",multi);
		prims.add(proc2);

		Method equ = LowerBox.class.getMethod("equ", parameterTypes);
		PrimitiveProc proc3 = new PrimitiveProc("=",equ);
		prims.add(proc3);
		
		
	}

	public static  Object car(LispObject o){
		return o.getCar();
	}
	
	public static Object cdr(LispObject o){
		return o.getCdr();
	}
	public static LispObject cons(Object f,Object s){
		return new LispObject(f,s);
	}
	public static int add(Integer a , Integer b) {
		return a+b;
	}
	public static int subtract(Integer a ,Integer b) {
		return a-b;
	}
	public static int multi(Integer a ,Integer b) {
		return a*b;
	}
	public static boolean equ(Integer a ,Integer b) {
		return a.intValue() == b.intValue();
	}
}


/*
 *     Object[] parameters = new Object[1];
        parameters[0] = message;
        method.invoke(object, parameters);
 */
