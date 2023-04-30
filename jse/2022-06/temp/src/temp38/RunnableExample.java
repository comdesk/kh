package temp38;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RunnableExample {
	
	//java.lang.Runnable functional interface를 람다식으로 구현해서
	//새로운 스레드를 생성하는 데에도 얼마든지 람다식을 사용할 수 있다.(핵심)
	public static void main(String[] args) {
		log.info("Hello");
		
		/* Runnable runnable = () -> {
		 * 	 for(int i = 0; i < 10; i++) {
		 * 		log.info(i);
		 * 	 }
		 * };
		 * 
		 * Thread thread = new Thread(runnable);
		 * thread.start();
		 */
		
//		========================		
		
		//람다식으로 함수적 인터페이스의 구현객체를 생성하지 말아야 할 경우:
		//람다식의 실행블록(즉 함수적 인터페이스에 선언되어 있는 추상메소드의 재정의 블록)의 
		//구현 코드라인 수가 많을 수밖에 없으면 람다식으로 구현하면 안 된다.
		//이유: 람다식은 간결한 코드로, 추상메소드를 간단하게 구현하는 데 사용되는 것이지,
		//		인터페이스의 구현 클래스나 익명구현객체코딩기법을 완전히 대체하는 게 아니기 때문.
		
		//Thread(Runnable target) 생성자 호출
		//Runnable 함수적 인터페이스에 선언된 추상메소드:
		//public abstract void run();
		Thread thread = new Thread(() -> {		//메인이랑 별개로 또다른 실행흐름을 만들었다.
			for(int i = 0; i < 10; i++) {		//스레드가 구현시킬 코드를 람다식으로 만듦. => Runnable을 람다식으로 구현했으므로
				log.info(i);
			} //for
		});	//새로운 스레드 객체 생성 using Lambda Expression
		
		thread.setName("Hello");	//스레드의 이름 짓기
		thread.start(); 	//새로운 스레드 구동. => 이제서야 실행흐름이 만들어짐. 객체 생성했다고 스레드가 실행되는 건 아님.
	} //main

} //end class





