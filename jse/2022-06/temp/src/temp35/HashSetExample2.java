package temp35;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashSetExample2 {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		//Set 컬렉션의 add 메소드 호출시, 이 메소드 안에서
		//이중중복판정알고리즘이 작동하고, 이 때 Member 객체에 lombok이 자동생성한
		//hashCode() 메소드와 equals() 메소드가 호출된다.
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		
		log.info("1. set: {}", set);

	} //main

} //end class
