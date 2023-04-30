package bicycle.four;

public class Pedal {
	//1. 필드
		//고유속성 필드
		public String brand;		//브랜드
		public String model;		//모델명
		public String color;		//색깔
		public String material;	//재료: 알루미늄 합금, 티타늄, 마그네슘...
		public double weight;		//무게
		public int price;			//가격
		
		//상태 필드
		
		public String direction;   	//페달을 밟는 방향: 앞, 뒤
		public int cadence;        	//분당 회전수(rpm)
		public boolean isBroken;   	//페달의 고장 여부
		public int maxRotation;     			//최대 회전수(최대 수명)
		public int accumulatedRotation;			//누적 회전수
	
	public boolean press(String direction) {return false;}
	public void setSpeed(int cadence) {;;}
	public void roll() {;;}
} //end class
