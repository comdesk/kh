package temp20;

public class MyBicycleSenario {
	public static void main(String[] args) {
		//Step.1 부품 객체 생성
		KumhoFrontTire frontTire = new KumhoFrontTire();
		KumhoHandle handle = new KumhoHandle(); 
		
//		FrontTire frontTire = new KumhoFrontTire();		//지역변수의 다형성
//		Handle handle = new KumhoHandle(); 
		
		//Step.2 완성자전거 객체 생성
		Bicycle bicycle = new Bicycle(frontTire, handle);    
		
		//Step.3 각 실제 부품이 어떤 자전거 객체의 부품이 되었는지 설정
		frontTire.setBicycle(bicycle);
		handle.setBicycle(bicycle);
		
		//Step.4 드라이버 생성
		Driver driver = new Driver(bicycle);	//드라이버는 부품 필드가 아니기 때문에 set해줄 필요 x 이미 위에서 자전거 객체 생성
		driver.drive();
		
		
	} //main
} //end class
