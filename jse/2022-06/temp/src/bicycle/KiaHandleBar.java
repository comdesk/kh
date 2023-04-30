package bicycle;

public class KiaHandleBar extends HandleBar {


	private Bicycle bicycle;

	public KiaHandleBar() {
		;;
	}//default constructor
	
	@Override
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KiaHandleBar::setBicycle(bicycle) invoked.");
	} //setBicycle

	@Override
	public void turnLeft() {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.LEFT);
		
		System.out.println("KiaHandleBar::turnLeft() invoked.");
	} 	//turnLeft()

	@Override
	public void turnRight(){
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.RIGHT);
		
		System.out.println("KiaHandleBar::turnRight() invoked.");
	} // turnRight()

	@Override
	public void go() {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.GO);
		
		System.out.println("KiaHandleBar::go() invoked.");
	} 	//goAhead()

} // end class
