package temp18;

public class Cellphone {	//휴대전화 클래스: 어떤 종류의 휴대폰이든 여기에 속함
	//1. 필드
	String model;
	String color;
	
	//2. 생성자
	public Cellphone() {
		
	} //default constructor
	
	public Cellphone(String model, String color) {
		System.out.println("Cellphone::constructor(String, String) invoked.");
		
		this.model = model;
		this.color = color;
	} //constructor
	
	//3. 메소드
	void powerOn() {
		System.out.println("Cellphone::powerOn() invoked.");
	} //powerOn
	
	void powerOff() {
		System.out.println("Cellphone::powerOff() invoked.");
	} //powerOff
	
	void bell() {
		System.out.println("Cellphone::bell() invoked.");
	} //bell
	
	void sendVoice(String message) {
		System.out.println("Cellphone::sendVoice(String) invoked.");
		
		System.out.println("자기: " + message);
	} //sendVoice
	
	void receiveVoice(String message) {
		System.out.println("Cellphone::receiveVoice(String) invoked.");
		
		System.out.println("상대: " + message);
	} //receiveVoice
	
	void hangUp() {
		System.out.println("Cellphone::hangUp() invoked.");
	} //hangUp()
	
} //end class












