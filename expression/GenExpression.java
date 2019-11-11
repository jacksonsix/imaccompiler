package expression;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import expression.LispParser.ArgsContext;
import expression.LispParser.BeginContext;
import expression.LispParser.Begin_exprContext;
import expression.LispParser.CompoundContext;
import expression.LispParser.Compound_exprContext;
import expression.LispParser.Cond_exprContext;
import expression.LispParser.CondexprContext;
import expression.LispParser.DefineContext;
import expression.LispParser.Define_exprContext;
import expression.LispParser.Define_procContext;
import expression.LispParser.ElsegoContext;
import expression.LispParser.FileContext;
import expression.LispParser.FormalParaContext;
import expression.LispParser.FormalParasContext;
import expression.LispParser.If_exprContext;
import expression.LispParser.IfexprContext;
import expression.LispParser.LambdaContext;
import expression.LispParser.Lambda_compContext;
import expression.LispParser.Lambda_exprContext;
import expression.LispParser.Let_exprContext;
import expression.LispParser.LetexprContext;
import expression.LispParser.OpContext;
import expression.LispParser.PairContext;
import expression.LispParser.Proc_name_compContext;
import expression.LispParser.Proc_num_compContext;
import expression.LispParser.Self_exprContext;
import expression.LispParser.Self_floatContext;
import expression.LispParser.Self_idContext;
import expression.LispParser.Self_intContext;
import expression.LispParser.Set_exprContext;
import expression.LispParser.SetexprContext;
import expression.LispParser.SwitchexprContext;
import machine.*;

public class GenExpression<IIExpression> extends LispBaseVisitor<IIExpression>{

	public IIExpression visitDefine_expr(Define_exprContext ctx) {
		DefineExpression dexp = new DefineExpression();
		String name = ctx.define().getChild(2).getText();
		machine.IIExpression val = (machine.IIExpression) visit(ctx.define().getChild(3));
	
		dexp.setName(name);
		dexp.setVal(val);
		dexp.setLine(ctx.define().start.getLine());
		dexp.setPos(ctx.define().start.getCharPositionInLine());
		dexp.setText(ctx.define().getText());
		
		val.setParent(dexp.hashCode());
		return  (IIExpression) dexp;
	}

	
	@Override
	public IIExpression visitDefine_proc(Define_procContext ctx) {
		// same as lambda define, return lambdaExpression here
		
		List<String> paras = new LinkedList<String>();
		int size = ctx.defineproc().formalParas().getChildCount();
		for(int i=0;i<size;i++) {
			String ex =  ctx.defineproc().formalParas().getChild(i).getText();
			paras.add(ex);
		}
		int bsize = ctx.defineproc().expr().size();
	    List<machine.IIExpression> body = new LinkedList<machine.IIExpression>();
		for(int i=0;i<bsize;i++) {
			machine.IIExpression e = (machine.IIExpression) visit(ctx.defineproc().expr(i));
			body.add(e);
			
		}
		LambdaExpression lamb = new LambdaExpression(paras,body);
		
		DefineExpression dexp = new DefineExpression();
		String name = ctx.defineproc().ID().getText();
		dexp.setName(name);
		dexp.setVal(lamb);
		dexp.setLine(ctx.defineproc().start.getLine());
		dexp.setPos(ctx.defineproc().start.getCharPositionInLine());
		dexp.setText(ctx.defineproc().getText());
		
		lamb.setParent(dexp.hashCode());
		return (IIExpression) dexp;
	}

	@Override
	public IIExpression visitIf_expr(If_exprContext ctx) {

		machine.IIExpression pexp = (machine.IIExpression) visit(ctx.ifexpr().getChild(2));
		machine.IIExpression rexp = (machine.IIExpression) visit(ctx.ifexpr().getChild(3));
		machine.IIExpression aexp = (machine.IIExpression) visit(ctx.ifexpr().getChild(4));
		IfExpression ifex = new IfExpression(pexp,rexp,aexp);
		ifex.setLine(ctx.ifexpr().start.getLine());
		ifex.setPos(ctx.ifexpr().start.getCharPositionInLine());
		ifex.setText(ctx.ifexpr().getText());
		
		pexp.setParent(ifex.hashCode());
		rexp.setParent(ifex.hashCode());
		aexp.setParent(ifex.hashCode());
		
		return (IIExpression) ifex;
	}

	@Override
	public IIExpression visitSet_expr(Set_exprContext ctx) {
		SetExpression dexp = new SetExpression();
		String name = ctx.setexpr().getChild(2).getText();
		machine.IIExpression val = (machine.IIExpression) visit(ctx.setexpr().getChild(3));
		dexp.setName(name);
		dexp.setVal(val);
		dexp.setLine(ctx.setexpr().start.getLine());
		dexp.setPos(ctx.setexpr().start.getCharPositionInLine());
		dexp.setText(ctx.setexpr().getText());
		
		val.setParent(dexp.hashCode());
		return  (IIExpression) dexp;
		
	}

	@Override
	public IIExpression visitSetexpr(SetexprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSetexpr(ctx);
	}

