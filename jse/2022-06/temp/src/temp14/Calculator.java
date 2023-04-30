package temp14;

//이 클래스 안에 있는 모든 멤버(필드, 메소드)는 모두 "정적(static)"
//즉, 모든 멤버가 "정적멤버"
public class Calculator {
	static double pi = 3.14159;			//원주율 파이값을 가진 "정적필드"
	
	
	//실전에서 정적메소드를 선언한는 기준은 아래와 같다.
	//매개변수에 전달되는 인자값만으로, 해당 메소드의 기능이 단독으로
	//수행 가능하다면, 굳이 객체마다 메소드를 들고 있게 하지 않고,
	//정적 메소드로 선언한다.
	static int plus(int x, int y) {		//덧셈연산을 수행하는 "정적메소드"
		Math.random();
		System.out.println("TEST");
		System.out.println( "********" +  System.out  + "*******" );
		return x + y;
		
		
	} //plus
	
	static int minus(int x, int y) {	//뺄셈 연산을 수행하는 "정적메소드"
//		Calculator.plus(100, 200);	//OK: 대전제에 맞게 사용 (***)
//		plus(100,200);				//OK: 그러나, 대전제대로 사용하라
		
		return x - y;
	} //minus
} //end class
