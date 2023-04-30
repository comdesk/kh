package a.b.c;

public class Student 
extends People{
	
	public int studentNo;
	
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		System.out.println("Student::constructor invoked.");
		this.studentNo = studentNo;
	} //constructor
} //end class
