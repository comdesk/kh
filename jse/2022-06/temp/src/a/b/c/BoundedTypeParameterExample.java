package a.b.c;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoundedTypeParameterExample {

	public static void main(String[] args) {
//		String str = Util.compare("a", "b");
		
//		int result1 = Util.compare(10, 20);
//		int result1 = Util.<Integer>compare(10, 20);
		int result1 = Util.<Number>compare(10, 20);
		log.info("1. result1: {}", result1);
		
//		int result2 = Util.compare(4.5, 3);
//		int result2 = Util.<Double>compare(4.5, 3);
		int result2 = Util.<Number>compare(4.5, 3);
		
		log.info("1. result2: {}", result2);
				

	} //main

} //end class
