package temp20;

public class KumhoFrontTire extends FrontTire {
	
	private Bicycle bicycle;
	
	public KumhoFrontTire() {
		;;			//실행클래스 입장에서 보면 부품이 먼저 생성되고 완성 객체인 자전거가 나중에 생성된다.
					//실제로 부품 객체가 생성될 때 어느 자전거에 끼워질지 알 수가 없음.
					//=> 세터 메소드를 통해 필드에 넣어준다.
	} //default constructor

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	
	@Override
	public void roll(Direction direction) {		//물려받은 규격대로 구현
		;;
	}
} //end class
