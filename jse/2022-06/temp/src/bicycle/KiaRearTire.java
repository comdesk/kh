package bicycle;

public class KiaRearTire extends RearTire{
	
	private Bicycle bicycle;
	
	public KiaRearTire() {
		;;
	}	// 생성자
	
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KiaRearTire::setBicycle(Bicycle bicycle) invoked.");
	}	//setBicycle
	
	@Override
	public void roll( ) {
		System.out.println("KiaRearTire::roll( ) invoked.");
	}	// roll
	
}	// end class
