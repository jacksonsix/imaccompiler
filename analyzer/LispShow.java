package analyzer;

import java.io.FileInputStream;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import environment.Env;
import expression.GenExpression;
import expression.LispLexer;
import expression.LispParser;
import machine.EV;
import machine.IIExpression;
import machine.Try;

public class LispShow {
	
	
	public static void main() throws Exception {
		//genClass();
		simple(); // parse 3.txt history data, and put to 4.txt
		
	}
	
	@SuppressWarnings("deprecation")
    public static void genClass() {
        String[] arg0 = { "-visitor", "/Users/bigtree/code/try/javacompiler/analyzer/Lispdebug.g4", "-package", "analyzer" };
        org.antlr.v4.Tool.main(arg0);
        
    }
	
    private static void simple()  throws Exception{
    	String folder ="/Users/bigtree/Documents/scriptwork/";
    	
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(folder + "3.txt")); // we'll
        // parse
        LispdebugLexer lexer = new LispdebugLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LispdebugParser parser = new LispdebugParser(tokens);
		ParseTree tree = parser.file(); 
		
		//System.out.println(tree.toStringTree(parser));
		Env global = new Env();
		int len = tree.getChildCount();
		for(int i=0;i<len;i++) {
			PrettyPrint<String> gen = new PrettyPrint<String>();
			String exp = (String) gen.visit(tree.getChild(i));

			List<String> data = gen.getData();
			print(data);
			
		}

    }
    
    private static void print(List<String> data) throws Exception {
    	for(String s: data) {
    		StringBuilder sb = new StringBuilder();
    		String[] parts = s.split(":");
    		int size = Integer.valueOf(parts[0]);
    		for(int i=0;i<size;i++) {sb.append("  ");};
    		sb.append(parts[1]);
    		
    		EV.writefile("4.txt", sb.toString());
    	}
    	
    }
}
