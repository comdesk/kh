package temp19.next;

public class HankookTire 
	extends Tire{
	//1. 필드
	//2. 생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	} //constructor
	
	//3. 메소드	: 부모인 Tire 타입이 상속 해준 roll() 메소드 재정의
	@Override
	public boolean roll() {
		++accumulatedRotation;
		
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire 수명: " + (maxRotation - accumulatedRotation)
					+ "회");
			
			return true;
		} else {
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			
			return false;
		} //if-else
	} //roll
	
	
} //end class
