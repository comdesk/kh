package a.b.c;

public class People {
	public String name;
	public String ssn;
	
	public People(String name, String ssn) {
		System.out.println("People::constructor invoked.");
		this.name = name;
		this.ssn = ssn;
	} //constructor
} //end class
