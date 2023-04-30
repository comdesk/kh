package temp18;

public class Student 		//Student가 People을 extends 받는다.
	extends People {
	
	public int studentNo;
	
	public Student(String name, String ssn, int studetNo) {
		super(name, ssn);
		this.studentNo = studentNo;
	} //Constructor
} //end class
