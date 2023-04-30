package temp13;

public class CarExample {
	public static void main(String[] args) {
		//Car 클래스의 인스턴스(=객체) 생성
		Car myCar = new Car();
		
		//setGas 메소드 호출(Give and take!!!)
		myCar.setGas(5);	//Car의 setGas() 메소드 호출
		
		//isLeftGas 메소드 호출(Give and Take!!!)
		boolean gasState = myCar.isLeftGas();
		
		//연료가 있는지 여부에 따라
		if(gasState) {
			System.out.println("출발합니다.");
			
			myCar.run();
		} //if
		
		//연료가 아직 남아있다면
		if(myCar.isLeftGas()) {	//Car의 isLeftGas() 메소드 호출
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		} //if-else
	} //main
} //end class













