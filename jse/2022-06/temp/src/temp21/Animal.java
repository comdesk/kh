package temp21;

//다형성과 관련된 규격의 강제성을 가지게 한다. 누구에게? 자식객체에..
public abstract class Animal {	//추상메소드가 단 하나라도 있으면무조건 abstract키워드를
								//타입 선언부에 붙여야 한다.
	public String kind;
	
	public Animal() {
		System.out.println("Animal::default constructor invoked.");
	} //default constructor
	
	public void breathe() {
		System.out.println("Animal::breathe() invoked.");
	} //breathe()
	
	//(1) 메소드의 구현부(중괄호 블록)가 없는 메소드 => "추상 메소드"
	//(2) 추상메소드는 반드시 메소드 시그니처에 "abstract"키워드를 붙여야 한다.
	public abstract void sound();	//추상메소드(abstract method)
} //end class
