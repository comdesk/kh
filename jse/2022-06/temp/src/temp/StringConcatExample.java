package temp;

public class StringConcatExample {
	
	//문자열 연결 연산자(+) 예제
	//(대전제) 기본타입 < 참조타입 (문자열: String)
	//피연산자 중에, 하나가 String 타입이 아니어도,
	//자동형변환에 의해서, 문자열(String)로 변환되어 +(연결)됨.
	public static void main(String[] args) {
		String str1 = "JDK" + 17.0;
		String str2 = str1 + "특징";
		System.out.println(str2);
		
//		====
		
		String str3 = "JDK" + 3 + 3.0;
		String str4 = 3 + 3.0 + "JDK";	//동일한 연산자가 모여 있을 땐 우선순위가 아닌 연산방향대로 진행됨.
		System.out.println(str3);
		System.out.println(str4);
		
	} //main
} //end class
