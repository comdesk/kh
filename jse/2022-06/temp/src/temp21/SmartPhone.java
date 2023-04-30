package temp21;
		  //실체클래스(=Concrete class): 추상클래스의 자식
public class SmartPhone extends Phone {	//Phone은 추상클래스
	
	public SmartPhone(String owner) {
		super(owner);
		
		System.out.println("SmartPhone::constructor(owner) invoked.");
	} //constructor
	
	public void internetSearch() {
		System.out.println("SmartPhone::internetSearch() invoked.");
	} //internetSearch
} //end class
