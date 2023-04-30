package bicycle.four;

public class Bicycle {

	// ---------------- 1. 생성자

	// ------------------(1) 고유속성 필드

	String brand;         // 브랜드
	String model;         // 모델
	String color;         // 색깔
	String material;      // 재질
	double   weight;         // 무게
	int price;            // 가격

	// ------------------(2) 상태 필드

	static int speed;             // 속도
	int gearLevel;         // 변속 기어
	String direction;      // 핸들 방향
	int chairHeight;      // 안장 높이
	boolean bikeLock;      // 자전거 잠금장치
	static int distance;

	// ------------------(3) 부품 필드

	private GearBox gearBox;      // 변속기


	//	HandleBar handleBar;   // 핸들
	private Pedal pedal;         // 페달
//	Seat seat;            // 안장
//	Tire tire;         // 바퀴
//	Brake brake;		//브레이크

	
	static {
		Bicycle.speed = 0;
		Bicycle.distance = 0;
	} //static initializer
	
	// --------------------------
	// ---------------- 2. 생성자

	public Bicycle(){
		;;
	}

	// ------------ 고유속성필드 생성자
	Bicycle(String brand, String model, String color, String material, double weight, int price) {
		this(brand, model, color, material, weight, price, 0, 0, null, 0, false);
	} // -----------------------------

	// ----------- 상태필드 생성자
	Bicycle(int speed, int gearLevel, String direction, int chairHeight, boolean bikeLock) {
		this(null, null, null, null, 0.0, 0, speed, gearLevel, direction, chairHeight, bikeLock);
	} // -----------------------------

	// ----------- 전체필드 생성자
	Bicycle(String brand, String model, String color, String material, double weight, int price,
			int speed, int gearLevel, String direction, int chairHeight, boolean bikeLock){
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.speed = speed;
		this.gearLevel = gearLevel;
		this.direction = direction;
		this.chairHeight = chairHeight;
		this.bikeLock = bikeLock;
	} // -----------------------------
	
	// ----------- 부품필드 생성자
//	Bicycle(GearBox gearbox, HandleBar handleBar, Pedal pedal, Seat seat, Tire tire, Brake brake) {
//		this.gearBox = gearbox;
//		this.handleBar = handleBar;
//		this.pedal = pedal;
//		this.seat = seat;
//		this.tire = tire;
//		this.brake = brake;
//	} //constructor
	
	Bicycle(GearBox gearbox, Pedal pedal) {
		this.gearBox = gearbox;
		this.pedal = pedal;
	}

	//3. 메소드
	public GearBox getGearBox() {
		return gearBox;
	}

	public Pedal getPedal() {
		return pedal;
	}
	
	//1. 자전거 달리는 메소드
	public void run() {		//한 번 반복할 때 시간이나 거리 단위로 반복 (ex: 페달이 속도랑 가장 관련있으니까 페달 메소드 따라 6분단위로 반복하거나
							//1km 단위로 반복 / 고장나는 거리 기준이 10km이므로 10km 단위로 반복)
		
	} //run()
	
	//2. 자전거 고장나는 메소드(핸들 방향을 바꾸지 않아 고장났을 때)
	public int broken() {
		
		//if문으로 핸들방향 메소드 받기 -> 핸들방향이 직진일 때
			int num = (int)(Math.random() * 3) + 1;
			
			if(num == 1) {
//				handle.broken();
				return 1;
			}
			if(num == 2) {
//				gear.broken();
				return 2;
			}
			if(num == 3) {
//				seat.broken();
				return 3;
			}
			return 0;
	} //broken()
	
	public void whenBroken() {
		int whyBroken;
		
		if(Bicycle.distance == 10) {
			whyBroken = this.broken();
		} else if(Bicycle.distance == 20) {
			whyBroken = this.broken();
		} //if-else if

	} //whenBroken
	

} //end class



















