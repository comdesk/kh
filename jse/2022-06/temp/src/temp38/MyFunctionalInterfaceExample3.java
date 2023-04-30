package temp38;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFunctionalInterfaceExample3 {
	
	//추상메소드: 매개변수 o, 리턴타입 o 함수적 인터페이스를
	//어떻게 람다식으로 구현하는가?
	public static void main(String[] args) {
		//***************************************************************
		//생략조건1: 매개변수 선언부의 각 매개변수에 타입은 생략 가능하다.
		//생략조건2: 매개변수 선언부의 매개변수 개수가 단 1개뿐이면 소괄호도 생략 가능
		//생략조건3: 중괄호블록({}) 안의 실행문장의 개수가 단 1개뿐이면 중괄호 기호도 생략 가능
		//생략조건4: 실행문장이 값을 리턴하는 return 문장일 때에는 "return" 키워드는 무조건 생략해야 함.
		//			 (가능이 아니라 무조건 생략)
		//***************************************************************
		
		//핵심: 매개변수도 있고 리턴타입도 있는 추상메소드의 람다식 구현
//		public abstract int method(int x, int y);
		
		MyFunctionalInterface3 fi;
		
		fi = (x, y) -> {			//람다식
			int result = x + y;		//덧셈 수행
			
			return result;			//리턴타입대로 값 반환
		};	//익명구현객체
		
		log.info(fi.method(2, 5));
		
//		===================
		
		fi = (x, y) -> { return x + y; };
		log.info(fi.method(2, 5));
		
//		===================
		
		//화살표 기호 오른쪽에 남아 있는 식이 표현식(값을 생성하는 식)이라면
		//그 앞에 return 키워드가 생략된 것이다.라고 알면 된다.
		//표현식: 1. 리터럴 2. 변수 3. 연산식
		fi = (x, y) -> x + y;		//생략 조건4
		fi = (x, y) -> 1;
		
		int returnValue = 100;
		fi = (x, y) -> returnValue;
		
		log.info(fi.method(2, 5));
		
//		===================
					  //값을 생성하므로 return 문장 생략된 것임.
		fi = (x, y) -> sum(x, y);	//정적 메소드 호출 (메소드 호출해서 얻어지는 값은 표현식이라고 하진 않음)
		log.info(fi.method(2, 5));  //					(만약에 배열이나 컬렉션으로 돌려줄 수도 있으므로)
		
//		fi = (x, y) -> log.info("x: {}, y: {}", x, y); //값을 생성 안함 => return 문장 아님.
		
//		===================
		
		//리턴 문장은 메소드 참조의 대상이 되지 못한다.
		fi = (x, y) -> x + y; //실행문장은 맞지만 메소드 호출문장도 아니고 return문장은 메소드 호출문장이 아니기 때문에
	} //main
	
	public static int sum(int x, int y) {	//람다식은 자신이 생성된 블록에 영향을 받기 때문에, 람다식이 인스턴스메소드라도,
		return (x + y);						// 람다식이 static인 main에서 생성됐기 때문에 람다식 내에서 쓰이려면 정적메소드로 만들어야 함.
	} //sum
	
} //end class










