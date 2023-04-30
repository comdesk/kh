package temp19;

public class SportsCar 
	extends Car{
	
	@Override
	public void speedUp() {		//메소드 오버라이딩 수행(ok)
		speed += 10;
	} //speedUp
	
	//오버라이딩을 할 수 없음
//	@Override
//	public void stop() {	//상속받은  final 메소드의 재정의(overrideng)은 허용불가
//		//Cannot override the final method from Car
//		System.out.println("스포츠카를 멈춤");
//		
//		speed = 0;
//	} //stop
	
} //end class
