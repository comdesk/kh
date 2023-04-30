package temp21;

public class Child extends Parent {
	public String field2;	//자식만의 필드
	
	public Child() {
		super();	//부모객체의 생성자를 호출(안 넣어도 컴파일러가 자동으로 해주고 있음.)
		System.out.println("Child::default constructor invoked.");
	} //default constructor
	
	public void method3() {	//자식만의 메소드
		System.out.println("Child::method3() invoked.");
	} //method3
} //end class
