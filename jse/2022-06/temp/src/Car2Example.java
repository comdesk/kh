
public class Car2Example {
	public static void main(String[] args) {
		Car2 myCar = new Car2();
		
		myCar.setSpeed(-50);
		
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		myCar.setSpeed(60);
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		} //if
		
		System.out.println("현재 속도: " + myCar.getSpeed());
	} //main
} //end class
