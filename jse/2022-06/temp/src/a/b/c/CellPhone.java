package a.b.c;

public class CellPhone {
	//1.필드
	String model;
	String color;
	
	//2.생성자
	public CellPhone() {
		
	} //default constructor
	
	public CellPhone(String model, String color) {
		System.out.println("CellPhone::constructor(String, String) invoked.");
		
		this.model = model;
		this.color = color;
	} //constructor
	
	//3.메소드
	void powerOn() {
		System.out.println("CellPhone::powerOn() invoked.");
	} //powerOn
	
	void powerOff() {
		System.out.println("CellPhone::powerOff() invoked.");
	} //powerOff
	
	void bell() {
		System.out.println("CellPhone::bell() invoked.");
	} //bell
	
	void sendVoice(String message) {
		System.out.println("CellPhone::sendVoice(String) invoked.");
		
		System.out.println("자기: " + message);
	} //sendVoice
	
	void receiveVoice(String message) {
		System.out.println("CellPhone::receiveVoice(String) invoked.");
		
		System.out.println("상대: " + message);
	} //receiveVoice
	
	void hangUp() {
		System.out.println("CellPhone::hangUp() invoked.");
	} //hangUP
	
	
	
} //end class














