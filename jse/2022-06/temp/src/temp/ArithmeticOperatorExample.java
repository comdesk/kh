package temp;

public class ArithmeticOperatorExample {
	
	//(대전제): 정수 연산식의 결과 => 정수, int 타입으로 가정(시작)
	public static void main(String[] args) {
		int x = 88;
		
		//x 변수의 값이 짝수인지 홀수인지 판단해보자
		if(x % 2 == 0) {	//참(true)이면
			System.out.println("짝수");
		} else {			//거짓(false)이면
			System.out.println("홀수");
		} //if-else
	} //main
} //end class
