package temp15;

public class Television {
	//1. 필드 선언(가. 고유 속성 필드, 나. 상태, 다. 부품필드)
	
	static String company; //= "Samsung";
	static String model; //= "LCD";
	
	static {
//		Television.company = "Samsung";
//		Television.model = "LCD";
	}  //static initializer #1
	
	static String info;
	
	//아래의 것이, 바로 클래스의 4번째 멤버인 정적초기자(static initializer)라 불리는 것으로,
	//선언된 필드 중 정적 필드(static 필드)의 초기화를 담당한다.
	//생성자(Constructor)는 인스턴스 필드의 초기화를 담당한다.
	static {
		System.out.println(">>> Television static initializer invoked.");
		
		Television.company = "Samsung";
		Television.model = "LCD";
		
		Television.company = "LG";
		Television.model = "OLED";
		
//		info = company + "-" + model;									//OK
		Television.info = Television.company + "-" + Television.model;	//OK: 대전제
	} //static initializer #2
	
	public Television() {
		System.out.println(">>> Television default constructor invoked.");
	} //default constructor
	

} //end class






