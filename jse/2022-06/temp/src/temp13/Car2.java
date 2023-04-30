package temp13;

public class Car2 {
	//1.필드
	int speed;
	
	//2.생성자
	public Car2() {
		
	} //기본 생성자
	
	//3.메소드
	int getSpeed() {
		System.out.println("Car2::getSpeed() invoked.");
		
		return this.speed;
	} //getSpeed
	
	void keyTurnOn() {
		System.out.println("Car2::keyTurnOn() invoked.");
		
		System.out.println("키를 돌립니다.");
	} //keyTurnOn
	
	void run() {
		System.out.println("Car2::run() invoked.");
		
		for(int i = 10; i <= 50; i += 10) {
			this.speed = i;
			
			System.out.println("달립니다.(시속:" + this.speed + "km/h)");
		} //for
	} //run
	
} //end class















