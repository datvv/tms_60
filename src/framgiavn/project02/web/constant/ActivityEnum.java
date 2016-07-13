/**
 * Jul 10, 2016, TmsEnums.java, datvv
 */
package framgiavn.project02.web.constant;

import java.util.*;

/**
 * @author datvv
 *
 */
public enum ActivityEnum {
	
	TASK(1), SUBJECT(2), COURSE(3), USER(4);

	public int number;

	ActivityEnum(int number) {
		this.number = number;
	}

	private static final Map<Integer, ActivityEnum> map;
	static {
		map = new HashMap<Integer, ActivityEnum>();
		for (ActivityEnum v : ActivityEnum.values()) {
			map.put(v.number, v);
		}
	}

	public static ActivityEnum findByKey(int i) {
		return map.get(i);
	}

}