package temp18;

public class StudentExample {
	
	//대전제: 부모없는 자식은 없다.
	//		  그래서, 자식 객체를 생성할 땐, 부모 객체부터 완전하게 생성돼야 한다.
	public static void main(String[] args) {
		Student student = new Student("홍길동", "123456-1234567", 1);
		
		System.out.println("name: " + student.name);
		System.out.println("ssn: " + student.ssn);
		System.out.println("studentNo: " + student.studentNo);
	} //main
} //end class
