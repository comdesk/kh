package package2;

import package1.A;

public class D extends A {	//A클래스의 자식 클래스인 D
	public D() {					//protected에서 알파로 쓰일 때는 자식으로서 사용하라는 의미 => 맘대로 객체생성 안됨.
		super();					//자식 클래스의 생성자 내에서 부모 클래스의 protected 생성자를 호출가능하다
		this.field = "value";		//부모 A가 물려준 필드를 사용 가능하다
		this.method();				//부모 A가 물려준 메소드를 사용 가능하다
	} //default constructor
	
	public void instanceMethod() {
//		A a = new A();		//B클래스처럼 A를 객체 생성해서 하지는 못함. (부모 생성자는 자식 객체 생성할 때 부모 객체가 먼저 생성될 때 부모 생성자를 호출할 수 있다는 의미임)
		this.field = "other value";		// => 참조변수명.필드/메소드 못함
		this.method();
		
	}
} //end class
