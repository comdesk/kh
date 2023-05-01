package org.zerock.myapp.thread;

import java.util.Arrays;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ExerciseThread01 {

	//새로운 스레드(Thread) 생성
	public static void main(String[] args) throws InterruptedException {
		//자바언어에서 스레드(실행흐름) => 모델링 => java.lang.Thread 클래스
		log.trace("main([]) invoked.", Arrays.toString(args));
//		Thread t1 = new Thread(new Task());	//새로운 스레드의 이름: Thread-N (디폴트)
//		Thread t1 = new Thread(new Task(), "UserThread");	//새로운 스레드의 이름을 직접 지정
		
//		Thread t1 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {		//User Thread의 실행진입점 (Entry Point)
//				log.trace("run() invoked.");
//				
//			} //run
//			
//		},"UserThread");	//2번째 방법: 익명구현객체로 Runnable 객체 제공
		
		Thread t1 = new Thread(() -> {	//3번째 방법: 람다식 (익명구현객체 생성) 제공
			log.trace("run() invoked.");
			
			for(int i = 1; i < 100; i++) {
				log.trace("- UserThread -");
				
				try {
					Thread.sleep(1000*1);	//현재 스레드의 실행을 멈추고 잠자라 (ms단위)
				} catch (InterruptedException e) {
					;;
				}
			} //while
			
			log.info("****** UserThread 스레드는 죽습니다 ******");
		}, "UserThread");
		
		//main 스레드가 죽을 때, 함께 같이 따라서 죽는 User Thread => 데몬(Daemon) 스레드
		t1.setDaemon(true); 		//Daemon 스레드로 설정		
		
		//User Thread의 실행
		t1.start(); 			//main thread와는 별개로 User thread가 생성/실행(run 메소드 실행)
		
		Thread.sleep(1000 * 5); //5초동안 메인스레드를 일시정지시킵니다.
		
		log.info("****** main 스레드는 죽습니다 ******");
	} //main -> 메인 스레드가 죽어서 버추얼 머신이 죽음.
} //end class

@Log4j2
@NoArgsConstructor
class Task implements Runnable {

	//User Thread의 Entry Point
	@Override
	public void run() {
		log.trace("run() invoked.");
		
		//새로운 실행흐름이 수행할 일련의 자바 실행 문장을 여기에 넣으면
		//User Thread는 이 자바 실행 문장을 수행시킴.
	} //run	-> 스레드는 자동으로 파괴됨.
	
} //end class