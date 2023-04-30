package FirstPackage.SecondPackage;

import java.util.NavigableSet;
import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeSetExmaple3 {

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
		
		NavigableSet<String> rangeSet = treeSet.subSet("cherry", true, "forever", true);
		log.info("2. rangeSet: {}", rangeSet);
		
		rangeSet.forEach(log::info);

	} //main

} //end class












