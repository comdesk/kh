package FirstPackage.SecondPackage;

import java.util.NavigableSet;
import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class TreeSetExample2 {

	public static void main(String[] args) {
		//1. TreeSet 객체 생성
		TreeSet<Integer> scores = new TreeSet<>();
		
		//2. 새로운 요소 추가 => 중복검증(이중판정알고리즘), 이진트리 생성(정렬완성)
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		log.info("1. scores: {}", scores);
		
		//3. 정렬결과 획득 (내림차순 결과 획득) - Ascending(오름차순), Descending(내림차순)
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		log.info("2. descendingSet: {}", descendingSet);
		

	} //main

} //end class









