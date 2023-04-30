package temp19;

//초음속 비행기(자식)
public class SupersonicAirplane 
	extends Airplane{
	
	//static final 상수 선언 (열거 타입 상수로 쓸 수도 있음)
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flyMode = SupersonicAirplane.NORMAL;
	
	@Override
	public void fly() {	//메소드 오버라이딩
		System.out.println("SupersonicAirplane::fly() invoked.");
		
		if(flyMode == SupersonicAirplane.SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		} else {
			super.fly();	//부모 객체의 fly() 메소드 호출
		} //if-else
	} //fly
} //end class
