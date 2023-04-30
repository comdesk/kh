package bicycle;

public class KiaPedal 
	extends Pedal{
	
	//1. 필드
	private Bicycle bicycle;
	
//	=============================================================

	//2. 생성자
	KiaPedal() {
		System.out.println("KiaPedal::default constructor() invoked.");
	} //기본 생성자

	KiaPedal(String brand, String model, String color, String material,
			double weight, int price) {
		this(brand, model, color, material, weight, price, null, 0);
		
		System.out.println("KiaPedal::constructor() invoked.");
	} //고유속성 필드에 대한 생성자
	
	KiaPedal(int maxRotation) {
		this(null, maxRotation);
		
		System.out.println("KiaPedal::constructor() invoked.");
	} //maxRotation 생성자
	
	KiaPedal(String direction, int maxRotation) {
		this(null, null, null, null, 0.0, 0, direction, maxRotation);
		
		System.out.println("KiaPedal::constructor() invoked.");
	} //상태 필드에 대한 생성자

	KiaPedal(String brand, String model, String color, String material,
			double weight, int price, String direction, int maxRotation) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.direction = direction;
		this.maxRotation = maxRotation;
		
		System.out.println("KiaPedal::constructor() invoked.");
	} //전체 필드에 대한 생성자

	//	==========================================================
	
	//3. 메소드
	
	public void setBicycle(Bicycle bicycle) {
		System.out.println("KiaPedal::setBicycle(bicycle) invoked.");
		
		this.bicycle = bicycle;
	} //setBicycle()
	
	// 1. 페달을 밟고, 속도 정하는 메소드.
	@Override
	public void press(int cadence) {	//메소드 호출할 때 기어박스 클래스의 기어레벨 가져오고, 분당회전수 입력하기
		System.out.println("KiaPedal::press(cadence) invoked.");
		
		GearBox gearbox = this.bicycle.getGearBox();
		RearTire reartire = this.bicycle.getRearTire();
		this.cadence = cadence;
		
		System.out.println("페달을 밟습니다.");
		
		reartire.roll();
		
		switch(gearbox.gearLevel) {
			case 1 -> {
				if(this.cadence == 60) {
					Bicycle.speed = 10;
				} else if(this.cadence == 70) {
					Bicycle.speed = 20;
				} else if(this.cadence == 80) {
					Bicycle.speed = 30;
				} else if(this.cadence == 90) {
					Bicycle.speed = 40;
				} else {
					System.out.println("페달 횟수를 60 ~ 90회로 조정해주십시오.");
					
//					this.setSpeed(cadence); => 안 되네...
					return;		//다시 케이던스를 입력받게 하고 싶은데 어떻게 해야할지 고민...
				} //if-elseif-else
			} //case 1
			case 2 -> {
				if(this.cadence == 50) {
					Bicycle.speed = 10;
				} else if(this.cadence == 60) {
					Bicycle.speed = 20;
				} else if(this.cadence == 70) {
					Bicycle.speed = 30;
				} else if(this.cadence == 80) {
					Bicycle.speed = 40;
				} else {
					System.out.println("페달 횟수를 50 ~ 80회로 조정해주십시오.");
					
					return;
				} //if-elseif-else
			} //case 2
			case 3 -> {
				if(this.cadence == 40) {
					Bicycle.speed = 10;
				} else if(this.cadence == 50) {
					Bicycle.speed = 20;
				} else if(this.cadence == 60) {
					Bicycle.speed = 30;
				} else if(this.cadence == 70) {
					Bicycle.speed = 40;
				} else {
					System.out.println("페달 횟수를 40 ~ 70회로 조정해주십시오.");
					
					return;
				} //if-elseif-else
			} //case 3
			case 4 -> {
				if(this.cadence == 30) {
					Bicycle.speed = 10;
				} else if(this.cadence == 40) {
					Bicycle.speed = 20;
				} else if(this.cadence == 50) {
					Bicycle.speed = 30;
				} else if(this.cadence == 60) {
					Bicycle.speed = 40;
				} else {
					System.out.println("페달 횟수를 30 ~ 60회로 조정해주십시오.");
					
					return;
				} //if-elseif-else
			} //case 4	
		} //switch expression
		
		System.out.println("분당 회전수 " + this.cadence + "회로 " + Bicycle.speed + "km/h의 속도입니다.");
	} //setSpeed()

	//2. 페달을 멈추는 메소드
		@Override
		public void stop() {
			System.out.println("KiaPedal::stop() invoked.");
			
			System.out.println("페달을 멈춥니다.");
		} //stop()

} //end class












