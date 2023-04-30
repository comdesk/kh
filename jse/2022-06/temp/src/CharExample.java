
public class CharExample {
	public static void main(String[] args) {
		char c1 = 'A';			//1. 문자를 직접 저장
		char c2 = 65;			//2. 십진수로 저장
		char c3 = '\u0041';		//3. Unicode(UTF-8에 정의된 코드) 값으로 저장 (\ u(유니코드)+16진수)
		
		char c4 = '가';			//1. 문자를 직접 저장
		char c5 = 44032;		//2. 십진수로 저장
		char c6 = '\uac00';		//3. Unicode 값으로 저장
			
		//Lvalue(4, int) = Rvalue(2, char) => 자동 형변환(Promotion) by Compiler
		int uniCode = c1;		//유니코드 얻기
		
		System.out.println(c1);
		System.out.println(c2);	//A
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(uniCode);
	} //main
} //end class
