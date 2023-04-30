package temp21;

public class DriverExample {

	public static void main(String[] args) {
		//Step.1 운전자 객체를 생성
		Driver driver = new Driver();
		
		//Step.2 Vehicle 타입의 자식 타입의 객체를 생성
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		//Step.3 자식 객체를 Vehicle 부모타입의 매개변수에 전달인자값으로 전달
		driver.drive(bus);	//이 메소드의 매개변수의 타입이 부모타입인 Vehicle
		driver.drive(taxi);	//이 메소드의 매개변수의 타입이 부모타입인 Vehicle

	} //main

} //end class
