package temp13;

public class Calculator {
	//1.필드
	//2.생성자
	
	public Calculator() {
		
	} //자바 컴파일러가 만들어주는 기본 생성자
	
	//3.메소드
	
	
	int plus(int x, int y) {
		System.out.println("Calculator::plus(int, int) invoked.");
		
		int result = x + y;
		
		return result;
	} //plus
	
	double avg(int x, int y) {
		System.out.println("Calculator::avg(int, int) invoked.");
		
		//*** 주의사항 ***
		//같은 클래스 내부에 선언된 다른 메소드를 호출할 때에는
		//아래와 같이 메소드명만(필드와 같이)으로 호출 가능하다.
		//그러나, 필드와 동일한 원칙으로, 아래와 같이 메소드를 호출하지
		//마세요.
//		double sum = plus(x, y);		//XX: 관례를 안 따름. (같은 이름의 지역변수와 이름충돌할 수도 있음. -> 명시적으로 클래스의 멤버라는 것을 알려줌.)
		double sum = this.plus(x, y);	//OK: 관례에 따름 (this는 참조변수와 같은 객체 주소를 들고 있으니 참조변수로 메소드를 부르는 것과 같다.)
		double result = sum / 2;
		
		return result;
	} //avg
	
	void execute() {
		System.out.println("Calculator::execute() invoked.");
		
		//같은 클래스 내부에 선언된 다른 메소드를 호출
//		double result = avg(7,10);			//XX: 관례를 안 따름.
		double result = this.avg(7, 10);	//OK: 관례에 따름
		
		this.println("실행결과: " + result);		
	} //execute
	
	void println(String message) {
		System.out.println("Calculator::println() invoked.");
		
		System.out.println(message);
	} //println
} //end class















