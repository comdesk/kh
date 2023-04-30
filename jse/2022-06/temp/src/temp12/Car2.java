package temp12;

//중복되는 필드 초기화 중복코드를 제거하는 예제
public class Car2 {
	//1. 필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//2. 생성자
	Car2() {;;}											//매개변수가 없는 기본 생성자
	
	Car2(String model) {								//매개변수가 1개인 생성자
		this(model, null, 0);
	}
	
	Car2(String model, String color) {					//매개변수가 2개인 생성자
		this(model, color, 0);
	}
	
	Car2(String model, String color, int maxSpeed) {	//매개변수가 3개인 생성자
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
} //end class









