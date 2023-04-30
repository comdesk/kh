package temp15;

//final 필드(= final 상수)에 대해서 이해하자.
public class Person {
	//1. 필드 (가. 고유 속성 필드, 나. 상태, 다. 부품필드)
	final String nation = "Korea";
	final String ssn;
	String name;
	
	//2. 생성자
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	} //Constructor
	
} //end class
