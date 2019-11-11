package testsuite;

import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import environment.Env;
import expression.GenExpression;
import expression.LispLexer;
import expression.LispParser;
import machine.IIExpression;
import machine.Try;

public class TestExpression {

	@Test
	public void testif() throws Exception {
        ANTLRInputStream input = new ANTLRInputStream("(let ((a 5) (b 4.2)) (* a a) (+ 3 4))"); 
        // parse
        LispLexer lexer = new LispLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LispParser parser = new LispParser(tokens);
		ParseTree tree = parser.file(); 
		
		System.out.println(tree.toStringTree(parser));
		Env global = new Env();
		
		GenExpression<IIExpression> gen = new GenExpression<IIExpression>();
		IIExpression exp = (IIExpression) gen.visit(tree);
		//ParseTreeWalker walker = new ParseTreeWalker();
		//walker.walk(new ShortConvert(), tree);
		Object o =Try.interpret(exp,global);
		
		assertEquals(o,7);
	}
	
	@Test
	public void testcond() throws Exception {
        ANTLRInputStream input = new ANTLRInputStream("(cond 1 2 \n" + 
        		"  (else (/ 3 0))) "); 
        // parse
        LispLexer lexer = new LispLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LispParser parser = new LispParser(tokens);
		ParseTree tree = parser.file(); 
		
		System.out.println(tree.toStringTree(parser));
		Env global = new Env();
		
		GenExpression<IIExpression> gen = new GenExpression<IIExpression>();
		IIExpression exp = (IIExpression) gen.visit(tree);
		//ParseTreeWalker walker = new ParseTreeWalker();
		//walker.walk(new ShortConvert(), tree);
		Object o =Try.interpret(exp,global);
		
		assertEquals(o,2);
	}
	
	

	
	@Test
	public void testlambda() throws Exception {
	
		
        ANTLRInputStream input = new ANTLRInputStream(	"(define fact1 (lambda (n)\n" + 
											        		" (if (= n 1)\n" + 
											        		"     1\n" + 
											        		"     (* (fact1 (- n 1)) n))))"); 
        // parse
        LispLexer lexer = new LispLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LispParser parser = new LispParser(tokens);
		ParseTree tree = parser.file(); 
		
		System.out.println(tree.toStringTree(parser));
		Env global = new Env();
		
		GenExpression<IIExpression> gen = new GenExpression<IIExpression>();
		IIExpression exp = (IIExpression) gen.visit(tree);
		//ParseTreeWalker walker = new ParseTreeWalker();
		//walker.walk(new ShortConvert(), tree);
		Object o =Try.interpret(exp,global);
		
		assertEquals(o,"ok");
	}
	
}
