package temp12;

//클래스 선언 시, 클래스에 선언가능한 구성 멤버 3가지
//1. 필드	2. 생성자	3.메소드
public class Calculator {
	//1. 필드 : xx
	
	//2. 생성자 : xx => 자바 컴파일러가 개입해서 기본 생성자를 만듦.
	//					그런데, 이렇게 컴파일러에 의존하지 말라
	//					기본 생성자라도 명시적으로 선언하라
	public Calculator() {;;}
	
	//대전제: 메소드의 선언부를, 자바에서는 "메소드 시그니처(Method Signature)"라고 한다.
	//Method Signature: <return type> <method name>(매개변수 선언부) { .. }
	//3. 메소드
	void powerOn() {
		System.out.println("Calculator::powerOn() invoked.");	//메소드 호출 로그
	} //powerOn
	
	int plus(int x, int y) {
		System.out.println("Calculator::plus(int, int) invoked.");
		
		int result = x + y;
		
		return result;
	} //plus
	
	double divide(int x, int y) {
		System.out.println("Calculator::divide(int, int) invoked.");
		
		double result = (double) x / (double) y;
		
		return result;
	} //divide
	
	void powerOff() {
		System.out.println("Calculator::powerOff() invoked.");
		
	} //powerOff
} //end class








