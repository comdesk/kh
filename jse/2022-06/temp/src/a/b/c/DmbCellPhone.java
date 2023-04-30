package a.b.c;

public class DmbCellPhone extends CellPhone{
	//1.필드
	int channel;
	
	//2.생성자
	DmbCellPhone(String model, String color, int channel) {
		super(model, color);
//		super();
		
		System.out.println("DmbCellPhone::constructor(String,String,int) invoked.");
		
//		this.model = model;
//		this.color = color;
		this.channel = channel;
	} //DmbCellPhone
		
	//3.메소드
	void turnOnDmb() {	//default
		System.out.println("DmbCellPhone::turnOnDmb() invoked.");
	} //turnOnDmb
	
	void changeChannelDmb(int channel) {
		System.out.println("DmbCellPhone::changeChannelDmb(int) invoked.");
	} //changeChannelDmb
	
	void invokeAllMethodsOfParentDirectly() {
		System.out.println("DmbCellPhone::invokeAllMehotdsOfParentDirectly() invoked.");
	
		super.powerOn();
		super.bell();
		super.sendVoice("여보세요");
		super.receiveVoice("안녕하세요! 저는 홍길동인데요");
		super.sendVoice("아~ 예 반갑습니다");
		super.hangUp();
		
		System.out.println(super.model);
		System.out.println(super.color);
	
	} //invokeAllMehotdsOfParentDirectly
	
	void turnOffDmb() {
		System.out.println("DmbCellPhone::turnOnDmb() invoked.");
	} //turnOnDmb
	
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

















