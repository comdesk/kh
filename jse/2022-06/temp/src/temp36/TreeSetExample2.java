package temp36;

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
		
		//4. 정렬결과 출력(by 순회(traverse))
//		for(int score : descendingSet) {	//Set은 기본적으로 Iterable하므로 enhanced for 가능
//			log.info(score);
//		} //enhanced for
							 //메소드 참조: 람다식의 끝판왕
		descendingSet.forEach(log::info); //내부순회
		
		//5. 오름차순 결과 얻는 방법
		//=> 내림차순 결과셋을 돌려주는 메소드를 한 번 더 호출한다.(오름차순셋이 없다)
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		
		//6. 정렬결과 출력(by 순회(traverse))
//		for(Integer score : ascendingSet) {
//			log.info(score);
//		} //enhanced for
		
		descendingSet.forEach(log::info);

	} //main

} //end class


