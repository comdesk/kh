package temp16;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();		//내가 만든 인스턴스 필드나 메소드가 객체 없이 실행 안 되므로 객체 생성
		
		//잘못된 속도 변경
		myCar.setSpeed(-50);
		
		System.out.println("현재 속도: " + myCar.getSpeed());
		
		//올바른 속도 변경
		myCar.setSpeed(60);
		
		//멈춤
		if(!myCar.isStop()) {
			myCar.setStop(true);
		} //if
		
		System.out.println("현재 속도: " + myCar.getSpeed());
	} //main
} //end class