	@Override
	public IIExpression visitLambda_expr(Lambda_exprContext ctx) {
		//machine.IIExpression parafrom = (machine.IIExpression) visit(ctx.lambda().getChild(3));
		List<String> para = new LinkedList<String>();
		ParseTree pas = ctx.lambda().getChild(3);
		for(int i=0;i< pas.getChildCount();i++) {
			para.add(pas.getChild(i).getText());
		}
		List<machine.IIExpression> body = new LinkedList<machine.IIExpression>();
		//(IIExpression) visit(ctx.lambda().getChild(0));
		
		for(int i=0;i<ctx.lambda().getChildCount()-6;i++) {
			ParseTree node = ctx.lambda().getChild(5+i);
			machine.IIExpression bo = (machine.IIExpression) visit(node);
			body.add(bo);
		}
		LambdaExpression result =   new LambdaExpression(para,body);
		result.setLine(ctx.lambda().start.getLine());
		result.setPos(ctx.lambda().start.getCharPositionInLine());
		result.setText(ctx.lambda().getText());
		return (IIExpression) result;
	}

	@Override
	public IIExpression visitBegin_expr(Begin_exprContext ctx) {
		
		List<machine.IIExpression> seq = new LinkedList<machine.IIExpression>(); //
		
		ParseTree node = ctx.begin().getChild(2);
		for(int i=0;i< node.getChildCount();i++) {
			seq.add((machine.IIExpression) visit(node.getChild(i)));
		}
		BeginExpression result =  new BeginExpression(seq);
		result.setLine(ctx.begin().start.getLine());
		result.setPos(ctx.begin().start.getCharPositionInLine());
		result.setText(ctx.begin().getText());
		return (IIExpression) result;
	}

	@Override
	public IIExpression visitSelf_expr(Self_exprContext ctx) {
		// TODO Auto-generated method stub		
		return  visit(ctx.getChild(0));
	}

	@Override
	public IIExpression visitCompound_expr(Compound_exprContext ctx) {
		// TODO Auto-generated method stub
		
		machine.IIExpression op =  (machine.IIExpression) visit(ctx.compound().getChild(1));
		List<machine.IIExpression>  plist = new LinkedList<machine.IIExpression>();//
		ParseTree node = ctx.compound().getChild(2);
		for(int i=0;i< node.getChildCount();i++) {
			plist.add((machine.IIExpression) visit(node.getChild(i)));
		}
		CompoundExpression result =  new CompoundExpression(op,plist);
		result.setLine(ctx.compound().start.getLine());
		result.setPos(ctx.compound().start.getCharPositionInLine());
		result.setText(ctx.compound().getText());
		
		op.setParent(result.hashCode());
		
		return (IIExpression) result;
	}


	@Override
	public IIExpression visitSelf_id(Self_idContext ctx) {
		// TODO Auto-generated method stub
		SymbolExpression s = new SymbolExpression(ctx.getChild(0).getText());
		
		s.setText(ctx.ID().getText());
		return (IIExpression) s;
	}

	@Override
	public IIExpression visitSelf_int(Self_intContext ctx) {
		// TODO Auto-generated method stub
		
		SelfExpression s =  new SelfExpression(Integer.valueOf(ctx.getChild(0).getText()));
		s.setText(ctx.INT().getText());
		return (IIExpression) s;
	}
	


	@Override
	public IIExpression visitSelf_float(Self_floatContext ctx) {
		
		SelfExpression s= new SelfExpression(Float.valueOf(ctx.getChild(0).getText()));
		s.setText(ctx.FLOAT().getText());
		return (IIExpression) s;
	}

	@Override
	public IIExpression visitCompound(CompoundContext ctx) {
		// TODO Auto-generated method stub
		
		machine.IIExpression op =  (machine.IIExpression) visit(ctx.getChild(1));
		List<machine.IIExpression>  plist = new LinkedList<machine.IIExpression>();//
		ParseTree node = ctx.getChild(2);
		for(int i=0;i< node.getChildCount();i++) {
			plist.add((machine.IIExpression) visit(node.getChild(i)));
		}
		IIExpression result = (IIExpression) new CompoundExpression(op,plist);
		return result;
		
	}



	@Override
	public IIExpression visitFile(FileContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFile(ctx);
	}

	@Override
	public IIExpression visitLambda_comp(Lambda_compContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLambda_comp(ctx);
	}

	@Override
	public IIExpression visitProc_name_comp(Proc_name_compContext ctx) {
		// TODO Auto-generated method stub

		String name = ctx.getChild(0).getText();
		SymbolExpression v = new SymbolExpression(name);
		return (IIExpression) v;
	}

	@Override
	public IIExpression visitProc_num_comp(Proc_num_compContext ctx) {
		// TODO Auto-generated method stub
		String name = ctx.getChild(0).getText();
		SymbolExpression v = new SymbolExpression(name);
		return (IIExpression)v;
	}

