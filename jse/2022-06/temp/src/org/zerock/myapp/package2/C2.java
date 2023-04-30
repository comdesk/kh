package org.zerock.myapp.package2;

import org.zerock.myapp.package1.B2;

//import org.zerock.myapp.package1.A2;	//A2는 defalut이므로 다른 패키지에 있는 C2 클래스가
										//A2를 import할 수 없다.

public 
class C2 {		//외부에서 어떤 클래스에서건 사용 가능한 클래스
//	A2 a;		//xx: 다른 패키지에 있기 때문에 default인 A2 사용x
	B2 b;		//ok: 다른 패키지에 있어도 public인 B2는 import해서 사용 가능
	
//	A2 a1 = new A2(true);	//A2가 default이기 때문에 모두 다 사용 불가.
//	A2 a2 = new A2(1);
//	A2 a3 = new A2("hi");
} //end class
