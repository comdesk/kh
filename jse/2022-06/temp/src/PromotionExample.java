
public class PromotionExample {
	
	//자동형변화(Promotion) 예제
	public static void main(String[] args) {
		
		//실행문장을 구성하는 Lvalue = Rvalue에서,
		//형변환의 발생은, Rvalue에서 발생하는 것이지,
		//Lvalue에서는 발생하지 않는다.
		
		//리터럴(순수한 값)은 형변환 대상 자체가 안 되고, 그대로 밀어 넣는다. 그냥 쑥 들어감.
		byte byteValue = 10; //피연산자 2개. 정수 리터럴은 int타입이라 Rvalue가 Lvalue보다 더 큰데 오류 안 남.
		int intValue = byteValue; 	//자동형변환(작은타입 -> 큰 타입으로), Lvalue 타입으로 맞춤
		
		System.out.println(intValue);
		
//		==========
		
		char charValue = '가';		//한 문자를 보관하는 타입으로 2바이트 정수, '가': 문자 리터럴
		
		intValue = charValue;		//Lvalue(4) = Rvalue(2) : 자동형변환 발생 -> 문자마다 숫자코드가 할당되어 있음.
		
		System.out.println("가의 유니코드 = " + intValue);
		
//		==========
		
		intValue = 500;
		
		long longValue = intValue;		//Lvalue(8) = Rvalue(4)
		
		System.out.println(longValue);
		
//		==========
		
		intValue = 200;
		double doubleValue = intValue;	//Lvalue(8) = Rvalue(4)  => 타입을 맞춰놔야 하니까 소수점이 생김.
		
		System.out.println(doubleValue);
	} //main
} //end class














