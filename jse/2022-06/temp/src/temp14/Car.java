package temp14;

public class Car {
	//1. 필드
	String model;
	int speed;
	
	//2. 생성자		==> 기본 생성자는 필요 없어서 선언x
	Car(String model) {
		this.model = model;
	} //constructor
	
	//3. 메소드
	void setSpeed(int speed) {	//현재 속도를 설정
		this.speed = speed;
	} //setSpeed
		
	void run() {	//자동차를 달리게 하는 메소드
		for(int i = 10; i <= 50; i += 10) {		//10단위로 속도 증가
			this.setSpeed(i);	//같은 클래스 내부의 다른 메소드 호출: this.메소드
			
			System.out.println(
					this.model + 	//같은 클래스 내부의 필드 사용: this. 필드
					"가 달립니다.(시속: " + 
					this.speed + 	//같은 클래스 내부의 필드 사용: this. 필드
					"km/h)");
		} //for
	} //run
} //end class










