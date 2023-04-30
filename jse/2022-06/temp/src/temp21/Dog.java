package temp21;

//오류: The type Dog must implement the inherited abstract method Animal.sound()
public 
//	abstract 	-두 번째 선택지: 상속된 추상메소드(강제규격)를 구현하기 싫으면
//								 자식타입도 추상클래스로 만들어라. (이러면 또 자식객체를 만들어야 함.)
	class Dog extends Animal{
	
	public Dog() {
		System.out.println("Dog::default constructor invoked.");
		
		this.kind = "포유류";	
	} //default constructor
	
	//첫 번째 선택지: 강제된 규격을 무조건 구현(재정의)해야 함.
	@Override
	public void sound() {		
		System.out.println("Dog::sound() invoked.");
	} //sound
} //end class
