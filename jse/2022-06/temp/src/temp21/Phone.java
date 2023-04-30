package temp21;

//추상 클래스 => 다형성에서 부모타입의 역할인 규격을 자식 객체에 강제하는 역할 수행
//			  => 객체를 생성할 수 없다. => 왜? 여러 실체들의 공통 속성/메소드를 추출
public abstract class Phone {	//"abstract" 키워드를 타입선언부에 기재해야 한다.
	//1.필드
	public String owner;
	
	
	//2.생성자
	public Phone(String owner) {
		System.out.println("Phone::constructor(owner) invoked.");
		
		this.owner = owner;
	} //constructor
	
	//3.메소드
	public void turnOn() {
		System.out.println("Phone::turnOn() invoked.");
	} //turnOn()
	
	public void turnOff() {
		System.out.println("Phone::turnOff() invoked.");
	} //turnOff()
	
	
} //end class
