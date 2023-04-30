package temp33.next;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoundedTypeParameterExample {

	public static void main(String[] args) {
		//String str = Util.compare("a", "b"); //xx
		
//		=====
		
		//구체타입을 제네릭 메소드의 타입 파라미터에 전달해줘야 함.
		//제약 조건: <T extends Number> (불린타입을 제외한 래퍼타입)
		int result1 = Util.<Number>compare(10, 20);		//1st. 제네릭 메소드 호출
//		int result1 = Util.<Integer>compare(10, 20);		//1st. 제네릭 메소드 호출
//		int result1 = Util.compare(10, 20);		//2nd. 제네릭 메소드 호출
		log.info("1. result1: {}", result1);
		
//		=====
		
//		int result2 = Util.<Double>compare(4.5, 3);
		int result2 = Util.<Number>compare(4.5, 3);
		log.info("2. result2: {}", result2);

	} //main

} //end class
