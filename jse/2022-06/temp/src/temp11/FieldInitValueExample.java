package temp11;

public class FieldInitValueExample {
	public static void main(String[] args) {
		//클래스로부터 new 연산자와 생성자를 이용해서 "인스턴스"(=객체) 생성
		FieldInitValue fiv = new FieldInitValue();
		
		//dot(.) 연산자를 이용해서 참조변수에 저장된 객체의 필드값을 읽어(read) 출력
		System.out.println("byteField: " + fiv.byteField);
		System.out.println("shortField: " + fiv.shortField);
		System.out.println("intField: " + fiv.intField);
		System.out.println("longField: " + fiv.longField);
		System.out.println("booleanField: " + fiv.booleanField);
		System.out.println("charField: " + fiv.charField);
		System.out.println("floatField: " + fiv.floatField);
		System.out.println("doubleField: " + fiv.doubleField);
		System.out.println("arrField: " + fiv.arrField);
		System.out.println("referenceField: " + fiv.referenceField);
		
	} //main
} //end class
