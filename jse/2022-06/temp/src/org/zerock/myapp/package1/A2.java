package org.zerock.myapp.package1;

//클래스/열거/인터페이스 선언부 앞에 붙일 수 있는 접근 제한자는 2개밖에 안 됨.
//1. public		2. default
class A2 {		//default access modifier
	//1.필드
	A2 a1 = new A2(true);
	A2 a2 = new A2(1);
	A2 a3 = new A2("문자열");
	//생성자에서 초기화할 것을 필드에서 초기화함.
	
	//클래스를 다 만들지도 않았는데, 설계도 안에서 설계도 A2를 쓴다??
	//클래스를 선언하는 와중에 똑같은 클래스를 사용해서 객체를 찍어내도 된다.
	
	
	//2.생성자
	//생성자 오버로딩
	public A2 (boolean b) {;;} 	//constructor #1: public
	A2(int b) {;;}				//constructor #2: default
	private A2(String s) {;;}	//constructor #3: private
	
} //end class
