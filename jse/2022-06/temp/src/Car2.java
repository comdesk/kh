
public class Car2 {
	
	//1. 필드
	private int speed;
	private boolean stop;
		
	//2. 생성자
	public Car2() {;;}	//dc

//	public int getSpeed() {
//		return speed;
//	}
//
//	public void setSpeed(int speed) {
//		this.speed = speed;
//	}
//
//	public boolean isStop() {
//		return stop;
//	}
//
//	public void setStop(boolean stop) {
//		this.stop = stop;
//	}
		
	//3. 메소드
	public int getSpeed() {
		return this.speed;
	} //getSpeed
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			
			return;
		} else {
			this.speed = speed;
		} //if-else
	} //setSpeed
	
	public boolean isStop() {
		return this.stop;
	} //isStop
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	} //setStop
	
} //end class










