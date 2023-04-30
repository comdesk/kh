package temp34;

import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WildCardExample {
	
	Course<?> course = new Course<Person>("일반인과정", 5);	//변수 앞에 붙이는 것이니 사용할 때인데, 필드에는 와일드카드 사용 가능
	Course<Person> course2;
		
	//(1) 구체타입으로 와일드카드 타입인 '?'이 어떤 의미를 가질까?
	//	  어떻게 와일드카드 타입을 사용해야할까?
	//모든 일반인을 대상으로 하는 과정을 출력
	public static void printCourse(Course<?> course) {	//구체타입: ?
		log.trace("printCourse({}) invoked.", course);
	} //printCourse
	
	//(2) 학생을 대상으로 하는 과정을 출력
	public static void printCourseStudent(Course<? extends Student> course) {	//구체타입: 제약된 ?
		log.trace("printCourseStudent({}) invoked.", course);
	} //printCourseStudent
	
	//(3) 근로자를 대상으로 하는 과정을 출력
	public static void printCourseWorker(Course<? super Worker> course) {	//구체타입: 제약된 ?
		log.trace("printCourseWorker({}) invoked.", course);
	} //printCourseWorker
	
	public static void main(String[] args) {
		//1. 첫 번째 과정 객체 생성(일반인 대상)
		Course<Person> personCourse = new Course<>("일반인과정", 5);	//@since 8

		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));			//다형성-1
		personCourse.add(new Student("학생"));			//다형성-1
		personCourse.add(new HighStudent("고등학생"));	//다형성-1
		
		//2. 두 번째 과정 객체 생성(직장인 대상)
		Course<Worker> workerCourse = new Course<>("직장인과정", 5);	//@since 8
		
		workerCourse.add(new Worker("직장인"));
		//Worker 이외에는 다형성으로 들어갈 수가 없음. Worker는 Person을 부모타입으로 가질 뿐이므로.
		
		//3. 세 번째 과정 객체 생성(학생 대상)
		Course<Student> studentCourse = new Course<>("학생과정", 5);	//@since 8
		
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));	//다형성-1
		
		//4. 네 번째 과정 객체 생성(고등학생 대상)
		Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);	//@since 8
		
		highStudentCourse.add(new HighStudent("고등학생"));
		
//		----------
		//1st. case: printCouse(Course<?> course)	//구체 타입만 다를 뿐이지 다 Course 객체
		printCourse(personCourse);		//ok	
		printCourse(workerCourse);		//ok
		printCourse(studentCourse);		//ok	
		printCourse(highStudentCourse);	//ok
		
//		----------
		
		//2nd. case: printCourseStudnet(Course<? extends Student> course)
//		printCourseStudent(personCourse);		//xx
//		printCourseStudent(workerCourse);		//xx
//		printCourseStudent(studentCourse);		//ok
//		printCourseStudent(highStudentCourse);	//ok
		

//		----------
		//3rd. case: printCourseWorker(Course<? super Worker> course)	
//		printCourseWorker(personCourse);		//ok
//		printCourseWorker(workerCourse);		//ok
//		printCourseWorker(studentCourse);		//xx
//		printCourseWorker(highStudentCourse);	//xx
		
	} //main

} //end class





