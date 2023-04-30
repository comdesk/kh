package temp19;

public class SupersonicAirplaneExample {
	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();	//1.자식 객체 생성
		
		
		sa.takeOff();	//2. 부모가 물려준 메소드인 "이륙" 실행
		sa.fly();		//3. 재정의된 자식객체의 메소드가 실행
		
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();		//3. 재정의된 자식객체의 메소드가 실행
		
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();		//3. 재정의된 자식객체의 메소드가 실행
		
		sa.land();		//4. 부모가 물려준 메소드인 "착륙" 실행
	} //main
} //end class
