package temp32;

import java.util.Scanner;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ResourcesExample {
	
	//try-with-resources 블록에 대한 향상된 문법과 상세한 용법
	public static void main(String[] args) throws Exception {
		//@till JAVA 7
//		try(Resource1 res1 = new Resource1()) {
//			
//		} catch(Exception e) {			//try블록의 끝나기 직전에 jvm이 close() 자동 호출되는데 checked exception인
//			                            //Exception을 throws하므로 직접 처리 or 던져야 한다.
//			e.printStackTrace();
//		} //try-catch
		
		// <----------------- 이 방향으로 각각의 자원 객체를 자동으로 close한다.
//		try(	//소괄호 안에 n개의 자원 객체 생성 가능. 세미콜론으로 구분. 마지막 자원객체 생성의 실행문장의 세미콜론은 생략 가능
//				Resource1 res1 = new Resource1();	
//				Resource2 res2 = new Resource2();
//				Resource3 res3 = new Resource3();	//벗, 생략하지는 말기
//			) {
//			;;
//		} //try-with-resources	//예외를 위로 던지면 try블록 단독 사용 가능
		
//		===================
		
		//@Since Java 8
//		Resource1 res1 = new Resource1();	
//		Resource2 res2 = new Resource2();
//		Resource3 res3 = new Resource3();
//		
//		// <----------------- 이 방향으로 각각의 자원 객체를 자동으로 close한다.
//		try(res1; res2; res3;) {	//역시 마지막 참조변수 세미콜론 생략 가능하나 생략하지 말기(더 추가되거나 빠질 수도 있으므로)
//			;;
//		} //try-with-resources

//		================
		
		//lombok의 자원객체 닫아주는 어노테이션 기반으로 닫자
//		try {
//			@Cleanup							//main block 끝에서 닫힘.
//			Resource1 res = new Resource1();
//		} catch(Exception e) {;;}	//자원 객체를 close하다가 발생하는 예외는 우리가 처리하지 않음. => pass
		
		
		//중간에서 자원객체 활용코드...
		
//		res.close();	//1. 개발자가 직접 close() 메소드 호출하여 닫아줌
						//2. try-with-resources block 사용
						//3. lombok's @Cleanup annotation 사용
		
//		================
		
		//lombok의 자원객체 닫아주는 어노테이션 기반으로 하되,
		//자원 객체들 간에 역시 닫는 순서가 정해져 있다면??
		
		//닫는 순서:(1)res2 (2) res3 (3) res1
		//try-catch문 순서를 바꾼다.
		
//		try {									//하나의 try-catch로 하면 오류나는 순간 catch로 가버리기 때문에
//			@Cleanup							//개별 try-catch로 해야함.
//			Resource2 res2 = new Resource2();
//		} catch(Exception e) {;;}
//		
//		try {
//			@Cleanup
//			Resource3 res3 = new Resource3();
//		} catch(Exception e) {;;}
//		
//		try {
//			@Cleanup
//			Resource1 res1 = new Resource1();
//		} catch(Exception e) {;;}
		
//		try {
//			@Cleanup
//			Resource1 res1 = new Resource1();
//			@Cleanup							
//			Resource2 res2 = new Resource2();
//			@Cleanup
//			Resource3 res3 = new Resource3();
//		} catch(Exception e) {;;}
		//3-2-1 실행 블록 끝에서 가까운 것부터 닫는다.
		
//		==========
		
		//사용자정의 블록으로 닫는 순서 정하기 (블록 끝만 만나면 작동하는 게 @Cleanup이므로)
		
		{
			@Cleanup
			Resource3 res3 = new Resource3();
			
			Scanner scanner = new Scanner(System.in);
			
			int number1 = scanner.nextInt();	//사용자가 값을 잘못 넣으면? 어떤 예외로?
			int number2 = scanner.nextInt();	//아니면 그냥 값을 다시 넣게?
			int result = number1 + number2;		//결정하기 어렵다. => 경험 필요
			
			log.info(result);
			throw new Exception("User-defined Exception");
		} //User-defined block
//		{
//			@Cleanup("close")	//default 속성
//			Resource1 res1 = new Resource1();
//		} //User-defined block
//		{
//			@Cleanup/*("destroy")*/	//destroy 메소드를 불러와서 닫겠다.
//			Resource2 res2 = new Resource2();
//		} //User-defined block
		
	} //main

} //end class












