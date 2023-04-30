
public class Car {
	//1.필드
	int speed;
			
	//2.생성자
	public Car() {;;}
			
	//3.메소드
	static void run() {
		Car myCar = new Car();
		
		myCar.speed = 60;
		
		
		System.out.println(myCar.speed + "으로 달립니다.");
	} //run
	
	public static void main(String[] args) {
//		speed = 60;
//		run();
		
		
		
		
		Car.run();
		
		
	} //main
} //end class
