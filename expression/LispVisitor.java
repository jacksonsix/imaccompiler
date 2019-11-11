// Generated from /Users/bigtree/code/try/javacompiler/expression/Lisp.g4 by ANTLR 4.7.2
package expression;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LispParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LispVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LispParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(LispParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code define_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_expr(LispParser.Define_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code define_proc}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_proc(LispParser.Define_procContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(LispParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambda_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_expr(LispParser.Lambda_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code begin_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin_expr(LispParser.Begin_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code self_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf_expr(LispParser.Self_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compound_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_expr(LispParser.Compound_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code set_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_expr(LispParser.Set_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_expr(LispParser.Let_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_expr(LispParser.Cond_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(LispParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#defineproc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineproc(LispParser.DefineprocContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#setexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetexpr(LispParser.SetexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#ifexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfexpr(LispParser.IfexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(LispParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#begin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin(LispParser.BeginContext ctx);
	/**
	 * Visit a parse tree produced by the {@code self_id}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf_id(LispParser.Self_idContext ctx);
	/**
	 * Visit a parse tree produced by the {@code self_int}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf_int(LispParser.Self_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code self_float}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf_float(LispParser.Self_floatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#compound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound(LispParser.CompoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambda_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_comp(LispParser.Lambda_compContext ctx);
	/**
	 * Visit a parse tree produced by the {@code proc_name_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_name_comp(LispParser.Proc_name_compContext ctx);
	/**
	 * Visit a parse tree produced by the {@code proc_num_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProc_num_comp(LispParser.Proc_num_compContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#letexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetexpr(LispParser.LetexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(LispParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#condexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondexpr(LispParser.CondexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#switchexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchexpr(LispParser.SwitchexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#elsego}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsego(LispParser.ElsegoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(LispParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#formalParas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParas(LispParser.FormalParasContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#formalPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalPara(LispParser.FormalParaContext ctx);
}