package temp19;

public class Car {
	//1. 필드
	public int speed;
	
	//2. 생성자
	public Car() {;;}	//default constrcutor
	
	//2. 메소드
	public void speedUp() {
		this.speed += 1;
	} //speedUp
	
	//3. final 메소드 (***): 자식 클래스에서 메소드 오버라이딩을 허용하지 않겠다.(상속은 가능)
	public final void stop() {
		System.out.println("차를 멈춤");
		
		this.speed = 0;
	} //stop
	
} //end class
