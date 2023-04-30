package temp33;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GenericBoxExample {

	//제네릭 타입의 클래스를 *"사용"할 때*, 정말 제네릭 이전의 각종 형변환이
	//사라졌는지를 확인해보자 => 이것이 제네릭의 "목적"이다
	public static void main(String[] args) {
		//1. 제네릭 클래스로부터 객체 생성
		//@till JAVA7
//		GenericBox<String> box1 = new GenericBox<String>();	//문자열만 저장할 수 있음. => 형변환x, 다형성-1x
		
		//@since JAVA8
		//새로운 연산자를 제네릭을 위해 출현 => 바로 <> 연산자(타입추론연산자)
		GenericBox box1 = new GenericBox();
//		log.info("1. box1: {}", box1);	//1. box1: GenericBox(t=null) 필드에 아직 값을 안 집어 넣었으니까
		
		//2. 객체의 Setter 메소드 호출
		box1.set("hello");		//문자열 타입에 문자열 넣는 것.
		log.info("1. box1: {}", box1);	//1. box1: GenericBox(t=hello)
		
		//3. 객체의 Getter 메소드 호출
		String str = (String)box1.get();
		log.info("1. str: {}", str);
		
//		==================
		
		//1. 제네릭 클래스로부터 객체 생성
		GenericBox<Integer> box2 = new GenericBox<Integer>();
		
		//2. 객체의 Setter 메소드 호출
		box2.set(6);	//오토박싱
		log.info("2. box2: {}", box2);
		
		//3. 객체의 Getter 메소드 호출
		int value = box2.get();	//오토언박싱
		log.info("value: {}", value);
	} //main

} //end class






