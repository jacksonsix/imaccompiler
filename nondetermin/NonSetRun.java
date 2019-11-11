package nondetermin;

import environment.Env;

public class NonSetRun extends AbstractNonRun{
	String name;
	INonRunObject val;
	


	@Override
	public Object run(Env env, ISucObject suc, IFailObject fail) {
		
		SetSuc ssuc = new SetSuc();
		
		
		try {
			Object oldvalue = env.search(name);
			SetFailObject fail2 = new SetFailObject(env,oldvalue,fail);
			
			env.setVarible(name, val.run(env,ssuc,fail2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public INonRunObject getVal() {
		return val;
	}



	public void setVal(INonRunObject val) {
		this.val = val;
	}
	
	
	
	
}
