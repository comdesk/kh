package temp37;

import java.util.TreeMap;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ComparableTreeMap {

	public static void main(String[] args) {
		TreeMap<Person, Integer> treeMap = new TreeMap<>();
		
//		treeMap.put(new Person("홍길동", 45), 90);
//		treeMap.put(new Person("김자바", 25), 85);
//		treeMap.put(new Person("박지원", 31), 70);
		
//		log.info(treeMap);
//		==========================
		
		TreeMap<Integer, Person> treeMap2 = new TreeMap<>();
		
		treeMap2.put(90, new Person("홍길동", 45));
		treeMap2.put(85, new Person("김자바", 25));
		treeMap2.put(70, new Person("박지원", 31));
		
		log.info(treeMap2);
	} //main

} //end class




