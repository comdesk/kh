package temp21;

public class Cat extends Animal {
	
	public Cat() {
		System.out.println("Cat::default constructor invoked.");
		
		this.kind = "표유류";
	} //default constructor
	
	@Override
	public void sound() {	//상속받은 추상메소드(강제규격) 재정의(구현). abstract 키워드는 뺀다.
		System.out.println("Cat::sound() invoked.");
	} //sound()

} //end class
