package bicycle.four;

import temp20.FrontTire;

public class MyPedal 
	extends Pedal{
	
	//1. 필드
	private Bicycle bicycle;
	
//	=============================================================

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	//2. 생성자
	MyPedal() {
		;;
	} //기본 생성자

	MyPedal(String brand, String model, String color, String material,
			double weight, int price) {
		this(brand, model, color, material, weight, price, null, 0);
		
		System.out.println("Pedal::constructor() invoked.");
	} //고유속성 필드에 대한 생성자
	
	MyPedal(int maxRotation) {
		this(null, maxRotation);
	} //maxRotation 생성자
	
	MyPedal(String direction, int maxRotation) {
		this(null, null, null, null, 0.0, 0, direction, maxRotation);
	} //상태 필드에 대한 생성자

	MyPedal(String brand, String model, String color, String material,
			double weight, int price, String direction, int maxRotation) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.direction = direction;
		this.maxRotation = maxRotation;
	} //전체 필드에 대한 생성자

	//	==========================================================
	
	//3. 메소드

	// 1. 페달을 밟는 메소드.
	@Override
	public boolean press(String direction) {		//direction은 메소드 매개변수로 받기
		System.out.println("Pedal::step(String) invoked.");
		
		this.direction = direction;
		boolean isStart = false;	//isStart는 자전거가 출발할 수 있는지에 대한 변수 => 나중에 플래그변수로 사용.
		
		
			if(this.direction.equals("앞")) {	//페달 방향이 앞이면 해당 문구 출력하고 isStart = true
				System.out.println("페달을 앞으로 밟습니다.");
				
				isStart = true;
			} else if(this.direction.equals("뒤")) {	//페달 방향이 뒤면 해당 문구 출력하고 isStart = false
				System.out.println("페달을 뒤로 밟지 않습니다. 앞으로 밟으십시오.");

				isStart = false;
			} //if-else if
			return isStart;			//isStart 값 리턴
			
			//체인, 뒷바퀴 메소드 호출

	} //Step()
	
	//2. 페달 속도 설정	
	@Override
	public void setSpeed(int cadence) {	//메소드 호출할 때 기어박스 클래스의 기어레벨 가져오고, 분당회전수 입력하기
		System.out.println("Pedal::setSpeed(int, int) invoked.");
		
		GearBox gearbox = this.bicycle.getGearBox();	
		this.cadence = cadence;
		
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
	
	
	//3. 페달을 돌렸을 때
	//3-1. 1km씩 페달 횟수 측정 & 고장 -> 속도에 따라 페달 횟수가 결정된다.
	@Override
	public void roll() {
		System.out.println("Pedal::roll() invoked.");
		
		double minute = 0;
		
		switch(Bicycle.speed) {			
			case 10 -> minute = 6;			//스피드가 10이면 6분 만에 도달
			case 20 -> minute = 3;			//스피드가 20이면 3분 만에 도달
			case 30 -> minute = 2;			//스피드가 30이면 2분 만에 도달
			case 40 -> minute = 1.5;		//스피드가 40이면 1.5분 만에 도달
		} //switch expression
		
		this.accumulatedRotation = this.accumulatedRotation + (int)(this.cadence * minute);		//임시: 1km씩 페달 횟수 측정(*고민하기: run()을 만약 반복문으로 돌린다면 1번 반복에 몇 분 or 몇 km라고 할지..*)
																								//1번 반복 시 누적 회전수에 누적회전수*시간 더하기.
		if(this.accumulatedRotation < this.maxRotation) {		//Bicycle run 1번 반복 당 누적되는 회전수와 최대 회전수를 비교
			System.out.println("페달 수명: " + (this.maxRotation - this.accumulatedRotation) + "회");	//누적회전수가 회전수보다 작다면 페달 생존
		} else {
			System.out.println("*** 페달이 고장났습니다. 페달을 교체해주십시오.");						//누적회전수가 회전수보다 작다면 페달 고장 => 교체
		} //if-else
	} //roll()
	
	//3-2. 6분 페달 횟수 측정 & 고장
	public void roll2() {
		System.out.println("Pedal::roll() invoked.");
		
		int minute = 6;
		
		this.accumulatedRotation = this.accumulatedRotation + (this.cadence * minute);		//임시: 6분씩 페달 횟수 측정(*고민하기: run()을 만약 반복문으로 돌린다면 1번 반복에 몇 분 or 몇 km라고 할지..*)
		
		if(this.accumulatedRotation < this.maxRotation) {
			System.out.println("페달 수명: " + (this.maxRotation - this.accumulatedRotation) + "회");
		} else {
			System.out.println("*** 페달이 고장났습니다. 페달을 교체해주십시오.");
		} //if-else
	} //roll2()
	
} //end class












