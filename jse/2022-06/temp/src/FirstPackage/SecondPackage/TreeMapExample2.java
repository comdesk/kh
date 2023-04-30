package FirstPackage.SecondPackage;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeMapExample2 {

	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		//내림차순
		NavigableMap<Integer, String> descendingMap = scores.descendingMap();
		Set<Map.Entry<Integer, String>> descendingSet = descendingMap.entrySet();
		
		descendingSet.forEach(log::info);
		
		//오름차순
		NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
		Set<Map.Entry<Integer, String>>ascendingSet = ascendingMap.entrySet();
		
//		ascendingSet.forEach(log::info);
		for(Map.Entry<Integer, String> entry : ascendingSet) {
			log.info("{} = {}", entry.getKey(), entry.getValue() );
		} //enhanced for

	} //main

} //end class






