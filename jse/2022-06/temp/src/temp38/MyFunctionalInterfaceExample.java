package temp38;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		//1. 우리가 만든 functional interface 타입의 참조변수 선언
//		1st. Method - 인터페이스마다 직접 구현 클래스를 선언하고 객체도 직접 생성
//		Lvalue(Interface)			Rvalue(Implementation Class)
//		------------------------	-------------------------------
//		MyFunctionalInterface fi = new MyFunctionalInterfaceImpl();	//다형성-1
//		fi.method();	//다형성-2
		
//		================================================
		
//		2nd. Method - 익명구현객체코딩기법을 이용한 "익명구현객체 생성"
//		MyFunctionalInterface fi = new MyFunctionalInterface() {	//인터페이스는 생성자가 없지만 마치 기본생성자를 만들듯이 해라.
//																	//중괄호는 클래스 블록. 클래스 이름을 모르니 생성자는 생성 못함.
//			@Override
//			public void method() {
//				log.trace("method() invoked.");
//				
//			} //method
//			
//		}; //다형성-1: 익명구현객체 생성
//		
//		fi.method();
		
//		==================================================
		
//		3rd. Method - 람다식을 이용한 익명구현객체 생성
		//Step.1 Target Type인 Functional Interface에 선언되어 있는 오직 단 한 개의 추상메소드,
		//시그니처를 그대로 복사해온다.
		//public abstract void method();
		
		//Step.2 Step.1에서 복사해온 추상메소드에서 오직 "매개변수 선언부"만 떼어와라.
//		() => 추상메소드의 매개변수 선언부만 떼어 온 것
		
		//Step.3 Step.2에서 떼어 온 "매개변수 선언부"를 Target Type의 참조변수에 대입
//		MyFunctionalInterface fi = ();
		
		//Step.4 Step.3에서 Rvalue의 매개변수 선언부 뒤에 "->" 기호를 넣어라
//		MyFunctionalInterface fi = () -> ;
		
		//Step.5 Step.4에서 "->" 기호 오른쪽에 중괄호 블록 생성하라({})
//		MyFunctionalInterface fi = () -> {};	//아무것도 넣지 않아도 엄연히 오버라이딩 한 것임.
		
		//Step.6 Step.5가 정말 Target Type의 추상메소드를 재정의한 게 맞는지 검증
//		MyFunctionalInterface fi = () -> {
//			log.trace("**********************");
////			log.info("\t+ this: {}", this);	//지금 메인메소드 안이라 this 못 쓰는 것.
//		}; //다형성-1: 람다가 만든 익명구현객체 대입
//		
//		fi.method();	//다형성-2: 람다가 구현한 오버라이딩 된 메소드 수행
//		log.info("\t + fi: {}",fi);
//		
//		log.info("Real Type: {}", fi.getClass().getName());
		
//		=====================================
		
		MyFunctionalInterface fi2 = new MyFunctionalInterface() {

			@Override
			public void method() {
				log.trace("method() invoked.");
				log.info("\t+ this: {}", this);	//this: temp38.MyFunctionalInterfaceExample$1@446293d
			} //method
			
		}; //다형성-1:익명구현객체
		
		fi2.method();	//다형성-2
		log.info("\t + fi2: {}",fi2);			//fi2: temp38.MyFunctionalInterfaceExample$1@446293d
		
//		===================================
		
		MyFunctionalInterfaceExample obj = new MyFunctionalInterfaceExample();
		
		obj.instanceMethod();
		
		log.info("\t +1. obj: {}", obj);
		
		//2. 참조변수 초기화 by 람다식
		//	 그래서 람다식의 Target Type은 우리가 만든 MyFunctionalInterface이고
		//	 Overriding 대상 메소드는 public abstract void method(); 이다. 이 메소드의 구현 메소드를 만든다.
		
		//다형성-1
//		fi = () -> {
//			String str = "method call1";
//			log.info("1. str: {}", str);
//		};	//람다식으로 만든 "익명구현객체"
//		//Rvalue가 구현객체니까 오류가 안 난 것임. => 람다식이 구현객체 생성
//		
//		fi.method();	//다형성-2
//		
//		Class clazz = fi.getClass();
//		log.info("2. FQCN: {}", clazz.getName());	//2. FQCN: temp37.MyFunctionalInterfaceExample$$Lambda$99/0x0000000800d45088
//		
////		==========================
//		
//		fi = () -> { log.info("method call2"); };	//다형성-1	//변수에 저장 안하고 바로 출력
//		fi.method();	//다형성-2
//		
////		==========================
//		
//		//하나의 실행문만 있다면 중괄호 { } 생략 가능
//		fi = () -> log.info("method call3");	//다형성-1
//		fi.method();	//다형성-2
		
		
		
		
//		==========================
		//익명구현객체코딩기법
//		fi = new MyFunctionalInterface() {
//
//			@Override
//			public void method() {
//				log.trace("method() invoked.");
//				
//			} //method
//			
//		}; //익명구현객체 생성
//		
//		fi.method();	//다형성-2
//		
//		clazz = fi.getClass();
//		log.info("3.FQCN: {}", clazz.getName());	//3.FQCN: temp37.MyFunctionalInterfaceExample$1

	} //main
	
	public void instanceMethod() {
		MyFunctionalInterface fi = () -> {
			log.trace("**********************");
			log.info("\t+ 2. this: {}", this);
		}; //다형성-1: 람다가 만든 익명구현객체 대입
		
		fi.method();	//다형성-2: 람다가 구현한 오버라이딩 된 메소드 수행
		log.info("\t + 3. fi: {}",fi);
	} //instanceMethod

} //end class







