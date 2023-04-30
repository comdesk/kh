package temp36;

import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeSetExample1 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		
		//add메소드가 중복판정도 하고 binary tree를 만듦.
//		scores.add(new Integer(87));	//생성자가 곧 없어질 거라 취소선 나옴
		scores.add(87);	//오토박싱
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		log.info("1. scores: {}", scores);
		
//		====================
		
		Integer score = null;
		
		score = scores.first();		//정렬 중 처음이니까 최솟값
		log.info("2. 가장 낮은 점수: {}", score);
		
//		====================
		
		score = scores.last();
		log.info("3. 가장 높은 점수: {}", score );
		
//		====================
		
		score = scores.lower(95);	//바로 아래 하나
		log.info("4. 95점 아래 점수: {}", score);	//87
		
//		====================
				
		score = scores.higher(95);
		log.info("5. 95점 위 점수: {}", score);
		
//		====================
		
		score = scores.floor(95);	//지정된 점수가 있으면 그 점수를 보여주고, 없으면 하나 낮은 점수 보여줌.
		log.info("6. 95점이거나 바로 아래 점수: {}", score);	//95
		
//		====================
		
		score = scores.ceiling(85);
		log.info("7. 85점이거나 바로 위 점수: {}", score);	//87
		
//		====================
		
		while(!scores.isEmpty()) {
			//Set 컬렉션의 요소 중에, 가장 첫 번째(낮은, Min) 요소를 끄집어 냄. => 아예 빠져나감.
			score = scores.pollFirst();
			log.info("8. score: {}, 8. 남은 객체수: {}", score, scores.size());
		} //while

	} //main

} //end class









