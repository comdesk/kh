package package1;

//같은 패키지 내에 있는 외부 클래스에서는
//protected 멤버를 사용 가능.
public class B {
	
	public void method() {
		A a = new A();			//protected 생성자 호출
		
		a.field = "value";		//protected 필드 사용
		a.method();				//protected 메소드 호출
	} //method
} //end class
