package temp16;

public class Car {
	//1.필드
	private int speed;
	private boolean stop;
	
	//2.생성자
	public Car() {;;}	//default Constructor

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
	
//	===========================================
	
	
	
	//3. 메소드
	public int getSpeed() {
		return this.speed;
	} //getSpeed
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;		//스피드가 0보다 작을 수 없으므로 초기값을 0으로
			
			return;		//솔직히 return문장 없어도 메소드가 끝나지만, 추후에 생기든 말든 끝내라.
		} else {
			this.speed = speed;
		} //if- else
	} //setSpeed
	
	public boolean isStop() {
		return this.stop;
	} //isStop
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	} //setStop
} //end class









