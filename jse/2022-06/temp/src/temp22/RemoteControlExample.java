package temp22;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;				//부모타입
		
		rc = new Television();			//다형성-1: 자식타입의 객체가 생성/대입
		log.info("1. rc: {}", rc);
		
		rc.turnOn();
		rc.setVolume(RemoteControl.MAX_VOLUME);
		rc.turnOff();
		
		rc = new Audio();
		log.info("2. rc: {}", rc);		//다형성-1: 자식타입의 객체가 생성/대입
		
		rc.turnOn();
		rc.setVolume(RemoteControl.MAX_VOLUME);
		rc.turnOff();
	} //main
} //end class







