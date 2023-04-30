package org.zerock.myapp.package1;


//클래스/열거/인터페이스 선언부 앞에 붙일 수 있는 접근 제한자는 2개밖에 안 됨.
//1. public		2. default

public	//나중에 붙임
class A {	//default access modifier
	//1. 필드
	public int field1;
	int field2;
	private int field3;
		
	//2. 생성자
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	} //default constructor
	
	//3. 메소드
	public void method1() {System.out.println("method1");}	//method1
	void method2() {System.out.println("method2");}			//method2
	private void method3() {System.out.println("method3");} //method3
	
} //end class









