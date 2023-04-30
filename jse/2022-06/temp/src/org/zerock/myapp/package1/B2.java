package org.zerock.myapp.package1;

//A2는 같은 패키지이므로 import할 필요x

public		//누구나 가져다 쓰세요. 
class B2 {	//즉 이 클래스는 누구나 변수/필드의 타입으로 사용 가능.
	//부품 필드: 필드의 값으로 독립적인 객체를 갖겠다.
	A2 a1 = new A2(true);		//ok: 생성자의 접근 제한: public
	A2 a2 = new A2(1);			//ok: 생성자의 접근 제한: default
//	A2 a3 = new A2("문자열");	//xx: 생성자의 접근 제한: private
	
} //end class
