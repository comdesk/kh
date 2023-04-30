package bicycle01;

public class Pedal2 {
	//1. 필드
	//고유속성 필드
	String brand;		//브랜드
	String model;		//모델명
	String color;		//색깔
	String material;	//재료: 알루미늄 합금, 티타늄, 마그네슘...
	double weight;		//무게
	int price;			//가격
		
	boolean isStep;      	//페달을 밟고 있는지, 안 밟고 있는지
	String direction;   	//페달을 밟는 방향: 앞, 뒤
	static int speed;   	//현재 속도
	static int maxSpeed; 	//최고 속도
	int cadence;        	//분당 회전수(rpm)
	boolean isBroken;   	//페달의 고장 여부
	 
//	==========================================================
	//2. static initializer 
	 
	static{
		Pedal2.speed = 0;
	    Pedal2.maxSpeed = 40;
	} //static initializer
	
//	==========================================================
		
	//3. 생성자
	Pedal2() {
		
	} //기본 생성자
	
	Pedal2(String brand, String model, String color, String material,
			double weight, int price) {
		this(brand, model, color, material, weight, price, false, null);
	} //고유속성 필드에 대한 생성자
	
	Pedal2(boolean isStep, String direction) {
		this(null, null, null, null, 0.0, 0, isStep, direction);
	} //상태 필드에 대한 생성자
	
	Pedal2(String brand, String model, String color, String material,
			double weight, int price, boolean isStep, String direction) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.isStep = isStep;
		this.direction = direction;
	} //전체 필드에 대한 생성자
	
//	==========================================================
	
	//4. 메소드.  
	// 1. 페달을 밟는 메소드.  
	void step() {    														
		if(this.isStep) {
			if(this.direction.equals("앞")) {         
				System.out.println("페달을 앞으로 밟습니다.");      
			} else if(this.direction.equals("뒤")) {         
				System.out.println("페달을 뒤로 밟습니다.");
				
				this.broken();
			} //if-else if
		} else {
			Pedal2.speed = 0;
			System.out.println("페달을 밟지 않습니다.");
		} //if-else
	} //Step
	
	//2. 페달과 속도에 대한 메소드
	void run(int cadence) {
		this.cadence = cadence;
		  
		if(this.isStep) {
			if(this.cadence < 50) {
				System.out.println("페달을 빠르게 밟아주십시오.");
			} else if(cadence <= 90) {
				if(this.cadence > 80) {
					Pedal2.speed = Pedal2.maxSpeed;
				} else if(this.cadence > 70) {
					Pedal2.speed = 30;
				} else if(this.cadence > 60) {
					Pedal2.speed = 20;
				} else {
					Pedal2.speed = 10;
				}
				
				System.out.println("분당 회전수 " + this.cadence + "회로 " + Pedal2.speed + "km/h의 속도입니다.");
			} else {
				this.broken();
			} //if-else if-else
	    	   		
		} //if 
	} //run
	 

	//3. 페달이 어떻게 고장나는지에 대한 메소드
	void howBroken() {
		if(this.direction.equals("뒤")) {
			this.isBroken = true;
			
			System.out.println("페달을 뒤로 밟지 마십시오.");
		} else if(cadence > 90) {
			this.isBroken = true;
			
			System.out.println("페달을 너무 세게 밟지 마십시오.");
		}
	} //whyBroken

	//4. 페달이 고장났을 때 메소드
	void broken() {
		this.howBroken();
		  
		if(this.isBroken) {
			this.isStep = false;
	       
			System.out.println("자전거가 고장났습니다.");
		} //if
	} //broken
} //end class












