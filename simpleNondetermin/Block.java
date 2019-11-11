package simpleNondetermin;

import java.util.LinkedList;
import java.util.List;




public class Block {
	List<String> data;
	List<String> choices;
	Block next;
	Block prev;
	Success suc;
	Fail fail;
	String cur;
	String parts;
	
	public void log(String info) {
		System.out.println(info);
	}
	
	public Block(Express exp) {
		data = new LinkedList<String>(exp.getData());
		choices = new LinkedList<String>(exp.getData());
		next = null;
		prev = null;
		suc = new Success(this);
		fail = new Fail(this);
		parts ="";
	}
	
	public void build(String partial) {
		// no more choices
		this.parts = partial;
		
		if(choices.size() <1) {
			fail.fail();
			log("no choices");
		}else {
		    cur = choices.get(0);
			choices.remove(0);
			
			suc.success(cur,partial, fail);
			
		}
		
	}

	public void resetChoices() {
		choices = new LinkedList<String>(data);
	}
	
	public void resetPart() {
		//System.out.println(parts);
		parts = parts.substring(0,parts.length()-2);
		//System.out.println(parts);
	}
	
	public String getParts() {
		return parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	public Block getNext() {
		return next;
	}

	public void setNext(Block next) {
		this.next = next;
	}

	public Block getPrev() {
		return prev;
	}

	public void setPrev(Block prev) {
		this.prev = prev;
	}

	public Success getSuc() {
		return suc;
	}

	public void setSuc(Success suc) {
		this.suc = suc;
	}

	public Fail getFail() {
		return fail;
	}

	public void setFail(Fail fail) {
		this.fail = fail;
	}

}

class Express{
	List<String> data;
	public Express(String d) {
		String[] ad = d.split(",");
		data = new LinkedList<String>();
		for(String s : ad) {
			data.add(s);
		}
	}
	public List<String> getData() {
		return data;
	}
	
}



