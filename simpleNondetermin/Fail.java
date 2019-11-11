package simpleNondetermin;


public class Fail{
	Block container;
	public Fail(Block cont) {
		this.container = cont;
	}
	public void fail() {
		System.out.println(container.cur+"up");
		Block prev = this.container.getPrev();
		if(prev != null) {
			// reset choices
			 container.resetChoices();
			 container.resetPart();
			 prev.build(container.getParts());
		}
		  
	}
	
	public void leaf() {
		
        container.build(container.getParts());
	
	}
}