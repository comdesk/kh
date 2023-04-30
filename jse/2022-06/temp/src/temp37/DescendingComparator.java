package temp37;

import java.util.Comparator;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
//우리에게 소스가 없는 Fruit 참조타입도 TreeSet/TreeMap에 사용가능하도록 하려면
//아래와 같이 비교자(Comparator)를 만들어 제공하면 된다.
public class DescendingComparator implements Comparator<Fruit> {
			//내림차순 비교자
	
	//거꾸로 반환하면 내림차순
	@Override
	public int compare(Fruit o1, Fruit o2) {	//왼쪽이 기준객체
		log.trace("compare({}, {}) invoked.", o1, o2);
		
		if(o1.price < o2.price) return 1;
		else if(o1.price == o2.price) return 0;
		else return -1;
	} //compare

} //end class
