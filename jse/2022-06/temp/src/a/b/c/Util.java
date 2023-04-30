package a.b.c;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class Util {
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.setObj(t);
		
		return box;
	} //boxing
	
//	======================
	
	public static <T extends Number> int compare(T t1, T t2) {
		log.trace("compare({}, {}) invoked.", t1, t2);
		
		double v1 = t1.doubleValue();
		System.out.println(t1.getClass().getName());
		
		double v2 = t2.doubleValue();
		System.out.println(t2.getClass().getName());
		
		return Double.compare(v1, v2);
	} //compare
} //end class















