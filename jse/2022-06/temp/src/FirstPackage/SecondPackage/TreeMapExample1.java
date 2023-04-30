package FirstPackage.SecondPackage;

import java.util.Map;
import java.util.TreeMap;

import lombok.extern.log4j.Log4j2;


@Log4j2	
public class TreeMapExample1 {

	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		log.info("1. scores: {}", scores);
		
		Map.Entry<Integer, String> entry = null;
		
		entry = scores.firstEntry();
		log.info("2. 가장 낮은 점수: {} - {}", entry.getKey(), entry.getValue());
		
		entry = scores.lastEntry();
		log.info("3. 가장 높은 점수: {} - {}", entry.getKey(), entry.getValue());
		
		entry = scores.lowerEntry(95);
		log.info("4. 95점 아래 점수: {} - {}", entry.getKey(), entry.getValue());
		
		entry = scores.higherEntry(95);
		log.info("5. 95점 위 점수: {} - {}", entry.getKey(), entry.getValue());
		
		entry = scores.ceilingEntry(95);
		log.info("6. 95점이거나 바로 위 점수: {} - {}", entry.getKey(), entry.getValue());
		
		entry = scores.floorEntry(85);
		log.info("7. 85점이거나 바로 아래의 점수: {} - {}", entry.getKey(), entry.getValue());
		
		while(!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			log.info("8. {}-{}, 남은 객체 수: {}", entry.getKey(), entry.getValue(), scores.size());
		} //while

	} //main

} //end class













