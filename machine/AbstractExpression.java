package machine;

public abstract class AbstractExpression implements IIExpression {
	int line;
	int pos;
	String text="not set";
	int parent=0;
	int id;
	//RunObject runobj;
	
	public AbstractExpression() {
		this.id = this.hashCode();
	}

	
	@Override
	public int getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}
	public void setPos(int xpos) {
		this.pos = xpos;
	}
	@Override
	public int getPos() {
		// TODO Auto-generated method stub
		return this.pos;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return  this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getLine() {
		return this.line;
	}
	
	public void setLine(int num) {
		this.line = num;
	}


}
