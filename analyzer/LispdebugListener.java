// Generated from /Users/bigtree/code/try/javacompiler/analyzer/Lispdebug.g4 by ANTLR 4.7.2
package analyzer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LispdebugParser}.
 */
public interface LispdebugListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LispdebugParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(LispdebugParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispdebugParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(LispdebugParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispdebugParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LispdebugParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispdebugParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LispdebugParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispdebugParser#open}.
	 * @param ctx the parse tree
	 */
	void enterOpen(LispdebugParser.OpenContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispdebugParser#open}.
	 * @param ctx the parse tree
	 */
	void exitOpen(LispdebugParser.OpenContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispdebugParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(LispdebugParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispdebugParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(LispdebugParser.EndContext ctx);
}