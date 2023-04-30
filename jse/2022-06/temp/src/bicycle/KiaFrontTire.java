package bicycle;

public class KiaFrontTire extends FrontTire{

	private Bicycle bicycle;
	
	public KiaFrontTire() {
		;;
	}	// Constructor
	
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KiaFrontTire::setBicycle(Bicycle bicycle) invoked.");
	}	//setBicycle
	
	@Override
	public void roll(Direction direction) {
		System.out.println("KiaFrontTire::roll(Direction direction) invoked.");
	}	// roll
}	// end class
