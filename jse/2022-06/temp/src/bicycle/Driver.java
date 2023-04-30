package bicycle;


public class Driver {

	public Driver() {
		;;
	}	// 기본 생성자
	
	
	//페달, 타이어- roll();
	public void press(Bicycle bicycle,int cadence) { //자전거 객체넘겨주기, 사람과 전자계산기 클래스 관계 add 호출하기 위함	//00
		System.out.println("Driver::press(Bicycle bicycle,int cadence) invoked.");
		
		bicycle.press(cadence);
	}//drive

	public void turnLeft(Bicycle bicycle) {		// 좌회전
		System.out.println("Driver::turnLeft(Bicycle bicycle) invoked.");
		
		bicycle.turnLeft();
	}//turnLeft

	//우회전 시키기
	public void turnRight(Bicycle bicycle) {	// 우회전
		System.out.println("Driver::turnRight(Bicycle bicycle) invoked.");
		
		bicycle.turnRight();
	}//turnLeft

	//직진 시키기
	public void go(Bicycle bicycle) {	// 직진
		System.out.println("Driver::go(Bicycle bicycle) invoked.");
		
		bicycle.go();
	}//turnLeft

	//페달,타이어, 브레이크
	public void stop(Bicycle bicycle){	// 브레이크 작동
		System.out.println("Driver::stop(Bicycle bicycle) invoked.");
		
		bicycle.stop();
	} //stop 

	//기어박스, 페달 
	public void setGear(Bicycle bicycle, int gearLevel){	// 기어 단수 조절	//00
		System.out.println("Driver::setGear(Bicycle bicycle, int gearLevel) invoked.");
		
		bicycle.setGear(gearLevel);
	} //setGear 

	public void getOn(Bicycle bicycle){	// 앉다	//00
		System.out.println("Driver::getOn(Bicycle bicycle) invoked.");
		
		bicycle.getOn();
	} //getOn
	
	public void getOff(Bicycle bicycle){	// 내리다.
		System.out.println("Driver::getOff(Bicycle bicycle) invoked.");
		
		bicycle.getOff();
	} //getOff
	
	public void setSeat(Bicycle bicycle, int height) {	// 안장높이 조절	//00
		System.out.println("Driver::setSeat(Bicycle bicycle, int height) invoked.");
		
		bicycle.setSeat(height);
	}	// setSeat
	
	public void setadj(Bicycle bicycle, int adj) { // 브레이크 장력 설정
		System.out.println("Driver::setadj(Bicycle bicycle, int adj) invoked.");
		
		bicycle.setadj(adj);
	} // setadj
	
	

}	// end class
