package temp37;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class QueueExample {

	public static void main(String[] args) {
		//1.Q Interface의 구현 객체를 생성/ 대입
		Queue<Message> messageQueue = new LinkedList<>();	//다형성-1
		
		//2.Q에 메시지 객체 넣기(offer)
		messageQueue.offer(new Message("sendMail", "홍길동"));		//다형성-2
		messageQueue.offer(new Message("sendSMS", "신용권"));		//다형성-2
		messageQueue.offer(new Message("sendKakaotalk", "홍두께"));	//다형성-2
		
		log.info("1. messageQueue: {}", messageQueue);
		
		//3. Q에 있는 요소를 하나씩 빼내면서(poll), Q가 비워질 때까지(until empty) 요소를 출력
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();	//요소 빼내기
			switch(message.command) {
				case "sendMail" -> log.info("{}님에게 메일을 보냅니다.", message.to);	
				case "sendSMS" -> log.info("{}님에게 SMS을 보냅니다.", message.to);	
				case "sendKakaotalk" -> log.info("{}님에게 카카오톡을 보냅니다.", message.to);		
			} //switch Expression
		} //while

	} //main

} //end class


// 인터페이스의 구성멤버(JAVA8 - 4가지) => JAVA9부터 6가지(private 인스턴스/정적메소드 추가)
//1. public static final 상수
//2. public abstract methods
//3. public default instance methods
//4. public static methods
//자바 9부터
//5. private instance methods	//디폴트나 정적 메소드가 너무 길면 쪼개서 하위 메소드로 만들기 위해서
//6. private static methods
interface IMyInterface {
	
	public default void defaultMethod() {
		//너무 많은 실행문장으로 구성 => private instance 메소드들로 쪼개서 구현하라
	} //defaultMethod
	
	public static void lenthystaticMethod() {
		//너무 많은 실행문장으로 구성 => private static 메소드들로 쪼개서 구현하라
	} //lenthystaticMethod
	
	//lengthy default method를 쪼개서 구현하라
	private void instanceMethod() {
		;;
	} //instanceMethod
	
	private void staticMethod() {
		;;
	} //staticMethod
	
	
	

} //end interface


