package bicycle;


public class KumhoHandleBar extends HandleBar{

	//	String brand = "Kumho";
	//	String type =
	//	String color = "black";


	private Bicycle bicycle;

	public KumhoHandleBar() {
		;;
	}//default constructor

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KumhoHandleBar::setBicycle(bicycle) invoked.");
	} //setBicycle

	@Override
	public void turnLeft() {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.LEFT);
		
		System.out.println("KumhoHandleBar::turnLeft() invoked.");
	} 	//turnLeft()

	@Override
	public void turnRight(){
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.RIGHT);
		
		System.out.println("KumhoHandleBar::turnRight() invoked.");
	} // turnRight()

	@Override
	public void go() {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.GO);
		
		System.out.println("KumhoHandleBar::Go() invoked.");
	} 	//goAhead()



} // end class


