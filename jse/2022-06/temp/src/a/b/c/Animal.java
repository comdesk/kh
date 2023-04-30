package a.b.c;

public class Animal {
	public void sound() {;;}
	
	
		
		public static void main(String[] args) {
			Animal animal = new Person();
			animal.sound();
			
			animal = new Dog();
			animal.sound();
			
			animal = new Cat();
			animal.sound();
		} //main
	} //Person
	



class Person extends Animal {
	@Override
	public void sound() {
		System.out.println("엉엉");
	} //sound
} //Person

class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("멍멍");
	} //sound
} //Dog
	
class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println("야옹");
	} //sound
} //sound