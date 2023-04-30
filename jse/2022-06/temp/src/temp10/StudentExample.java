package temp10;

public class StudentExample {
	
	//객체의 설계도인, 클래스를 이용해서 객체를 생성해보자.
	public static void main(String[] args) {
		//첫 번째 학생 객체의 생성 => new 클래스의 생성자();
		Student s1 = new Student();
		System.out.println(s1);
		//Rvalue가 생성한 객체의 주소를 변수에 저장하려고 클래스를 만듦.
		//Student@24d46ca6: 참조 변수에 저장된 "객체의 레퍼런스(참조/주소)"
		
//		====
		
		//첫 번째 학생 객체의 생성 => new 클래스의 생성자();
		Student s2 = new Student();
		System.out.println(s2);
	} //main
} //end class
