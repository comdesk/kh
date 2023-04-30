package temp19.next;

public class KumhoTire 
	extends Tire{
	//1. 필드
	//2. 생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	} //constructor
	
	//3. 메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;
		
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "KumhoTire 수명: " + (maxRotation - accumulatedRotation)
					+ "회");
			
			return true;
		} else {
			System.out.println("*** " + location + " KumhoTire 펑크 ***");
			
			return false;
		} //if-else
	} //roll
} //end class
