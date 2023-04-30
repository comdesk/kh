package temp34;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString
@AllArgsConstructor
public class Person {
	@Getter private String name;
	//특정 필드에 붙이면 그 특정 필드만 게터를 만듦.
	//클래스 위에 붙이면 모든 필드 게터를 만듦.
	//세터도 동일
	
	
} //end class
