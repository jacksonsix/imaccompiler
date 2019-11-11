// Generated from /Users/bigtree/code/try/javacompiler/expression/Lisp.g4 by ANTLR 4.7.2
package expression;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LispParser}.
 */
public interface LispListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LispParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(LispParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(LispParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code define_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDefine_expr(LispParser.Define_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code define_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDefine_expr(LispParser.Define_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code define_proc}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDefine_proc(LispParser.Define_procContext ctx);
	/**
	 * Exit a parse tree produced by the {@code define_proc}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDefine_proc(LispParser.Define_procContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIf_expr(LispParser.If_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIf_expr(LispParser.If_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambda_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambda_expr(LispParser.Lambda_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambda_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambda_expr(LispParser.Lambda_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code begin_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBegin_expr(LispParser.Begin_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code begin_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBegin_expr(LispParser.Begin_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code self_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSelf_expr(LispParser.Self_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code self_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSelf_expr(LispParser.Self_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compound_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompound_expr(LispParser.Compound_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compound_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompound_expr(LispParser.Compound_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code set_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSet_expr(LispParser.Set_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code set_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSet_expr(LispParser.Set_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code let_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLet_expr(LispParser.Let_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code let_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLet_expr(LispParser.Let_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCond_expr(LispParser.Cond_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond_expr}
	 * labeled alternative in {@link LispParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCond_expr(LispParser.Cond_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(LispParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(LispParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#defineproc}.
	 * @param ctx the parse tree
	 */
	void enterDefineproc(LispParser.DefineprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#defineproc}.
	 * @param ctx the parse tree
	 */
	void exitDefineproc(LispParser.DefineprocContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#setexpr}.
	 * @param ctx the parse tree
	 */
	void enterSetexpr(LispParser.SetexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#setexpr}.
	 * @param ctx the parse tree
	 */
	void exitSetexpr(LispParser.SetexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void enterIfexpr(LispParser.IfexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void exitIfexpr(LispParser.IfexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(LispParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(LispParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#begin}.
	 * @param ctx the parse tree
	 */
	void enterBegin(LispParser.BeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#begin}.
	 * @param ctx the parse tree
	 */
	void exitBegin(LispParser.BeginContext ctx);
	/**
	 * Enter a parse tree produced by the {@code self_id}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 */
	void enterSelf_id(LispParser.Self_idContext ctx);
	/**
	 * Exit a parse tree produced by the {@code self_id}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 */
	void exitSelf_id(LispParser.Self_idContext ctx);
	/**
	 * Enter a parse tree produced by the {@code self_int}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 */
	void enterSelf_int(LispParser.Self_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code self_int}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 */
	void exitSelf_int(LispParser.Self_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code self_float}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 */
	void enterSelf_float(LispParser.Self_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code self_float}
	 * labeled alternative in {@link LispParser#self}.
	 * @param ctx the parse tree
	 */
	void exitSelf_float(LispParser.Self_floatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#compound}.
	 * @param ctx the parse tree
	 */
	void enterCompound(LispParser.CompoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#compound}.
	 * @param ctx the parse tree
	 */
	void exitCompound(LispParser.CompoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambda_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 */
	void enterLambda_comp(LispParser.Lambda_compContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambda_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 */
	void exitLambda_comp(LispParser.Lambda_compContext ctx);
	/**
	 * Enter a parse tree produced by the {@code proc_name_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 */
	void enterProc_name_comp(LispParser.Proc_name_compContext ctx);
	/**
	 * Exit a parse tree produced by the {@code proc_name_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 */
	void exitProc_name_comp(LispParser.Proc_name_compContext ctx);
	/**
	 * Enter a parse tree produced by the {@code proc_num_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 */
	void enterProc_num_comp(LispParser.Proc_num_compContext ctx);
	/**
	 * Exit a parse tree produced by the {@code proc_num_comp}
	 * labeled alternative in {@link LispParser#op}.
	 * @param ctx the parse tree
	 */
	void exitProc_num_comp(LispParser.Proc_num_compContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#letexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetexpr(LispParser.LetexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#letexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetexpr(LispParser.LetexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(LispParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(LispParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#condexpr}.
	 * @param ctx the parse tree
	 */
	void enterCondexpr(LispParser.CondexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#condexpr}.
	 * @param ctx the parse tree
	 */
	void exitCondexpr(LispParser.CondexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#switchexpr}.
	 * @param ctx the parse tree
	 */
	void enterSwitchexpr(LispParser.SwitchexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#switchexpr}.
	 * @param ctx the parse tree
	 */
	void exitSwitchexpr(LispParser.SwitchexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#elsego}.
	 * @param ctx the parse tree
	 */
	void enterElsego(LispParser.ElsegoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#elsego}.
	 * @param ctx the parse tree
	 */
	void exitElsego(LispParser.ElsegoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(LispParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(LispParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#formalParas}.
	 * @param ctx the parse tree
	 */
	void enterFormalParas(LispParser.FormalParasContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#formalParas}.
	 * @param ctx the parse tree
	 */
	void exitFormalParas(LispParser.FormalParasContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#formalPara}.
	 * @param ctx the parse tree
	 */
	void enterFormalPara(LispParser.FormalParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#formalPara}.
	 * @param ctx the parse tree
	 */
	void exitFormalPara(LispParser.FormalParaContext ctx);
}