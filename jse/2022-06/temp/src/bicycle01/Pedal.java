package bicycle01;

public class Pedal {
	//1. 필드
	//고유속성 필드
	String brand;		//브랜드
	String model;		//모델명
	String color;		//색깔
	String material;	//재료: 알루미늄 합금, 티타늄, 마그네슘...
	double weight;		//무게
	int price;			//가격
		
	//상태 필드
	boolean isStep;      	//페달을 밟고 있는지, 안 밟고 있는지
	String direction;   	//페달을 밟는 방향: 앞, 뒤
	static int speed;   	//현재 속도
	static int maxSpeed; 	//최고 속도
	int cadence;        	//분당 회전수(rpm)
	int maxRotation;		//페달을 돌릴 수 있는 최고 회전수
	boolean isBroken;   	//페달의 고장 여부
	
//	==========================================================
		
	//2. 생성자
	Pedal() {
		
	} //기본 생성자
	
	Pedal(String brand, String model, String color, String material,
			double weight, int price) {
		this(brand, model, color, material, weight, price, false, null);
	} //고유속성 필드에 대한 생성자
	
	Pedal(boolean isStep, String direction) {
		this(null, null, null, null, 0.0, 0, isStep, direction);
	} //상태 필드에 대한 생성자
	
	Pedal(String brand, String model, String color, String material,
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
	
	//스피드
	//
	
	
} //end class












