package temp18;

//자식 클래스 extends 부모클래스 (단일상속만 지원)
//(*주의*) 하지만, "인터페이스"에서는 기본이 "다중상속"
public class DmbCellPhone extends Cellphone{
	//1. 필드
	int channel;	//default
	
	//2. 생성자
	DmbCellPhone(String model, String color, int channel) {	//default
		//앞의 두개는 부모 클래스의 필드 초기화를 위해 받은 것.
		
		//그래서 슈퍼에 자식 클래스의 생성자 전달인자 활용
		super(model, color);		//부모 클래스의 생성자 호출
//		super();	//부모클래스의 기본 생성자 호출(자바컴파일러가) => 벗, 의존하지 마라.
		//둘 중의 아무거나 해도 되지만 부모 생성자에 매개변수가 있다면 매개변수 있는 생성자를 써라.
		
		System.out.println("DmbCellPhone::constructor(String,String,int) invoked.");
		
		this.model = model;
		this.color = color;
		this.channel = channel;
	} //constructor
	
	//3. 메소드
	void turnOnDmb() {	//default
		System.out.println("DmbCellPhone::turnOnDmB() invoked.");
	} //turnOnDmb
	
	void changeChannelDmb(int channel) {	//default
		System.out.println("DmbCellPhone::changeCannelDmb(int) invoked.");
		
		this.channel = channel;
	} //changeCannelDmb
	
	void turnOffDmb() {	//default
		System.out.println("DmbCellPhone::turnOffDmB() invoked.");
	} //turnOffDmb
	
	void invokeAllMehotdsOfParentDirectly() {	//default
		System.out.println("DmbCellPhone::invokeAllMehotdsOfParentDirectly() invoked.");
		
//		System.out.println(">>> super: " + super);	//xxx
//		System.out.println(">>> this: " + this);	//ooo
		
		//아래와 같이, 자식 클래스이 내부에서는, "super"란 키워드(즉, 생성된 부모객체의
		//주소(참조)를 가지고 있는) 를 이용하여 직접 부모객체의 메소드와 필드 사용 가능
		super.powerOn();
		super.bell();
		super.sendVoice("여보세요");
		super.receiveVoice("안녕하세요! 저는 홍길동인데요");
		super.sendVoice("아~ 예 반갑습니다");
		super.hangUp();
		
		System.out.println(super.model);
		System.out.println(super.color);
	} //invokeAllMehotdsOfParentDirectly
	
	void invokeAllInheritedMehotd() {	//default
		System.out.println("DmbCellPhone::invokeAllMehotdsOfParentDirectly() invoked.");
		
//		System.out.println(">>> super: " + super);	//xxx
		System.out.println(">>> this: " + this);	//ooo
		
		//this.으로 물려받은 것 사용. 부모 객체로 안 감.
		this.powerOn();
		this.bell();
		this.sendVoice("여보세요");
		this.receiveVoice("안녕하세요! 저는 홍길동인데요");
		this.sendVoice("아~ 예 반갑습니다");
		this.hangUp();
		
		System.out.println(this.model);
		System.out.println(this.color);
	} //invokeAllMehotdsOfParentDirectly
	
} //end class



















