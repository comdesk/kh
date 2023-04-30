package temp36;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashMapExample2 {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		//중복되게 키 객체를 지정, 값도 동일
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 95);
		
		log.info(map);	//{Student(sno=1, name=홍길동)=95}
		log.info("총 Entry 수: {}", map.size());

	} //main

} //end class











