package temp36;

import java.util.NavigableSet;
import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class TreeSetExample3 {
	
	//지정된 범위 탐색
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<>();
		
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		log.info("1. treeSet: {}", treeSet);
		
		log.info("[c~f로 시작하는 단어들을 검색]");
		//subSet: 부분집합
		//NavigableSet<String> java.util.TreeSet.subSet(
		//							String fromElement, 
		//							boolean fromInclusive, //from도 포함할거냐
		//							String toElement, 
		//							boolean toInclusive)
		//부분문자열이 아닌 완전한 값으로 지정해야 제대로 된 값이 나온다.
		NavigableSet<String> rangeSet = treeSet.subSet("cherry", true, "forever", true); //(c,f) : x
		log.info("2. rangeSet: {}", rangeSet);
		
//		for(String word : rangeSet) {
//			log.info(word);
//		}// enhanced for	
		
		rangeSet.forEach(log::info);

	} //main

} //end class
