package bicycle;

public class KiaGearBox extends GearBox {

	private Bicycle bicycle;
	
	public KiaGearBox(){
		System.out.println("KumhoGear::default constructor() invoked.");
	} //constructor
	
	//메소드
	@Override
	public void setBicyle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KiaGearBox::setBicyle(Bicycle bicycle) invoked.");
	}
	
	@Override
	public void setGear(int gearLevel) {
		System.out.println("KiaGearBox::setGear(int gearLevel) invoked.");
		
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
