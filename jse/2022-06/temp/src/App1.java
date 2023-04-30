

//주석문(Comment)
//이 프로그램은 두 숫자를 더해서 출력하는 역할을 수행
public class App1 {

	public static void main(String[] args) {
		//덧셈을 수행할 두 숫자(Number)를 저장할 변수의 "선언"
		//=> 즉, 2개의 그릇을 만들자
		int number1; //첫 번째 숫자를 저장할 변수(그릇)
		int                   number2; // 두 번째 변수
		int result; //두 숫자의 덧셈 결과를 저장할 변수
		
		//위에서 만든 2개의 변수(그릇: 유형은 정수만 저장가능)에
		//실제 숫자를 넣어보자!
		number1 = 100;
		number2 = 300;
		
		result = number1 + number2;
		
		System.out.println(result);
		
		// ====================================== //
		
		result = number1 - number2;
		
		System.out.println(result);
		
		// ====================================== //
		// 곱셈기호 => '*'
		result = number1 * number2;
		
		System.out.println(result);
		
		// ====================================== //
		// 나눗셈 => '/'
		result = number1 / number2;
		
		System.out.println(result);
		//변수의 타입을 잘못 정해서 0이란 값이 나옴.
		
		double result2 = (double) number1 / number2;
		System.out.println(result2);
		
		
	} //called, "Entry Point(진입점)"
} //end class
