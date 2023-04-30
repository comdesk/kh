package temp35;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LinkedListExample {
	
	//대용량 데이터에 기반해서, 같은 List 인터페이스 구현클래스인
	//ArrayList와 LinkedList의 성능(수행속도 => 소요시간)을 측정/비교
	public static void main(String[] args) {
		//1. 2개의 리스트 생성(하나는 ArrayList로 생성, 또 하나는 LinkedList로 생성)
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		//2. 나노타임(1/10억 초) 정확도로 시간을 측정할 변수 선언
		long startTime;
		long endTime;
		
		//3. ArrayList에 1만개의 문자열 객체를 요소로 저장하되, 맨 처음 인덱스(0번 인덱스)에 추가
		//=> 점점 뒤로 밀리는 요소가 증가
		startTime = System.nanoTime();				//측정 전 시간
		
			for(int i = 0; i < 1000000; i++) {
				list1.add(0, String.valueOf(i));
			} //for
			
		endTime = System.nanoTime();				 //수행 후 측정시간
		log.info("1. Elapsed time of ArrayList: " + (endTime-startTime) + "ns");
		
//		=============
		
		//4. LinkedList에 1만개의 문자열 객체를 요소로 저장하되, 맨 처음 인덱스(0번 인덱스)에 추가
		startTime = System.nanoTime();
		
			for(int i = 0; i < 1000000; i++) {
				list2.add(0, String.valueOf(i));
			} //for
			
		endTime = System.nanoTime();
		log.info("2. Elapsed time of LinkedList: " + (endTime-startTime) + "ns");
	} //main

} //end class













