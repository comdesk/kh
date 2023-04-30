package temp19;

public class Child 
	extends Parent {
	
	public Child() {
		System.out.println("Child::default constructor invoked.");
	} //default constructor
	
	@Override
	public void method2() {
		System.out.println("Child::method2() invoked.");
	} //method2()
	
	public void method3() {
		System.out.println("Child::method3() invoked.");
	} //method3()
} //end class
