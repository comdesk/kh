package temp15;

public class Car {
	//1. 필드 (가. 고유 속성 필드, 나. 상태, 다. 부품필드)
	int speed;	//상태 필드 => 인스턴스 필드
			
	//2. 생성자
	public Car() {;;}	//기본 생성자
	
	//3. 메소드
	void run() {	//인스턴스 메소드
		System.out.println(speed + "으로 달립니다.");
	} //run
	
	//대전제: 인스턴스 멤버 => 모든 유형의 멤버 사용 가능
	//		  정적멤버		=> 오로지 정적 멤버만 사용 가능
	public static void main(String[] args) {	//실행진입점
		Car myCar = new Car();
		myCar.speed = 60;		//속도변경
		myCar.run();			//달려라. 인스턴스 메소드 호출.
		
		//정적 메소드 안에서는 인스턴스 멤버를 사용하지 못하기 때문에
		//같은 클래스 내부라도 객체 생성 없이 이름만으로 사용할 수 없다.
//		speed = 60;		//XX: 객체 생성 없이는 사용 불가인 인스턴스 필드
//		run();			//XX: 객체 생성 없이는 호출 불가인 인스턴스 메소드
	} //main
} //end class









