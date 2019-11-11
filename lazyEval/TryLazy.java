package lazyEval;


import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import analyzer.LispShow;
import environment.Env;
import environment.LowerBox;
import expression.GenExpression;
import expression.LispLexer;
import expression.LispParser;
import machine.*;

public class TryLazy {
	public static void main(String[] args) throws Exception{
		LazyEval evmachine = new LazyEval();
		evmachine.clearfile();
		simple();
		 LispShow.main();
		
	}
	public static Object interpret(IIExpression exp, Env global) throws Exception {
		LazyEval evmachine = new LazyEval();
		Object o = evmachine.eval(exp, global);
		LazyEval.writefile("3.txt", evmachine.getHistory());
		return evmachine.forceit(o);
	}
	
	
	
    private static void simple()  throws Exception{
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("/Users/bigtree/code/try/javacompiler/expression/test.scm")); // we'll
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

			Object o =TryLazy.interpret(exp,global);
			System.out.println(o);
			System.out.println("next expression!");
		}
		
		

    }

}
