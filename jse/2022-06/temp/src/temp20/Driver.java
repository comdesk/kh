package temp20;

public class Driver {
	private Bicycle bicycle;	//자전거를 탄다고 사용 관계에 있기 때문에 얘도 자전거 객체의 주소를 가져야 함.
								//실제 드라이버가 어떤 자전거 인스턴스를 탔는지 필드로 가짐.
								//그래서 인스턴스 필드
	public Driver(Bicycle bicycle) {
		this.bicycle = bicycle;
	} //constructor
	
	public void drive() {
		this.bicycle.drive();
	} //drive
	
	public void turnLeft() {
		this.bicycle.turnLeft();
	} //turnLeft
} //end class


//public class Driver {				//bicycle의 인스턴스를 필드로 가지지 않으면 메소드마다 매개변수로 받을 수도 있음.
//	public Driver() {
//		;;
//	}//default constructor
//	
//	public void drive(Bicycle bicycle) {
//			this.bicycle.drive();
//		} //drive
//} //end class




