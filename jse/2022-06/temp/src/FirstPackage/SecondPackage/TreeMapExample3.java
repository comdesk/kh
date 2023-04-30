package FirstPackage.SecondPackage;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeMapExample3 {

	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 10);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 30);
		
		log.info("c~f 사이의 글자");
		NavigableMap<String, Integer> rangeMap = treeMap.subMap("cherry", true, "forever", true);
//		Set<Map.Entry<String, Integer>> rangeSet = rangeMap.entrySet();
//		
//		rangeSet.forEach(log::info);
		
//		for(Map.Entry<String, Integer> entry : rangeMap.entrySet()) {
//			log.info("{}={}", entry.getKey(), entry.getValue());
//		} //enhanced for
		
		rangeMap.entrySet().forEach(log::info);
	} //main

} //end class






