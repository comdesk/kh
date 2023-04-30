package temp24;

public class NullPointerExceptionExample {
	
	//Runtime Exception: 자바컴파일러가 체크하지 않는 예외에 대한 예제
	public static void main(String[] args) {
		String data = null;
		NullPointerException e = null;
		
		System.out.println(data.toString());	//NullPointerException
												//data.toString()을 호출한 건 메인 메소드 -> 메인을 호출한 건 JVM
	} //main
} //end class
