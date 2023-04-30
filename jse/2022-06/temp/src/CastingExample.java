
public class CastingExample {
	public static void main(String[] args) {
		int intValue = 44032;	//2바이트만 사용하므로 유실x
		char charValue = (char) intValue;	//Lvalue(2) = Rvalue(4): 강제 형변환
		
		System.out.println(charValue);	//변수에 값이 들어갈 때는 정수값으로 들어가지만 출력할 때는 문자로 출력
		System.out.println((char) intValue);	//Lvalue는 optional이므로 담을 필요 없으면 Rvalue만으로 사용
		
//		================
		
		long longValue = 500;
		intValue = (int) longValue;	//Lvalue(4) = Rvalue(8): 강제 형변환 => 값이 2바이트밖에 안 쓴다는 것은 유실을 판단할 뿐 데이터타입으로 형변환 판단
		
		System.out.println(intValue);
		
//		================
		
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		
		System.out.println(intValue);	//실수를 정수로 강제형변환하면 소수점 이하 자릿수가 절삭된다. => 3
	} //main
} //end class
