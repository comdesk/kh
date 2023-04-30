package temp35;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class HashMapExample1 {
	
	//Map 컬렉션의 첫 번째 구현 클래스인 HashMap을 사용해보자
	//실전에서는 HashTable을 주로 사용: 공식 => HashTable = HashMap + Thread Safe
	public static void main(String[] args) {
		//1. Map 컬렉션 생성
		//Map<K, V> 2개의 파라미터를 가짐: K = Key, V= value의 타입을 결정
		@Cleanup("clear")
		Map<String, Integer> map = new HashMap<>();
		
//		for( Map.Entry<String, Integer> entry : map ) {
//			//Can only iterate over an array or an instance of java.lang.Iterable
//		} //enhanced for
		
		//2. 요소를 키=값 쌍의 형태로 저장
		//	 이 때 바로, 키 객체에 대해서, 중복 판정 알고리즘 수행
		map.put("신용권", 85);
		map.put("홍길동", 90);	//***
		map.put("동장군", 80);
		map.put("홍길동", 95);	//***: 이 값으로 이전 값을 Overwrite
		
		log.info("1. map: {}", map);
		log.info("2. 총 Entry 수: {}", map.size());
		
		//3. 요소 검색: 키를 가지고 값을 획득 by Map.get(Key);
		log.info("3. 홍길동(키)의 값: {}", map.get("홍길동"));
		
		//4. Map 컬렉션의 순회
		
		//4-1. Map 컬렉션에서 키들만 Set 컬렉션으로 추출
		Set<String> keySet = map.keySet(); //list는 순서가 있으므로 set으로만 반환 가능
		
		for(String key : keySet) {						//keySet을 얻어냈다면 Set은 Iterable하므로
			int value = map.get(key);	//오토 언박싱	//enhanced for 사용해서 순회 가능
			log.info("\t" + key + " : " + value);
		} //enhanced for
		
		//4-2. 키들만 저장되어 있는 Set 컬렉션에서 반복자(Iterator)획득
		Iterator<String> keyIterator = keySet.iterator();	//반복자 획득
		
		//4-3. Map 컬렉션 순회 using 키들이 저장되어 있는 반복자(Iterator)를 이용
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();	//키 획득
			Integer value = map.get(key);		//키를 이용하여 값 획득
			
			log.info("\t" + key + " : " + value);
		} //while
		
		//5. 요소 삭제 by Map.remove(KEY);
		map.remove("홍길동");
		log.info("4. 총 Entry 수: {}", map.size());
		
		//6. Map 컬렉션의 또 다른 순회방법
		//6-1. Map 컬렉션에 저장된 모든 Map.Entry 객체를 Set 컬렉션으로 획득
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		for(Map.Entry<String, Integer> entry : entrySet) {						//keySet을 얻어냈다면 Set은 Iterable하므로
			String key = entry.getKey();
			int val = entry.getValue();
			log.info("\t" + key + " : " + val);
		} //enhanced for
		
		//6-2. 6-1에서 획득한 Set 컬렉션으로부터 순회를 위한 반복자(Iterator)획득
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		//6-3. 6-2에서 획득한 반복자(Iterator)를 이용하여 순회
		while(entryIterator.hasNext()) {
			//Map.Entry 객체 획득
			Map.Entry<String, Integer> entry = entryIterator.next();
			
			String key = entry.getKey();		//Map.Entry에서 Key 획득
			Integer value = entry.getValue();	//Key를 이용하여, Map.Entry에서 값 획득
			log.info("\t" + key + " : " + value);
		} //while
		
		//7. Map 컬렉션 자원해제
//		map.clear();
		log.info("5.총 Entry 수:{}", map.size());
		
	} //main

} //end class





