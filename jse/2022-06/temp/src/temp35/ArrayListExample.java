package temp35;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ArrayListExample {
	
	//ArrayList의 가장 중요한 성질:
	//1. 요소가 삭제/추가되면 남아있던 요소들이 밀고 당기는 현상 발생
	//	 => 이런 현상이 빅데이터에서는 아주 치명적인 부하 => 시간 엄청 소요
	//2. 이런 데이터는 ArrayList하고 같이 사용하면 안 됨
	//	 => 추가/삭제가 빈번히 발생하는 데이터
	public static void main(String[] args) {
		//1. List 컬렉션 생성(Lvalue: 인터페이스 = Rvalue: 구현 객체)
		List<String> list = new ArrayList<>();	//다형성-1 : Initial capacity = 10
		//컬렉션의 껍데기만 만들었지 아무것도 안 들어있음.
		
		//2. 새로운 요소 객체의 추가		//다형성-2
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");	//이미 인덱스 2번에 데이터가 있는데 또 2번에 추가 => 기존 2번은 뒤로 밀려남.
		list.add("iBATIS");
		
		log.info("1. list: {}", list);
				
		//3. 현재 List 컬렉션의 크기(즉, 요소의 개수) 출력
		int size = list.size();				//다형성-2
		log.info("총 객체수: {}", size);
		log.info("");
		
		//4. 특정 인덱스의 요소를 얻기
		String skill = list.get(2);		//처음에 List만들때 지정한 게 String이기 때문에 변수의 타입이 String
		log.info("2: {}", skill);
		log.info("");
		
		//5. List 컬렉션의 순회(traverse) 및 검색
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			log.info(i + ":" + str);
		} //classical for
		
		//Iterable한 성질을 가지는 자료구조와 함께 사용 가능
		for(String li : list) {		//인덱스 번호를 되돌려주지 않음.
			log.info(li);
		} //enhanced for
		
		//6. 특정 인덱스의 요소 삭제
		list.remove(2);			//2번 인덱스의 요소 삭제되면서, 뒤의 모든 요소가 당겨짐.
		list.remove(2);			//이전 삭제에 의해서 이전 요소가 모두 당겨진 상태이므로
								//2번 인덱스를 다시 사용 가능(**이게 엄청 안 좋은 것)
		list.remove("iBATIS");	//리턴타입이 불린이니까 이런 객체가 없으면 안 삭제했을 것.
		
		//7. 현재 List 컬렉션의 모든 요소 출력
		for(int i = 0; i < list.size(); i++) {	//개발자가 순회하는 코드를 만드는 것: 외부 순회
			String str = list.get(i);
			log.info(i + ":" + str);
		} //classical for
		
		for(String li : list) {
			log.info(li);
		} //enhanced for
		
		log.info("4. list: {}", list);
		
		list.forEach(log::info);	//개발자가 순회하는 코드를 만들지 않고 순회: 내부 순회
		           //람다의 메소드 참조
	} //main

} //end class








