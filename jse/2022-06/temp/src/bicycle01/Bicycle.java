package bicycle01;

public class Bicycle {

	// 1.필드
	// 고유속성 필드
	String brand;			// 변속기 브랜드
	String model;			//      모델
	String color;			//      색깔
	String material;		//      재질 ex) 알미늄, 철, 프라스틱
	double	weight;			//      무게
	int price;				//      가격
	
	// 상태 필드				
	int speed; 				// 속도
	int gearLevel;			// 변속 기어
	String direction;		// 핸들 방향
	int chairHeight;		// 안장 높이
	boolean bikeLock;		// 자전거 잠금장치
	
	// 부품 필드
//	GearBox gearBox;			// 변속기
//	HandleBar handleBar;		// 핸들
	Pedal pedal;			// 페달
//	Seat seat;			// 안장
//	Wheel wheel;			// 바퀴
	
//	=======================
	
	//2. 생성자
	Bicycle() {
		
	}// dc
	
	Bicycle(Pedal pedal) {
		;
		
	} //con
	
	
} //end class













