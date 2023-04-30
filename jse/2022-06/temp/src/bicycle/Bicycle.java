package bicycle;


public class Bicycle {

	// 1) Filed
	// 자전거 고유속성 필드

	String brand;         // 삼천리, 트렉, 스페셜라이즈드
	String type;          // 산악, 로드, 전기자전거
	String color;         // 프레임 색 (검정, 흰색, 핑크)
	double   weight;      // 무게
	int price;            // 가격

	// 1-1) 상태필드

	static int speed;             // 속도
	int gearLevel;         // 변속 기어
	int chairHeight;       // 안장 높이


	// 1-2) 부품필드 (규격)

	private GearBox gearBox;      // 변속기
	private HandleBar handleBar;  // 핸들
	private Pedal pedal;          // 페달
	private Seat seat;            // 안장
	private FrontTire frontTire;	// 앞 바퀴
	private RearTire rearTire;	// 뒷 바퀴
	private Brake brake;        //브레이크

	// 2) 생성자

	public Bicycle() {
		;;
	}

	public Bicycle(GearBox gearBox, HandleBar handleBar, Pedal pedal, Seat seat, FrontTire frontTire, RearTire rearTire, Brake brake) {

		System.out.println("Bicycle::Consturctor(GearBox gearBox, HandleBar handleBar, Pedal pedal, Seat seat, Tire tire, Brake brake) invoked.");
		this.gearBox = gearBox;
		this.handleBar = handleBar;
		this.pedal = pedal;
		this.seat = seat;
		this.frontTire = frontTire;
		this.rearTire = rearTire;
		this.brake = brake;

	}   // Bicycle 생성자


	// 3) 메소드

	//페달, 타이어- roll();
	public void press(int cadence) { //자전거 객체넘겨주기, 사람과 전자계산기 클래스 관계 add 호출하기 위함
		System.out.println("Bicycle::press(int cadence) invoked.");
		this.pedal.press(cadence);
	}//drive

	public void turnLeft() {		 // 좌회전
		System.out.println("Bicycle::turnLeft( ) invoked.");
		this.handleBar.turnLeft();
	}//turnLeft

	//우회전 시키기
	public void turnRight() {		 // 우회전
		System.out.println("Bicycle::turnRight( ) invoked.");
		this.handleBar.turnRight();
	}//turnLeft

	//직진 시키기
	public void go() {				 // 직진
		System.out.println("Bicycle::go( ) invoked.");
		this.handleBar.go();
	}//turnLeft

	//페달,타이어, 브레이크
	public void stop(){	// 브레이크 작동
		System.out.println("Bicycle::stop( ) invoked.");

		this.brake.brakeOn();
		this.brake.deceleration();
	} //stop

	//기어박스, 페달
	public void setGear(int gearLevel){	// 기어 단수 조절
		System.out.println("Bicycle::setGear(int gearLevel) invoked.");
		this.gearBox.setGear(gearLevel);
	} //setGear

	public void getOn(){			 // 앉다
		System.out.println("Bicycle::getOn( ) invoked.");
		this.seat.getOn();
	} //getOn

	public void getOff(){			 // 내리다.
		System.out.println("Bicycle::getOff( ) invoked.");
		this.seat.getOff();
	} //getOff

	public void setSeat(int height) {	// 안장높이 조절
		System.out.println("Bicycle::setSeat(int height) invoked.");
		this.seat.seatSetting(height);
	}	// setSeat

	public void setadj(int adj) {
		this.brake.setadj(adj);
	} // setadj

	//	===============================================================
	//	getter
	//	===============================================================

	public GearBox getGearBox() {
		System.out.println("Bicycle::getGearBox() invoked.");
		return this.gearBox;
	}   // getGearBox()

	public HandleBar getHandleBar() {
		System.out.println("Bicycle::getHandleBar() invoked.");
		return this.handleBar;
	}   // getHandleBar()

	public Pedal getPedal() {
		System.out.println("Bicycle::getPedal() invoked.");
		return this.pedal;
	}   // getPedal()

	public Seat getSeat() {
		System.out.println("Bicycle::getSeat() invoked.");
		return this.seat;
	}   // getSeat()

	public FrontTire getFrontTire() {
		System.out.println("Bicycle::getFrontTire() invoked.");
		return this.frontTire;
	}   // getFrontTire()

	public RearTire getRearTire() {
		System.out.println("Bicycle::getRearTire() invoked.");
		return this.rearTire;
	}   // getRearTire()

	public Brake getBrake() {
		System.out.println("Bicycle::getBrake() invoked.");
		return this.brake;
	}   //  getBrake()

	//	===============================================================
	//	setter
	//	===============================================================

	public void setGearBox(GearBox gearBox) {
		this.gearBox = gearBox;
	} //setGearBox()

	public void setHandleBar(HandleBar handleBar) {
		this.handleBar = handleBar;
	} //setHandleBar()

	public void setPedal(Pedal pedal) {
		this.pedal = pedal;
	}//setPedal()

	public void setSeat(Seat seat) {
		this.seat = seat;
	}//setSeat()

	public void setFrontTire(FrontTire frontTire) {
		this.frontTire = frontTire;
	} //setFrontTire()

	public void setBrake(Brake brake) {
		this.brake = brake;
	} //setBrake()

}   // end class



