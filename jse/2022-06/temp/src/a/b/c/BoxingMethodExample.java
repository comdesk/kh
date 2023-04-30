package a.b.c;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoxingMethodExample {

	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100);
//		Box<Integer> box1 = Util.boxing(100);
		
		int intValue = box1.getObj();	//오토언박싱
		log.info("1. box1: {}, 2. intValue: {}", box1, intValue);
		
//		=======================
		
		Box<String> box2 = Util.boxing("홍길동");
//		Box<String> box2 = Util.<String>boxing("홍길동");
		
		String strValue = box2.getObj();
		log.info("1. box2: {}, 2. strValue: {}", box2, strValue);
		

	} //main

} //end class
