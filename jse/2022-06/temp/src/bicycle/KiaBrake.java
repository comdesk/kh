package bicycle;

public class KiaBrake
	extends Brake {

	private Bicycle bicycle;
	
	
	// 1. 필드
		
	
	
	// 2. 생성자
	public KiaBrake() {
		System.out.println("KumhoBrake::default constructor() invoked.");
	} // 기본 생성자
		
	public KiaBrake(String brand, String model, String color, String material, double weight, int price) {
		this(brand, model, color, material, weight, price, 0, 0, false, false, 0, 0);		
	} // 공통속성 생성자
	
	public KiaBrake(int adjustment) {
		this(null, null, null, null, 0.0, 0, 0, adjustment, false, false, 0, 0);	
	} // 고유속성 생성자
		
	public KiaBrake(boolean isbrake, boolean isbroken, int brakeWear, int maxBrakeWear) {
		this(null, null, null, null, 0.0, 0, 0, 0, isbrake, isbrake, brakeWear, maxBrakeWear);
	} // 상태 생성자 - 전체
	
	public KiaBrake(String brand, String model, String color, String material, double weight, int price, int adjustment, int deceleration, boolean isbrake, boolean isbroken, int brakeWear, int maxBrakeWear) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.adjustment = adjustment;
		this.deceleration = deceleration;
		this.isbrake = isbrake;
		this.isbroken = isbroken;
		this.brakeWear = brakeWear;
		this.maxBrakeWear = maxBrakeWear;
			
	} // 전체속성 생성자
	
	
	// 3. 메소드
	
	// 장력조절 값 설정
	@Override
	public void setadj(int adj) {
		System.out.println("KiaBrake::setadj() invoked.");
		this.adjustment = adj;
		System.out.println("기아 브레이크 장력 조절 값 : " + adj);
	} // setadj
	
	// 브레이크 내구도 설정
	@Override
	public void setMaxBrakeWear(int maxBrakeWear) {
			System.out.println("KiaBrake::setMaxBrakeWear() invoked.");
			this.maxBrakeWear = maxBrakeWear;
		} // setMaxBrakeWear
	
	@Override
	public void brakeOn() {
		System.out.println("KiaBrake::brakeOn() invoked.");
		System.out.println("기아 브레이크 작동");
		this.isbrake = true;
	}
	
	@Override
	public void brakeOff() {
		System.out.println("KiaBrake::brakeOff() invoked.");
		System.out.println("기아 브레이크 작동중지");
		this.isbrake = false;
	}
	
	// 브레이크 작동시 상황
	@Override
	public void deceleration() {
		System.out.println("KiaBrake::deceleration() invoked.");
		deceleration = 5 * this.adjustment;
				
		while(this.isbrake == true & this.isbroken == false) {
			System.out.println("===================");
			for(int i = Bicycle.speed; i >= 0; i -= deceleration) {
				Bicycle.speed = i;
				this.brakeWear += deceleration;
//				System.out.println("브레이크 마모도: " + this.brakeWear);
				System.out.println("감속중");
				System.out.println("현재속도: " + i + "km/h");
				System.out.println("===================");				
			} // for
			System.out.println("자전거가 멈췄습니다");
			System.out.println("===================");
			this.isbrake = false;			
		} // while
		
		if(this.isbrake == true & this.isbroken == true) {
			System.out.println("======================================");
			System.out.println("기아 브레이크 고장! 감속이 불가능 합니다.");
			System.out.println("현재속도: " + Bicycle.speed + "km/h");
			System.out.println("======================================");
			} // if		 
	} // deceleration
	
	// 브레이크 고장 건
	@Override
	public boolean broken() {
		System.out.println("KiaBrake::broken() invoked.");
		System.out.println("기아 브레이크 마모도: " + this.brakeWear);
		
		if(brakeWear < maxBrakeWear) {
			;;
		} else {
			System.out.println("기아 브레이크가 마모되었습니다");
			return isbroken = true;
		}		
		return isbroken = false;
	} // broken

	@Override
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	
} // end class
