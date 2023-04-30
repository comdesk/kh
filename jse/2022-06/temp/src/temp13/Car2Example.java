package temp13;

public class Car2Example {
	
	public static void main(String[] args) {
		Car2 myCar = new Car2();		//자동차 객체 생성
		
		//개발하는 방법 #1
		//- 내가 호출할 메소드 시그니처를 어떻게 확인할 수 있을까?
		//	1. 해당 생성자나 메소드 위에 마우스 hovering 수행
		//	2. 해당 생성자나 메소드를 드래그 선택한 후에, F1 키를 누름.
		myCar.keyTurnOn();				//자동차 객체의 메소드 호출
		myCar.run();					//자동차 객체의 메소드 호출
		
		int speed = myCar.getSpeed();	//자동차 객체의 메소드 호출
		
		System.out.println("현재 속도: " + speed + "km/h");
	} //main
} //end class
