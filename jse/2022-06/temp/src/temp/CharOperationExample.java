package temp;

public class CharOperationExample {
	//2바이트 문자타입 char
	public static void main(String[] args) {
		char c1 = 'A' + 1;	//'B'= 66
		char c2 = 'A';		//'A'= 65
		
		char c3 = (char) (c2 + 1);	//컴파일 에러
		
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
	} //main
} //end class
