package keijiban;

import java.util.ArrayList;

public class ResList {
	private static ArrayList<ResBean> instance;
	private ResList() {};
	static synchronized ArrayList<ResBean> getInstance(String name, String contents){
		if(instance == null) {
			instance = new ArrayList<ResBean>();
		}
		ResBean res = new ResBean();
		res.setName(name);
		res.setContents(contents);
		instance.add(res);
		return instance;
	}
}
