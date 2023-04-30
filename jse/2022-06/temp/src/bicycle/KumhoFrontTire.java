package bicycle;



public class KumhoFrontTire 
		extends FrontTire{	// 자식 클래스

	
	private Bicycle bicycle;
	
	public KumhoFrontTire() {	// 부품객체가 생성된 이후에 
		;;
	}	// 생성자



	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KumhoFrontTire::setBicycle(Bicycle bicycle) invoked.");
	}	// setBicycle
	
	@Override
	public void roll(Direction direction) {	// 물려받은 규격대로 구현한다.
		System.out.println("KumhoFrontTire::roll(Direction direction) invoked.");
	}	//roll
	
}	// end class
