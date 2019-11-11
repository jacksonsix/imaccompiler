package analyzer;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import analyzer.LispdebugParser.EndContext;
import analyzer.LispdebugParser.ExprContext;
import analyzer.LispdebugParser.FileContext;
import analyzer.LispdebugParser.OpenContext;
import expression.LispBaseVisitor;

public class PrettyPrint<String> extends LispdebugBaseVisitor<String>{
    int level =0;
    List<String> data;
    public List<String> getData(){
    	return this.data;
    }
    public void inc() {
    	this.level++;
    }
    public void dec() {
    	this.level--;
    }
    public int getLevel() {
    	return this.level;
    }
    public PrettyPrint(){
    	data = new LinkedList<String>();
    }
    
	@Override
	public String visitFile(FileContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFile(ctx);
	}

	@Override
	public String visitExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpr(ctx);
	}

	@Override
	public String visitOpen(OpenContext ctx) {
		// TODO Auto-generated method stub
		inc();
		//String f = (String) (level +":" + ctx.getText());
		String e = (String) (level +":" + "(" + ctx.INT().getText() + " " + ctx.ID().getText());
		data.add(e);
		//String text = ctx.getText().toString();
		return null;
	}

	@Override
	public String visitEnd(EndContext ctx) {
		// TODO Auto-generated method stub
		
		String e = (String) (level +":" + ctx.getText());
		dec();
		data.add(e);
		return null;
	}

	@Override
	public String visit(ParseTree tree) {
		// TODO Auto-generated method stub
		return super.visit(tree);
	}

	



}
