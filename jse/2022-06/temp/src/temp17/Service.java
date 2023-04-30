//@MyAnnotation	//xx
//@MyAnnotation package temp17;	//xx
package temp17;


//@MyAnnotation		//ok
//@MyAnnotation public 	//ok
//public @MyAnnotation	//ok

@MyAnnotation
public class Service {
	
//	@MyAnnotation			//ok
//	@MyAnnotation private 	//ok
//	private @MyAnnotation	//ok
//	private String @MyAnnotation name; //xx: 필드의 한 몸은 타입과 이름.
	@MyAnnotation private String name;
	
	
	
	private int age;
	
//	@MyAnnotation		 //OK
//	@MyAnnotation public //ok
//	public @MyAnnotation //ok
	public
	Service() {
		System.out.println("Service::Default Consructor invoked.");
	} //default constructor
	
	public Service(String name, int age) {
		System.out.println("Service::Consructor(String, int) invoked.");
	} //constructor
	
//	@MyAnnotation 		 //OK //속성이 없어 소괄호 안 엶(속성 없다고 알려주기). 열 수는 있음.
//	@MyAnnotation public //OK
//	public @MyAnnotation //OK
	public 
//	void @MyAnnotation	 //xx: 메소드 시그니처는 침범할 수 없다. 
	void method1() {
		System.out.println("Service::method1() invoked.");
		
//		@MyAnnotation	//ok
		@MyAnnotation String name = "Yoseph";	//ok
				
		int age = 23;
		
	} //method1
	
	@MyAnnotation
	public void method2(
//			@MyAnnotation	//OK
//			@MyAnnotation String name,	//ok
//			String @MyAnnotation name,	//xx: 매개변수도 타입과 이름이 한 몸.
			@MyAnnotation String name,
			int age		//어노테이션 정보가 필요 없으면 어노테이션 안 붙여도 됨.
			) {
		System.out.println("Service::method2(String, int) invoked.");
	} //method2
	
	@MyAnnotation
	public void method3() {
		System.out.println("Service::method3() invoked.");
	} //method3
	
} //end class
