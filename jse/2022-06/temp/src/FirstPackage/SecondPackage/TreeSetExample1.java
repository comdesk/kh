package FirstPackage.SecondPackage;

import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeSetExample1 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		log.info("1. scores: {}", scores);
		
		Integer score = null;
		
		score = scores.first();
		log.info("2. 가장 낮은 점수: {}", score);
		
		score = scores.last();
		log.info("3. 가장 높은 점수: {}", score);
		
		score = scores.lower(95);
		log.info("4. 95점 아래 점수 하나: {}", score);
		
		score = scores.higher(95);
		log.info("5. 95점 위 점수 하나: {}", score);
		
		score = scores.floor(95);
		log.info("6. 95점이거나 바로 아래 점수: {}", score);
		
		score = scores.ceiling(85);
		log.info("7. 85점이거나 바로 위 점수: {}", score);
		
		while(!scores.isEmpty()) {
			score = scores.pollLast();
			log.info("8. score: {}, 8. 남은 객체수: {}", score, scores.size());
		} //while

	} //main

} //end class












