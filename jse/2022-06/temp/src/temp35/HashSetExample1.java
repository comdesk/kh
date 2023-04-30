package temp35;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashSetExample1 {
	
	//Set 컬렉션 성질: 
	//1. 순서를 보장하지 않는다.
	//2. 중복을 허용하지 않는다.
	//3. 하나의 null 값이 요소로 허용된다(의미가 없다)
	public static void main(String[] args) {
		//1. Set 컬렉션 생성
		@Cleanup("clear")
		Set<String> set = new HashSet<>();
		
		//2. 새로운 요소 추가
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		//3. 컬렉션의 크기 획득
		int size = set.size();
		log.info("총 객체수: {}", size);
		
		//4. Iterator(반복자) 객체를 획득해서 Set 컬렉션 순회(traverse) => But, useless
		Iterator<String> iterator = set.iterator();	//Set 객체 만들 때 타입을 정했기 때문에 Iterator가 다른 타입일 수 없다.
		while(iterator.hasNext()) {
			String element = iterator.next();
			log.info("\t" + element);
		} //while
		
		//5. 요소 삭제
		set.remove("JDBC");
		set.remove("iBATIS");
		
		log.info("2. 총 객체수: {}", set.size());
		
		for(String element : set) {
			log.info("\t" + element);
		} //enhanced for
		
		set.forEach(log::info);		//Set 컬렉션 순회의 끝판왕
		
		//7. 컬렉션 자원 해제
//		set.clear();	//=>Lombok의 @Cleanup => @Cleanup은 main 블록 끝을 만나야 clear
		log.info("3. set: {}", set);
		
		if(set.isEmpty()) {
			log.info("비어 있음");
		} //if
	} //main

} //end class












