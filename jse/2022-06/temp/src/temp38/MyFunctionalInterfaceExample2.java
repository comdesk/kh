package temp38;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFunctionalInterfaceExample2 {
	//추상메소드: 매개변수 o, 리턴타입 x 인 경우에 람다식을 만드는 예제

	public static void main(String[] args) {
//		public void method(int x);
		
		MyFunctionalInterface2 fi;
		
		//***************************************************************
		//생략조건1: 매개변수 선언부의 각 매개변수에 타입은 생략 가능하다. => 인자값으로부터 타입 추론 가능
		//생략조건2: 매개변수 선언부의 매개변수 개수가 단 1개뿐이면 소괄호도 생략 가능
		//***************************************************************
//		fi = (int x) -> {			//함수적 인터페이스에 선언된 추상메소드의 구현 블록
//		fi = (x) -> {		//생략조건1
		fi = x -> {			//생략조건1 + 생략조건2
			int result = x * 5;
			log.info(result);
		};	//람다식: 익명구현객체 생성
		fi.method(2);
		
//		=============
		
		//***************************************************************
		//생략조건1: 매개변수 선언부의 각 매개변수에 타입은 생략 가능하다.
		//생략조건2: 매개변수 선언부의 매개변수 개수가 단 1개뿐이면 소괄호도 생략 가능
		//생략조건3: 중괄호블록({}) 안의 실행문장의 개수가 단 1개뿐이면 중괄호 기호도 생략 가능
		//***************************************************************
//		fi = x -> { log.info(x * 5); };
		fi = x -> log.info(x * 5);	//생략조건3
		fi.method(5);
		
//		==============
		//메소드 참조
		//1. 메소드 참조란 말그대로 메소드를 참조(=사용)하겠다란 의미
		//이 메소드 참조는 람다식과는 다른 것이지만, 람다식의 목표와는 동일 => 간결한 코드
		//2. 메소드 참조는 어떻게 만드는가?
		//	(1) 람다식에서
		//	(2) 매개변수가 1개이든 2개이든
		//	(3) 실행문장이 하나일 때
		//	(4) 실행문장에 매개변수가 그대로 전달만 되어서 사용될 때(매개변수의 가공이 전혀 없을 때)
		//		=> 이때 람다식을 "메소드 참조"로 바꿀 수 있는데
		//	(5) 메소드 참조의 문법: <참조변수::메소드이름>
		//		=> 메소드 참조는 람다식을 통째로 바꾸는 것.
		//		=> 메소드 참조 != 람다식
		fi = x -> log.info(x);	//람다식
		fi = log::info;	//메소드 참조 (메소드 참조는 매개변수가 없다)
		
		fi = x -> System.out.println(x);	//람다식
		fi = System.out::println;	//메소드 참조
		
		fi.method(5);
		
//		=================
		
		List<Integer> list = Arrays.<Integer>asList(1,2,3);
		
		//forEach 메소드의 매개변수가 바로 함수적 인터페이스이고, => 구현객체를 주면 됨.
		//그 안에 선언된 추상메소드 단 1개: void accept(T t);
		
		//1st. Method: 익명구현객체코딩기법
		Consumer<Integer> consumer = new Consumer<>() {	//Consumer는 데이터의 소비자. 소비할 데이터 타입을 구체타입으로 지정

			@Override
			public void accept(Integer t) {
				log.trace("accept({}) invoked.", t);	
			} //accept
			
		};	//익명구현객체
		
		//2nd. method: 람다식						 //이 메소드는 매개변수만 사용하는 게 아니라 로그도 만드므로 메소드 참조 못 함.
		Consumer<Integer> consumer2 = (Integer t) -> log.trace("lambda({}) invoked.", t);	//익명구현객체
		
		//3rd. method: 메소드 참조(Method Reference)
		//조건: 람다식 전제이고, 실행문장이 오작 1개, 
		//매개변수(몇 개이든)가 그냥 실행문장의 메소드에 그대로 전달되어 사용될 때
		Consumer<Integer> consumer3 = log::trace;	//호출문구는 포기..
//									  = t -> log.trace(t);
		
//		------------------------
		list.forEach(consumer3);
		
	} //main

} //end class










