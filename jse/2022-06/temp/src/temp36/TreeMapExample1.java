package temp36;

import java.util.Map;
import java.util.TreeMap;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeMapExample1 {

	public static void main(String[] args) {
		//1. 트리맵 객체 생성
		TreeMap<Integer, String> scores = new TreeMap<>();
		
		//2. 요소 추가
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		log.info("1. scroes: {}", scores);
		
		Map.Entry<Integer, String> entry = null;
		
		//정렬된 키 중, 가장 낮은 키 값을 가진 요소 반환
		entry = scores.firstEntry();
		log.info("2. 가장 낮은 점수: {} - {}", entry.getKey(), entry.getValue());
		
//		=========================
		
		entry = scores.lastEntry();
		log.info("3. 가장 높은 점수: {} - {}", entry.getKey(), entry.getValue());
		
//		=========================
		
		entry = scores.lowerEntry(95);
		log.info("4. 95점 아래 점수: {} - {}", entry.getKey(), entry.getValue());
		
//		=========================	
		
		entry = scores.higherEntry(95);
		log.info("5. 95점 위의 점수: {} - {}", entry.getKey(), entry.getValue());
		
//		=========================
		
		entry = scores.floorEntry(95);
		log.info("6. 95점이거나 바로 아래 점수: {} - {}", entry.getKey(), entry.getValue());
		
//		=========================
		
		entry = scores.ceilingEntry(85);
		log.info("7. 85점이거나 바로 위의 점수: {} - {}", entry.getKey(), entry.getValue());
		
//		=========================
		
		while(!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			log.info("8. {}-{}, 남은 객체 수: {}", entry.getKey(), entry.getValue(), scores.size());
		} //while
		
	} //main

} //end class





