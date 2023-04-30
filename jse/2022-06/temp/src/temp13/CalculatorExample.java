package temp13;

public class CalculatorExample {
	
	//이 예제는 같은 클래스 내부에 선언된 메소드가 역시 같은 클래스 내부에 선언된
	//다른 메소드를 호출하는 방법에 대해서 배우는 예제.
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		
		myCalc.execute();	//Caculator 외부에서 메소드 호출
	} //main
} //end class
