package testsuite;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import environment.Env;
import expression.GenExpression;
import expression.LispLexer;
import expression.LispParser;
import lazyEval.TryLazy;
import machine.IIExpression;


public class TestLazy {

	    @Test
	    public   void simple()  throws Exception{
	        ANTLRInputStream input = new ANTLRInputStream("(define count 0)\n" + 
											        		"(define (id x)\n" + 
											        		" (set! count (+ count 1))\n" + 
											        		" x)\n" + 
											        		" \n" + 
											        		" (define w (id (id 10)))\n" +
											        		"count\n" +
											        		"w\n"+
											        		"count"); 
	        // parse
	        LispLexer lexer = new LispLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			LispParser parser = new LispParser(tokens);
			ParseTree tree = parser.file(); 
			
			System.out.println(tree.toStringTree(parser));
			Env global = new Env();
			
			GenExpression<IIExpression> gen = new GenExpression<IIExpression>();
			IIExpression exp = (IIExpression) gen.visit(tree.getChild(0));

			Object o =TryLazy.interpret(exp,global);
			assertEquals(o,"ok");
			
			IIExpression exp1 = (IIExpression) gen.visit(tree.getChild(1));
			Object o1 =TryLazy.interpret(exp1,global);
			assertEquals(o1,"ok");
			
			IIExpression exp2 = (IIExpression) gen.visit(tree.getChild(2));
			Object o2 =TryLazy.interpret(exp2,global);
			assertEquals(o2,"ok");
			
			IIExpression exp3 = (IIExpression) gen.visit(tree.getChild(3));
			Object o3 =TryLazy.interpret(exp3,global);
			assertEquals(o3,1);
			
			IIExpression exp4 = (IIExpression) gen.visit(tree.getChild(4));
			Object o4 =TryLazy.interpret(exp4,global);
			assertEquals(o4,10);

			
			IIExpression exp5 = (IIExpression) gen.visit(tree.getChild(5));
			Object o5 =TryLazy.interpret(exp5,global);
			assertEquals(o5,2);


	    }
}
