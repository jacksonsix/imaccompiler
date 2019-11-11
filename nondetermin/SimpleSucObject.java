package nondetermin;

public class SimpleSucObject implements ISucObject{


	@Override
	public Object success(Object val, IFailObject fail) {
		return val;
	}
}
