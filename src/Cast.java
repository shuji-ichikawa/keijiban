package keijiban;

import java.util.List;

public class Cast {
	@SuppressWarnings("unchecked")
	public static List<ResBean> castList(Object object){
		return (List<ResBean>)object;
	}
}
