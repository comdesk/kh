package temp20;

public class Bicycle {
	//부품필드(규격): 부모타입으로 선언 => 다형성1을 이용해서 자식부품객체를 대입
	private FrontTire frontTire;
	private Handle handle;
	
				  //매개변수의 다형성 - 각 매개변수에 전달인자는 바로 자식객체임.
				  //---------------------------------
	public Bicycle(FrontTire frontTire, Handle handle) {
		System.out.println("Bicycle::constructor(frontTire, handle) invoked.");
		
		this.frontTire = frontTire;	//다형성-1: 필드의 다형성(실행클래스에서 매개변수에 자식객체가 대입됨)
		this.handle = handle;
	} //constructor

	public FrontTire getFrontTire() {
		System.out.println("Bicycle::getFrontTire() invoked.");
		
		return this.frontTire;
	} //getFrontTire()

	public Handle getHandle() {
		System.out.println("Bicycle::getHandle() invoked.");
		
		return this.handle;
	} //getHandle()
	
	public void drive() {
		System.out.println("Bicycle::drive() invoked.");
		//Step.1 페달의 press 메소드 호출 => 이 메소드만 호출함. 페달의 press 메소드 내에서 체인, 뒷바퀴(Go) 메소드 호출
		//Step.2 체인의 동력전달(transferEnergy) 메소드 호출(여기서 호출x)
	}	//drive
	
	public void turnLeft() {
		System.out.println("Bicycle::turnLeft() invoked.");
		
		this.handle.turnLeft();		//어느 회사에서 만든 타이어를 꼈든 잘 돌아가게 하려면 규격 사용.
	} //turnLeft					//좌회전 규격 메소드 출력
	
} //end class









