package bicycle;

public class KumhoGearBox extends GearBox{

	private Bicycle bicycle;
	
	public KumhoGearBox(){
		System.out.println("KumhoGear::default constructor() invoked.");
	} //constructor
	
	@Override
	public void setBicyle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KumhoGearBox::setBicyle(Bicycle bicycle) invoked.");
	}
	
	@Override
	public void setGear(int gearLevel) {
		System.out.println("KumhoGearBox::setGear(int gearLevel) invoked.");
		
		this.gearLevel = gearLevel;
		
		if(gearLevel == 1) {
				System.out.println(gearLevel + "단 입니다." );
		} else if(gearLevel == 2) {
			System.out.println(gearLevel + "단 입니다.");			
		} else if(gearLevel == 3) {
			System.out.println(gearLevel + "단 입니다.");	
		} else if(gearLevel ==4) {
			System.out.println(gearLevel + "단 입니다.");	
		}
	} //setbicycle
	
}
