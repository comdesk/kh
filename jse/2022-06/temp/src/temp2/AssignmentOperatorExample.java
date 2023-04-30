package temp2;

public class AssignmentOperatorExample {
	
	//복합대입연산자: 다른 연산자와 합쳐져서 "복합"이란 용어를 쓰고,
	//				  각각의 연산자가 자신의 연산을 수행
	public static void main(String[] args) {
		int result = 0;
		
		result += 10;	//result = result + 10;		
		System.out.println("result = " + result);	//'+'연산자와 '='대입연산자가 하나로 합쳐짐.
		
		result -= 5;	//result = result - 5;
		System.out.println("result = " + result);	//'-'연산자와 '='대입연산자가 하나로 합쳐짐.
		
		result *= 3;
		System.out.println("result = " + result);	//'*'연산자와 '='대입연산자가 하나로 합쳐짐.
		
		result /= 5;
		System.out.println("result = " + result);	//'/'연산자와 '='대입연산자가 하나로 합쳐짐.
		
		result %= 3;
		System.out.println("result = " + result);	//'%'연산자와 '='대입연산자가 하나로 합쳐짐.
		
//		=====================
		
		//삼항연산자: 연산식에서 피연산자가 3개인 연산자
		//문법: (  조건식   ) ?  값1  :  값2;  => 참이면 값1, 거짓이면 값2 반환, () 필수
		//삼항연산자는 콜론의 왼쪽이든 오른쪽이든 또 삼항연산자나 표현식을 계속 중첩시킬 수 있음.
		//값을 제공할 수 있는 건 변수, 리터럴, 연산식 다 가능.(값을 생성하는 식이면 모두 허용)
		int score = 85;
		char A_grade = 'A';
		char B_grade = 'B';
		char C_grade = 'C';
		
		char grade = 
				(score > 90) ? A_grade : ( (score > 80) ? 'B' : 'C');	//조건식이 false일 때, 반환값
		
		System.out.println(score + "점은 " + grade + "등급입니다.");
		
//		==== Text Block (JAVA 15 LTS: 표준문법채택) ===
		
		String multiLine = """
				""";
		
		System.out.println();	//비어있는 행 출력
		System.out.println(multiLine);
	} //main
} //end class









