package temp33;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoxExample {
	
	//Generic을 사용하기 전에 코드가 얼마나 많은 형변환(Promotion, Casting)을
	//발생시키는지 경험해보자
	public static void main(String[] args) {	
		Box box = new Box();						//1. 상자 생성
		
		box.setObject("홍길동");					//2. 상자에 "문자열 객체" 넣기
		log.info("1.box: {}", box);
		
		String name = (String) box.getObject();		//3. 상자에서 "문자열 객체" 꺼내기
		
//		======================
		
		box.setObject(new Apple());					//4. 상자에 새로이 "사과 객체" 넣기
		log.info("2. box: {}", box);
		
		Apple apple = (Apple) box.getObject();		//5. 상자에서 "사과 객체" 꺼내기

	} //main

} //end class
