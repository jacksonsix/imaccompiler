package testsuite;
import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import environment.Env;
import environment.LowerBox;
import expression.GenExpression;
import expression.LispLexer;
import expression.LispParser;
import machine.CompoundExpression;
import machine.EV;
import machine.IIExpression;
import machine.LambdaExpression;
import machine.LispObject;
import machine.PrimitiveProc;
import machine.SelfExpression;
import machine.SymbolExpression;
import machine.Try;

public class TestMachine {

	
	  @Test
	  public void evaluatesExpression() {
	    //Calculator calculator = new Calculator();
	    int sum = 7;
	    assertEquals(7, sum);
	  }
	 @Test 
	 public  void testprimfuncs() throws Exception{
		 Env global = new Env();   
		 Object me = global.search("car");
	        PrimitiveProc prim = (PrimitiveProc)me;
	        LispObject lo = new LispObject(new SelfExpression(2),new SelfExpression("23"));
	        
	        
	        Object[] parameters = new Object[1];
	        parameters[0] =  lo;
	        Object test = prim.getProc().invoke(LowerBox.class,parameters);
	        
	        Object cons = global.search("cons");
	        PrimitiveProc prim1 = (PrimitiveProc)cons;
	        
	        Object[] parameters1 = new Object[2];
	        parameters1[0] = new SelfExpression(44);
	        parameters1[1] = new SelfExpression("next");
	        LispObject newone = (LispObject)prim1.getProc().invoke(LowerBox.class, parameters1);
	        
		    //assertEquals(newone,null);
	}
	 @Test
	 public  void testdeepcopy() throws InstantiationException, IllegalAccessException{
			List<IIExpression> paras = new LinkedList<IIExpression>();
			paras.add(new SelfExpression(3.4));
			CompoundExpression exp = new CompoundExpression(new SelfExpression(1),paras);
			Object o = IIExpression.deepcopy(exp);
	}
	    @Test
	    public   void simple()  throws Exception{
	        ANTLRInputStream input = new ANTLRInputStream("(define (fact n)\n" + 
											        		" (if (= n 1)\n" + 
											        		"     1\n" + 
											        		"     (* (fact (- n 1)) n)))\n" + 
											        		"    \n" + 
											        		"(fact 4)  "); 
	        // parse
	        LispLexer lexer = new LispLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			LispParser parser = new LispParser(tokens);
			ParseTree tree = parser.file(); 
			
			System.out.println(tree.toStringTree(parser));
			Env global = new Env();
			int len = tree.getChildCount();
			for(int i=0;i<len;i++) {
				GenExpression<IIExpression> gen = new GenExpression<IIExpression>();
				IIExpression exp = (IIExpression) gen.visit(tree.getChild(i));

				Object o =Try.interpret(exp,global);
				
			}
			

	    }
		
		private static void testprimfuncs(Env global) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			    Object me = global.search("car");
		        PrimitiveProc prim = (PrimitiveProc)me;
		        LispObject lo = new LispObject(new SelfExpression(2),new SelfExpression("23"));
		        
		        
		        Object[] parameters = new Object[1];
		        parameters[0] =  lo;
		        Object test = prim.getProc().invoke(LowerBox.class,parameters);
		        
		        Object cons = global.search("cons");
		        PrimitiveProc prim1 = (PrimitiveProc)cons;
		        
		        Object[] parameters1 = new Object[2];
		        parameters1[0] = new SelfExpression(44);
		        parameters1[1] = new SelfExpression("next");
		        LispObject newone = (LispObject)prim1.getProc().invoke(LowerBox.class, parameters1);
		        
			
		}
		
		private static void testcompundexp(EV evmachine,Env global){
			// 
			LispObject lo = new LispObject(new SelfExpression(2),new SelfExpression("23"));
			global.defineVarible("d", lo);
			
			SymbolExpression op = new SymbolExpression("cdr");		
			
			List<IIExpression> paras = new LinkedList<IIExpression>();				
			SymbolExpression obj = new SymbolExpression("d");		
			paras.add(obj);
			
			CompoundExpression exp = new CompoundExpression(op,paras);
			try {
				Object o = evmachine.eval(exp,global);
				System.out.println(o.getClass().getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private static void testcompundexp2(EV evmachine,Env global){
			// 
			LispObject lo = new LispObject(new SelfExpression(2),new SelfExpression("23"));
			global.defineVarible("d", lo);
			
			SelfExpression se = new SelfExpression(8);
			global.defineVarible("second", se);
			
			SymbolExpression op = new SymbolExpression("cons");		
			
			List<IIExpression> paras = new LinkedList<IIExpression>();				
			SymbolExpression obj = new SymbolExpression("d");		
			
			paras.add(obj);
			paras.add(se);
			
			CompoundExpression exp = new CompoundExpression(op,paras);
			try {
				Object o = evmachine.eval(exp,global);
				System.out.println(o.getClass().getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private static void testenv(EV evmachine,Env global) throws Exception{
			// 
			LispObject lo = new LispObject(new SelfExpression(2),new SelfExpression("23"));
			global.defineVarible("d", lo);
			
			SelfExpression se = new SelfExpression(8);
			global.setVarible("d", se);
			
			List<String> ns = new LinkedList<String>();
			List<Object> os = new  LinkedList<Object>();
			ns.add("f");
			os.add( new Integer(3));
			Env ext = global.Extend(global, ns, os,123);
		
			List<String> ns1 = new LinkedList<String>();
			List<Object> os1 = new  LinkedList<Object>();
			ns1.add("ff");
			os1.add( new Integer(3));
			Env ext1 = global.Extend(ext, ns1, os1,234);

		}
		private static void testlambda(EV evmachine,Env global) throws Exception{	
			List<String> paras = new LinkedList<String>();
			List<IIExpression> body = new LinkedList<IIExpression>();
			body.add(new SelfExpression(3));
			LambdaExpression exp = new LambdaExpression(paras,body);
			Object o = evmachine.eval(exp,global);

		}
		private static void testlambcomp(EV evmachine,Env global) throws Exception{
			List<String> paras = new LinkedList<String>();
			List<IIExpression> body = new LinkedList<IIExpression>();
			body.add(new SelfExpression(3));
			LambdaExpression exp = new LambdaExpression(paras,body);
			//Object o = evmachine.eval(exp,global);
			//VaribleExpression vexp = new VaribleExpression("l1");
			//vexp.setValue(evmachine.eval(exp,global));
			//List<IExpression> empty = new List<IExpression>();
			CompoundExpression cexp = new CompoundExpression(exp,null);
			Object o = evmachine.eval(cexp,global);
		}
		
}
