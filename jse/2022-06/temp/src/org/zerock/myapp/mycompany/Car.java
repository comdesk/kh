package org.zerock.myapp.mycompany;

import org.zerock.myapp.hankook.SnowTire;
import org.zerock.myapp.hyundai.Engine;
import org.zerock.myapp.kumho.BigWidthTire;


public class Car {
	
	Engine engine = new Engine();
	
	SnowTire tire1 = new SnowTire();
	BigWidthTire tire2 = new BigWidthTire();
	
	//직접 FQCN방식으로 다른 클래스를 사용하는 것.(권장x, but, 어쩔 수 없이 해야 하는 경우 있음.)
	//Lvalue와 Rvalue에 똑같이 FQCN으로
	//이렇게 쓰면 밑에서 tire3 쓰더라도 FQCN 방식으로 이용해야 한다.
	org.zerock.myapp.hankook.Tire tire3 = new org.zerock.myapp.hankook.Tire();
	org.zerock.myapp.kumho.Tire tire4 = new org.zerock.myapp.kumho.Tire();
	
} //end class
