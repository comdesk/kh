package bicycle;

public class HandleBar {

	//필드
	// 고유속성 필드
	String brand;			//브랜드명
	String model;			//모델명
	String color;			//색깔
	String material;		//재료(Aluminum, Carbon Fiber,Steel...)
	double	weight;			//무게
	int price;				//가격
	boolean isBasket;		//핸들 바구니 여부

	//상태 필드

	int	distanceKm;			//이동거리
	int directionLevel;		//range -3 ~ 3, 0 정면, -1
	int degree = 0;				//핸들의 각도(왼쪽 30도, 오른쪽 30도) //10km까지는 정면으로 달립니다.
	static int maxDegree = 45;
	static int minDegree = -45;

	String direction;			//핸들의 방향, 문자열

	boolean isVoidObstacles;		//10km, 20Km 구간에서 장애물을 피할 수 있는지


	//	==============================================================

	static {

		HandleBar.maxDegree = 45;
		HandleBar.minDegree = -45;
	}

	//	==============================================================

	//생성자
	public HandleBar(){
		;;
	} // 기본 생성자

	HandleBar(String brand, String model, String color, String material, double weight, int price, boolean isBasket) {
		this(brand, model, color, material, weight, price, isBasket, null, 0);
	} // 고유속성 필드 생성자

	HandleBar(String direction, int degree){
		this(null, null,null, null, 0.0, 0, false, direction, degree);
	} // 상태 필드 생성자

	HandleBar(String brand, String model, String color, String material, double weight, int price, boolean isBasket, String direction, int degree){
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.isBasket = isBasket;
		this.direction = direction;
		this.degree = degree;
	} // 전체 필드 생성자

	//	==============================================================

	//메소드

	public void turnLeft() {;;} 	//규격정의
	public void turnRight() {;;}	//규격정의
	public void go() {;;}		//규격정의

	public void setBicycle(Bicycle bicycle) {
		
		
	} //setBicycle
}//end class

