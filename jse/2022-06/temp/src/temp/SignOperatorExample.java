package temp;

//부호 연산자(단항, Unary) 예제: +, -
//목적: 변수값의 부호를 (1) 유지하거나 (2) 바꿀 때 사용
//주의: 부호 연산자의 산출결과는 'int' 타입이 된다. (정수타입의 피연산자에 부호연산자 적용하면)
public class SignOperatorExample {
	public static void main(String[] args) {
		int x = -100;
		
		int result1 = +x;	//부호연산자도 연산자이기 때문에 값이 같다하더라도 그릇이 필요
		int result2 = -x;
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
//		=================
		
		short s = 100;
		
//		short result3 = (short)-s;	//컴파일 에러
		int result3 = -s;	//부호만 바뀌었을 뿐인데 왜 int타입으로 했을까. 부호연산자도 연산자이기 때문에 정수타입의 연산 결과는 int타입으로 시작한다.
		
		System.out.println("result3 = " + result3);
	} //main
} //end class
