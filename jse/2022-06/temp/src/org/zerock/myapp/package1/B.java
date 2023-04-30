package org.zerock.myapp.package1;


public		//누구나 가져다 쓰세요. 
class B {	//즉 이 클래스는 누구나 변수/필드의 타입으로 사용 가능.
	
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
//		a.field3 = 1;
		
		a.method1();
		a.method2();
//		a.method3();
	} //default constructor
	
} //end class
