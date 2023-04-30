package temp24;


class Animal {;;}					//부모 클래스
class Dog extends Animal {;;}		//상속하는 자식 클래스#1
class Cat extends Animal {;;}		//상속하는 자식 클래스#2


public class ClassCastExceptionExample {
	
	//3번째 가장 많이 발생하는 실행 예외( Runtime Exception): "ClassCastException"
	public static void main(String[] args) {	//static method
		Dog dog = new Dog();					//자식 객체 생성
		ClassCastExceptionExample.changeDog(dog);							//Invoke static method
		int age = 0;
		Cat cat = new Cat();					//자식 객체 생성
		ClassCastExceptionExample.changeDog(cat);							//Invoke static method
	} //main
	
	public static void changeDog(/* 다형성-1 */ Animal animal) {
		if(animal instanceof Dog dog) {		//안전하게 형변환
			//다형성-1에 의해 부모품에 꽈악 안겨잇는 자식객체를 강제로 빼냄
//			Dog dog = (Dog)animal;		//*ClassCastException* 발생 가능
			
		} //if
	} //changeDog
	
} //end class
