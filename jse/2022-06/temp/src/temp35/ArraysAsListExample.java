package temp35;

import java.util.Arrays;
import java.util.List;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class ArraysAsListExample {
	
	//Arrays help class의 메소드 중에 값의 목록으로 List객체를 생성해주는 메소드가 있다.
	//=> asList메소드
	public static void main(String[] args) {
		//1. ArrayList 객체 생성 by Arrays의 asList 메소드
		List<String> list1 = Arrays.<String>asList("홍길동", "신용권", "김자바");	//1st. 제네릭 메소드 호출
		
		for(String name : list1) {
			log.info(name);
		} //enhanced for
		
//		==============
		
		//Auto-boxing을 이용해서 int 기본타입의 값들로 Integer객체를 요소로 가지는 List 컬렉션을
		//ArrayList 객체로 생성
		List<Integer> list2 = Arrays.asList(1, 2, 3);	//2nd. 제네릭 메소드 호출
		
		for(int value : list2) {
			log.info(value);
		} //enhanced for
	} //main
} //end class











