package temp37;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Person implements Comparable<Person> {
	public String name;
	public int age;
	
	@Override
	public int compareTo(Person obj) {
		log.trace("compareTo({}) invoked.", obj);
		
		//두 개의 값(즉, (1)기준값, (2)비교값)을 비교할 때
		//자바 언어에서는 통일성 있게, 아래 기준으로 값을 반환하게 되어 있다:
		//1. 기준값 < 비교값 => 음수값 반환(보통 -1 반환)
		//2. 기준값 == 비교값 => 0 반환
		//3. 기준값 > 비교값 => 양수값 반환(보통 +1 반환)
		
		//두 사람의 나이를 가지고 대소를 따지게 구현됨
		if(this.age < obj.age) return -1;
		else if(this.age == obj.age) return 0;
		else return 1;
	} //compareTo

} //end class












