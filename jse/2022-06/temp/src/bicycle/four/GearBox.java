package bicycle.four;

public class GearBox {

	// 1.필드
	// 고유속성 필드
	String brand;		// 변속기 브랜드
	String model;		//      모델
	String color;		//      색깔
	String material;	//      재질 ex) 알미늄, 철, 프라스틱
	double	weight;		//      무게
	int price;			//      가격

	// 상태필드
	public int gearLevel;		// 1~4단
	static int speed;
	String direction;		// 변속 방향 (위 : 변속 상향 / 아래 : 변속 하향)

	private Bicycle bicycle;
	
	// static initializer

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	static{
		GearBox.speed = 0;
	} //static initializer

	//생성자
	public GearBox() {
		;;
	}

	GearBox(String brand, String model, String color, String material,
			double weight, int price) {
		this(brand, model, color, material, weight, price, 0, null);
	} // 고유속성필드 생성자
	
	GearBox(int gearLevel) {
		this(gearLevel, null);
	} //gearLevel 생성자(내가 추가한 것)
	
	GearBox(int gearLevel, String direction) {
		this(null, null, null, null, 0.0, 0, gearLevel, direction);
	} // 상태필드 생성자

	GearBox(String brand, String model, String color, String material,
			double weight, int price, int gearLevel, String direction){
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.gearLevel = gearLevel;
		this.direction = direction;
	} // 전체 필드 생성자

	//메소드

	void run(int gearLevel) {
		this.gearLevel = gearLevel;

		if(gearLevel == 1) {
			GearBox.speed = 10;
			System.out.println(gearLevel + "단 입니다." + GearBox.speed + "km/h");
		} else if(gearLevel == 2) {
			GearBox.speed = 20;
			System.out.println(gearLevel + "단 입니다." + GearBox.speed + "km/h");
		} else if(gearLevel == 3) {
			GearBox.speed = 30;
			System.out.println(gearLevel + "단 입니다." + GearBox.speed + "km/h");
		} else if(gearLevel ==4) {
			GearBox.speed = 40;
			System.out.println(gearLevel + "단 입니다." + GearBox.speed + "km/h");
		}
	}
}
