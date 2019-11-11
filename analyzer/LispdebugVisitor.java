// Generated from /Users/bigtree/code/try/javacompiler/analyzer/Lispdebug.g4 by ANTLR 4.7.2
package analyzer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LispdebugParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LispdebugVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LispdebugParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(LispdebugParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispdebugParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LispdebugParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispdebugParser#open}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen(LispdebugParser.OpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispdebugParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(LispdebugParser.EndContext ctx);
}