package temp18;

public class Animal {
	
	//소리를 내라! 라는 의미의 메소드
	public void sound() {;;}
	
	public static void main(String[] args) {
		Animal animal = new Person();	//사람 객체 생성	//다형성 1. 어떻게 애니몰 타입에 다른 타입이 들어가냐
		animal.sound();			//다형성 2. 애니몰이 갖고 있는 메소드를 호출했는데 애니몰 메소드는 비었는데 어떻게 출력이 되냐
//		---
		
		animal = new Dog();				//강아지 객체 생성
		animal.sound();
//		---
		
		animal = new Cat();
		animal.sound();
		
	} //main
} //end class

//============

class Person extends Animal {	//Animal 상속
	@Override
	public void sound() {	//Animal이 물려준 메소드를 다시 만들었음.
		System.out.println("엉엉 ㅠㅠㅠㅠㅠ");
	} //sound
	
	
} //end class

//============

class Dog extends Animal {	//Animal 상속
	@Override
	public void sound() {
		System.out.println("멍멍 ㅠㅠㅠㅠㅠ");
	} //sound
} //end class

//============

class Cat extends Animal {	//Animal 상속
	@Override
	public void sound() {
		System.out.println("야옹 ㅠㅠㅠㅠㅠ");
	} //sound
} //end class





