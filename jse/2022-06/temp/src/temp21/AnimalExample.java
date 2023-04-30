package temp21;

public class AnimalExample {

	public static void main(String[] args) {
		Dog dog = new Dog();	//자식객체 생성
		Cat cat = new Cat();	//자식객체 생성
		
		//자식객체를 만드는 순간 부모객체를 만드니까 부모객체를 만들지 않아도 이미 존재
		
		dog.sound();			//상속받아 재정의된 메소드 호출
		cat.sound();			//상속받아 재정의된 메소드 호출
		
//		------------------
		
		//변수의 자동 타입 변환(promotion)
		Animal animal = null;	//부모타입
		animal = new Dog();		//다형성-1
		animal.sound();			//다형성-2
		animal = new Cat();		//다형성-1
		animal.sound();			//다형성-2
		System.out.println("-----");
		
//		-------------------
		
		//매개변수의 자동 타입 변환
		animalSound(new Dog());
		animalSound(new Cat());
		
	} //main
	
	public static void animalSound(Animal animal) {	//다형성-1
		animal.sound();	//다형성-2
	} //animalSound

} //end class










