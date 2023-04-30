package temp21;

//POJO: Plain Old Java Object
public class Vehicle {	//모든 자동차를 대표하는 클래스 => "부모" 클래스가 됨.
	
	//그 어떤 종류의 자동차라고 해도 적어도 아래의 공통 기능은 있어야 한다.
	public void run() {
		System.out.println("Vehicle::run() invoked.");	//기본 구현만 해 놓음.
	} //run()
} //end class
