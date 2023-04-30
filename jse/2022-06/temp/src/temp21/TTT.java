package temp21;

public class TTT {
	//대전제: 모든 참조타입객체의 조상타입 => Object
	public static void main(String[] args) {
		Object obj = "Yoseph";	//다형성-1
		
		if(obj instanceof String) {		//@util JAVA 8
			String s = (String) obj;	//강제형변환이 무조건 필요
			System.out.println(s);
			System.out.println(obj);
		} //if
		
		if(obj instanceof String s) {	//obj 안의 객체가 String타입이 맞다면 문자열 타입의 새로운 변수 s를 만들어 obj안의 있는 객체를 강제형변환에서 자동으로 넣겠다.
			System.out.println(s);		//강제형변환 필요x 
		} //if
	} //main
} //end class
