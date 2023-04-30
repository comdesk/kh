package temp14;

public class TTT9 {
	
	String instanceField;
	static int staticField;
	
	public void instanceMethod() {
		System.out.println(instanceField);		//ok
		System.out.println(TTT9.staticField);	//ok
		instanceMethod();						//ok
		TTT9.staticMethod();					//ok
	} //instanceMethod
	
//	=========================
//			결론2
//	=========================

//1. 인스턴스 메소드에서는 모든 멤버(정적, 인스턴스) 사용 가능.	
	
	public static void staticMethod() {
		;;
	} //staicMethod
	
	public static void main(String ... args) {
//		System.out.println(instanceField);		//xx
		System.out.println(TTT9.staticField);	//ok
//		instanceMethod();						//xx
		TTT9.staticMethod();					//ok
		
//		=========================
//				결론1
//		=========================
		
//		1. 정적 메소드에서는 오로지 정적 필드와 메소드만 사용 가능.
//		2. 정적 메소드에서는 인스턴스 필드와 메소드는 사용 불가.
	} //main
} //end class











