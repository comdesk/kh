package bicycle;

public class KumhoRearTire extends RearTire{
	
private Bicycle bicycle;
	
	public KumhoRearTire() {
		;;
	}	// 생성자
	
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KumhoRearTire::setBicycle(Bicycle bicycle) invoked.");
	}	//setBicycle
	
	@Override
	public void roll( ) {
		System.out.println("KumhoRearTire::roll(Direction direction) invoked.");
	}	// roll
	
}	// end class
