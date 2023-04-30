package temp33.next;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoxingMethodExample {

	public static void main(String[] args) {
		//제네릭 메소드 호출(사용할 때 => 구체타입을 지정)
		//구체 타입으로 "Integer" 지정 => Box<T>의 구체타입으로도 사용됨.
		Box<Integer> box1 = Util.<Integer>boxing(100);	//1st. method - @till 7
//		Box<Integer> box1 = Util.boxing(100);			//2nd. method - @since 8
		
		int intValue = box1.getObj();
		log.info("1. box1: {}, intValue: {}", box1, intValue);
		
//		=============================
		
		//제네릭 메소드 호출(사용할 때 => 구체타입을 지정)
		Box<String> box2 = Util.boxing("홍길동");		//2nd. method
		
		String strValue = box2.getObj();
		log.info("2. box2: {}, strValue: {}", box2, strValue);
		
	} //main

} //end class





