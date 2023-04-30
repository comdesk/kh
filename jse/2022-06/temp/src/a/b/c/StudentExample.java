package a.b.c;

public class StudentExample {
	public static void main(String[] args) {
		Student student = new Student("홍길동", "12345", 10);
		
		System.out.println("name: " + student.name);
		System.out.println("ssn: " + student.ssn);
		System.out.println("studentNo: " + student.studentNo);
	} //main
} //end class
