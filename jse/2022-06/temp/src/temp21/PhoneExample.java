package temp21;

public class PhoneExample {
	public static void main(String[] args) {
		//추상클래스는 개발자가 직접 new 연산자로 인스턴스를 생성할 수 없다.
//		Phone phone = new Phone(); //(x)
		//오류: Cannot instantiate the type Phone
		
		//자식객체를 생성할 때 힙에는 먼저 부모객체부터 생성된다.
		//부모 클래스의 생성자부터 호출된다.
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();			//상속받음:추상클래스에 선언된 메소드 호출
		smartPhone.internetSearch();	//실체클래스에 선언된 메소드 호출
		smartPhone.turnOff();			//상속받음:추상클래스에 선언된 메소드 호출
	} //main
} //end class
