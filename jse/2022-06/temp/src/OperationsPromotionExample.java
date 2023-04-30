
public class OperationsPromotionExample {
	public static void main(String[] args) {
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		
//		byte byteValue3 = byteValue1 + byteValue2;		//컴파일 에러
//		byte byteValue3 = (byte) byteValue1 + byteValue2;	//형변환 연산자가 덧셈 연산자보다 빨라서 오류
		byte byteValue3 = (byte) (byteValue1 + byteValue2);
		
							//모든 정수연산의 결과 => 정수로 나오고, int 타입으로 시작 (21억이 넘으면 long)
		//  -그릇-        -표현식(값1개 생성)-
		int intValue1 = byteValue1 + byteValue2;
		
		System.out.println(intValue1);
		System.out.println(100 + 100);
		System.out.println(100 - 100);
		System.out.println(100 * 100);	//곱셈연산자: *
		System.out.println(10 / 3);	//나눗셈연산자: / =>3 (모든 정수연산의 결과는 정수로 나오기 때문에 소수점 이하 절삭)
		System.out.println(10.0 / 3); // => 피연산자 하나만 정수가 아니더라도 정수 연산식이 아님.
		System.out.println(10 / 3.0);
		
//		================
		
		char charValue1 = 'A';	//'A'문자에 할당된 정수값이 저장
		char charValue2 = 1;	//??? char 타입도 분명 "정수" 타입임 => 문자코드값 저장
		
		//컴파일 에러 => 원인: 정수연산의 결과 => 정수(int 타입)
		char charValue3 = (char) (charValue1 + charValue2);	//Lvalue(char,2) = Rvalue(int,4)
		
						//Rvalue: 정수연산의 결과 => 정수(int 타입)
		int intValue2 = charValue1 + charValue2;
		
		//여기서 '+' 연산자 => "문자열 연결 연산자" : 두 문자열을 이어주는 연산 수행
		System.out.println("유니코드 = " + intValue2);	         //=> 66 //참조타입>기본타입 => int를 String으로 맞춰서
		System.out.println("출력문자 = " + (char) intValue2);	//=> B  //강제형변환 결과값이 String으로. println 함수는 char 타입을 문자로 바꿔서 출력해줌.
		
		System.out.println((char) 102); //f
		
		char temp = 102;	//'f'
		System.out.println(temp); //f
		
//		================
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4;
		
		System.out.println(intValue4);
		
//		================
		
		int intValue5 = 10;
		double doubleValue = intValue5 / 4.0;
		
//		int intValue6 = 10 / 4.0;
		
		System.out.println(doubleValue);
	} //main
} //end class