	@Override
	public IIExpression visitFormalParas(FormalParasContext ctx) {
		
		SequenceExpression seq = new SequenceExpression();
		int size = ctx.getChildCount();
		List<IIExpression> s = new LinkedList<IIExpression>();
		
		for(int i=0;i<size;i++) {
			IIExpression  sef = visit(ctx.getChild(i));
			s.add((IIExpression) sef);
		}
		
		return (IIExpression) seq;
	}

	@Override
	public IIExpression visitLet_expr(Let_exprContext ctx) {
		LetExpression let = new LetExpression();
		List<XPair> ps = new LinkedList<XPair>();
		List<machine.IIExpression> bodys = new LinkedList<machine.IIExpression>();
		int psize = ctx.letexpr().pair().size();
		for(int j=0;j<psize;j++) {
			IIExpression p = visit(ctx.letexpr().pair().get(j));
			ps.add( (XPair) p);
		}
		int bsize = ctx.letexpr().expr().size();
		for(int i=0;i<bsize;i++) {
			IIExpression  sef = (IIExpression) visit(ctx.letexpr().expr().get(i));
			bodys.add((machine.IIExpression) sef);
		}
		
		let.setBody(bodys);
		let.setPairs(ps);
		let.setLine(ctx.letexpr().start.getLine());
		let.setPos(ctx.letexpr().start.getCharPositionInLine());
		let.setText(ctx.letexpr().getText());
		return (IIExpression) let;
	}

	@Override
	public IIExpression visitCond_expr(Cond_exprContext ctx) {
		//ctx.condexpr().getChild(3);
		List<machine.IIExpression> switches = new LinkedList<machine.IIExpression>();
		int size = ctx.condexpr().switchexpr().size();
		for(int i =0;i<size;i++) {
			IIExpression ex = visit(ctx.condexpr().switchexpr().get(i));
			switches.add((machine.IIExpression) ex);
		}
		machine.IIExpression elsego = (machine.IIExpression) visit(ctx.condexpr().elsego().expr());
		CondExpression cond = new CondExpression(switches,elsego);
		cond.setLine(ctx.condexpr().start.getLine());
		cond.setPos(ctx.condexpr().start.getCharPositionInLine());
		cond.setText(ctx.condexpr().getText());
		return  (IIExpression) cond;
	}

	@Override
	public IIExpression visitLetexpr(LetexprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLetexpr(ctx);
	}

	@Override
	public IIExpression visitPair(PairContext ctx) {
		int s = ctx.getChildCount();
		String ss = ctx.getText();
		String name = ctx.getChild(1).getText();
		IIExpression value = visit(ctx.getChild(2));
		XPair<String,IIExpression> p = new XPair<String,IIExpression>(name,value);

		return (IIExpression) p;
	}



	@Override
	public IIExpression visitSwitchexpr(SwitchexprContext ctx) {
		//ctx.expr().get(0);
		String t = ctx.expr().get(0).getText();
		String r = ctx.expr().get(1).getText();
		IIExpression pred = visit(ctx.expr().get(0));
		IIExpression result = visit(ctx.expr().get(1));
		XPair<IIExpression,IIExpression> branch = new XPair<IIExpression,IIExpression>(pred,result);
		return (IIExpression) branch;
	}

	@Override
	public IIExpression visitElsego(ElsegoContext ctx) {
		String e = ctx.expr().getText();
		IIExpression ex = visit(ctx.expr());
		return ex;
	}

	@Override
	public IIExpression visitFormalPara(FormalParaContext ctx) {
		// TODO Auto-generated method stub
		return (IIExpression) new SelfExpression(ctx.getChild(0).getText());
	}

	@Override
	public IIExpression visitArgs(ArgsContext ctx) {
		// TODO Auto-generated method stub
		
		SequenceExpression seq = new SequenceExpression();
		int size = ctx.getChildCount();
		List<IIExpression> s = new LinkedList<IIExpression>();
		
		for(int i=0;i<size;i++) {
			IIExpression  sef = (IIExpression) visit(ctx.getChild(i));
			s.add(sef);
		}
		
		return (IIExpression) seq;
	}

	@Override
	public IIExpression visit(ParseTree tree) {
		// TODO Auto-generated method stub
		return super.visit(tree);
	}

	@Override
	public IIExpression visitChildren(RuleNode node) {
		// TODO Auto-generated method stub
		return super.visitChildren(node);
	}

	@Override
	public IIExpression visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		return super.visitTerminal(node);
	}

	@Override
	public IIExpression visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		return super.visitErrorNode(node);
	}

	@Override
	protected IIExpression defaultResult() {
		// TODO Auto-generated method stub
		return super.defaultResult();
	}

	@Override
	protected IIExpression aggregateResult(IIExpression aggregate, IIExpression nextResult) {
		// TODO Auto-generated method stub
		return super.aggregateResult(aggregate, nextResult);
	}

	@Override
	protected boolean shouldVisitNextChild(RuleNode node, IIExpression currentResult) {
		// TODO Auto-generated method stub
		return super.shouldVisitNextChild(node, currentResult);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	

}
