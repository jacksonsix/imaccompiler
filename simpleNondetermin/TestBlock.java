package simpleNondetermin;

import java.util.LinkedList;
import java.util.List;

public class TestBlock {
	
	// function (cur path)  return  next success path
	public static void main(String[] args) {
		List<Express> codes = preparedata();
		Block start = buildAll(codes);
		start.build("");
		
	}
	
	private static Block buildAll(List<Express> data) {
		Block head = null;
		Express ex = data.get(0);
		head = new Block(ex);
		
		Block cur = null;
		cur = head;
		for(int i=1;i< data.size();i++) {
			Express ex1 = data.get(i);
		    Block next = new Block(ex1);
		    connect(cur,next);
		    cur = next;
		    
		}
		
		return head;
	}
	private static void connect(Block a, Block b) {
		a.setNext(b);
		b.setPrev(a);
	}
	
	
	private static List<Express> preparedata(){
		String a = "1,2,3,8";
		String b = "4,5,9";
		String c ="6,7";
		String d ="a,d";
		List<Express> initd = new LinkedList<Express>();
		initd.add(new Express(a));
		initd.add(new Express(b));
		initd.add(new Express(c));
		initd.add(new Express(d));
		return initd;
		
	}

}
