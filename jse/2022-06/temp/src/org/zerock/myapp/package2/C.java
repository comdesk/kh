package org.zerock.myapp.package2;

import org.zerock.myapp.package1.A;


public 			//외부에서 어떤 클래스에서건 사용 가능한 클래스
class C {
	public C() {
		A a = new A();
		a.field1 = 1;
//		a.field2 = 1;
//		a.field3 = 1;
		
		a.method1();
//		a.method2();
//		a.method3();
	} //default constructor
	
	public static void main (String[] args) {
		A a = new A();
		
		C c = new C();
	} //main
} //end class
