package temp23;

import java.util.Arrays;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class Closure {
	
	private static MyInterface anonymousObj;
	
	public static void main(String[] args) {
		log.trace("main({}) invoked.", Arrays.toString(args));
		Closure obj = new Closure();
		obj.run("Yoseph");
		//The local variables: name, age in the run() method destroyed.
		anonymousObj.instanceMethod();	//다형성-2	name, age 잘 나옴.
		anonymousObj.instanceMethod();	//다형성-2	name, age 잘 나옴.
		
	} //main
	
	public void run(String name) {	//매개변수1: 지역변수로 간주한다
		log.trace("run({}) invoked.", name);
		
		int age = 23;	//지역 변수2 정의
//		age = 18;
		
		
		double weight = 58.9;	//지역 변수3 정의 (익명구현객체 내에서 사용x)
		
		//대전제: 지역변수의 유효범위(생명주기)는 자신이 선언된 중괄호 블록이 끝나면 파괴된다
		
		//====================================
		//MyInterface에 대한 익명구현객체 생성
		//====================================
		
		anonymousObj = new MyInterface() {	//다형성-1

			@Override
			public void instanceMethod() {
				log.trace("instanceMethod() invoked.");
				
				//과연 익명구현객체 내부에서 this는 무엇을 의미할까?
				//우리가 아는 그 this일까?
				log.info("\t + this: {}", this);
				
				//---------------------------------
				//익명구현객체 코딩이 들어간 메소드 내의 지역변수 사용
				log.info("\t+ name: {}, age: {}", name, age);	//age를 고치니까 final이라 못 고친다고 오류뜸.
			} //instanceMethod
			
		};	//익명구현객체
		
		log.info("+ anonymousObj: {}", anonymousObj);	//참조변수의 레퍼런스 출력
		anonymousObj.instanceMethod();	//다형성-2
	} //run
} //end class










