package temp20;

public class KumhoHandle extends Handle {
	
	private Bicycle bicycle;	//초기값은 null (어느 자전거 객체에 끼워질지 모르므로)
								//필드로 받고 있는 bicycle 특정 인스턴스에 부품으로 끼워져잇다.
	//bicycle은 getter메소드로 부품들의 주소를 다 얻을 수 있도록 해놨다. => 어떤 부품에도 접근 가능
	
	public KumhoHandle() {		//자전거 객체가 먼저 생성될 수가 없으므로 부품을 생성할 때 생성자에 못 받음.
		;;
	} //default constructor
	
	public void setBicycle(Bicycle bicycle) {	//세터 메소드를 통해 어느 자전거에 끼워질지 알게 됨.
		this.bicycle = bicycle;
	}
	
	//규격 구현
	@Override
	public void turnLeft() {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.LEFT);
	} //turnLeft	
	
	@Override
	public void turnRight() {
		FrontTire frontTire = this.bicycle.getFrontTire();	
		//자식객체 메소드를 바로부르는 게 아니라
		//부모 타입의 규격을 사용하면 그 부모타입에 끼워진 자식객체의 오버라이딩 메소드가 불린다.
		frontTire.roll(Direction.RiGHT);
	} //turnRight
	
	@Override
	public void goAhead() {
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.GO);
	} //goAhead
} //end class








