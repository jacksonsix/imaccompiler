package simpleNondetermin;


public class Success{
	Block container;
	public Success(Block cont) {
		this.container = cont;
	}
	public void success(String val,String partial, Fail fail) {
		Block next = this.container.getNext();
		
		if(next == null) {
			System.out.println(this.container.getParts() + "," + val);
			fail.leaf();
		}else {
			next.build(partial +"," + val);
		}
		
	}
}