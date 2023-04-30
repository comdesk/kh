package temp12;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		System.out.println("myCalc: " + myCalc);
		
		//메소드 실행문법: <참조변수명><dot연산자><실행할 메소드명(전달인자...)>;
		//					참조변수.메소드(전달인자1, 인자2, ...); => 매개변수가 있다면 전달인자
		//					*실행문장이니 세미콜론(;)으로 마감처리한다.
		myCalc.powerOn();   
		
//		=================
		
		int result1 = myCalc.plus(5, 6);	//메소드의 리턴타입에 변수 타입을 맞춤. 메소드가 값을 생성해내면 대입연산자로 넣어야 함.
//		myCalc.plus(5, 6);				//Rvalue가 값을 생성하든 말든 Lvalue는 옵셔널. Lvalue 없이 호출만 할 수 있음.
		System.out.println("result1: " + result1);
		

		
//		=================
		
		byte x = 10;
		byte y = 4;
		
		//결국 메소드의 매개변수와 전달인자 간의 관계는
		//아래와 같이 메소드의 매개변수에 전달인자를 초기값으로 초기화 해주는 매개변수의 "정의"와 같다.
//		매개변수  전달인자		//메소드를 호출할 때 전달인자를 초기값으로 해서 매개변수를 정의하는 것.
//		 int x  =  byte x;		//=>자동형변환은 메소드 호출할 때도 가능.
		
								//매개변수: int x, int y
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2);
		
	} //main
} //end class














