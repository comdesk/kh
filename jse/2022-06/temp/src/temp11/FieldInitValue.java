package temp11;
//***대전제2: new 연산자와 생성자로 객체 생성시, 생성자가 객체의 필드를
		//	  초기화(즉, 초기값을 넣어줌)하지 "않으면",
		//	  생성된 객체의 각 필드에는, "자바의 타입별 기본값"이 들어간다.
		//	  (정수타입필드는 0, 실수타입필드는 0.0, boolean타입 필드는 false,
		//	   참조타입필드는 null)
		//	  물론 클래스 선언시, 필드에 이미 초기값을 "정의"했으면,
		//	  그 값으로 객체의 필드의 초기값이 결정되지만, 일반적으로
		//	  위 대전제1과 같이, 클래스 설계시 필드에는 값을 하드코딩하지 않는다.
public class FieldInitValue {	//라이브러리 클래스
	
	//(1) 기본타입(Primitive Types) 필드
	byte byteField;			//byte (정수) => 초기값이 없고, 생성자도 초기화해주지 않으면
							//				 생성된 객체 안의 이 필드의 값은, 타입별 기본값을 가진다.
	short shortField;		//Ditto. => 0
	int intField;			//Ditto. => 0
	long longField;			//Ditto. => 0L
	
	boolean booleanField;	//Ditto. => false
	char charField;			//Ditto. => '\u0000' (빈 문자, ''), \\u: 유니코드(UTF-8이란 문자집합)
							//			십진수로 바꾸면 0
	
	float floatField;		//Ditto. => 0.0F
	double doubleField;		//Ditto. => 0.0
	
	//(2) 참조타입(Reference Types) 필드
	int[] arrField;			//Ditto. => null
	String referenceField;	//Ditto. => null
} //end class
