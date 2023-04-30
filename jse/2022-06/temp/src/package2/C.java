package package2;

import package1.A;


public class C {			//A의 자식 클래스가 아니기 때문에 A의 protected에 접근 불가
		A a = new D();		//public인 A 클래스 자체에는 접근 가능하므로 참조변수 선언은 가능.
	
	public void method() {
//		A a = new A();		//XX: A클래스의 생성자 접근 불가
		
//		a.field = "value";	//XX: A클래스의 필드 접근 불가
//		a.method();			//XX: A클래스의 메소드 접근 불가
		
	}
} //end class
