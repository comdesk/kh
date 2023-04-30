package temp21;

public class Bus extends Vehicle {
	
	//부모 클래스가 물려준 메소드를 재정의(Overriding)
	@Override
	public void run() {
		System.out.println("Bus::run() invoked.");
		System.out.println("버스가 달립니다.");
	} //run()
} //end class
