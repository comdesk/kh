package temp11;

public class CarExample {	//실행클래스
	
	//라이브러리 클래스를 이용해서 객체를 생성하고 필드의 값을 조작해보자
	public static void main(String[] args) {
		//Step.1 new 연산자와 생성자를 이용한 객체 생성
		Car myCar = new Car();	//생성자나 메소드 선언시, 소괄호 블록은 "호출"할 수 있게 해주는 기호
		System.out.println("myCar: " + myCar);
		
		//***대전제: 어떻게 클래스의 구성 멤버 중, 필드와 메소드를 사용할 수 있을까? =>
		//			 바로, "객체멤버참조연산자"라 불리는 "dot(.) 연산자"를 사용해서
		//			 객체의 멤버(필드, 메소드)를 사용할 수 있다.
		//			 예) 참조변수명.필드명, car.필드명 = 새로운 값, car.메소드명
		
		
		
		//Step.2 생성된 객체의 필드에 저장된 값을 출력(필드의 값 Read)
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고 속도: " + myCar.maxSpeed);
		System.out.println("현재 속도: " + myCar.speed);	//초기화 안 된 필드는 타입별 기본값 => 0
		
		//Step.3 생성된 객체의 필드의 값을 얼마든지 변경해보자.
		myCar.speed = 60;
		System.out.println("수정된 현재 속도: " + myCar.speed);
	} //main

} //end class
