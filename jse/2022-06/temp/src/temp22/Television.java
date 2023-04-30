package temp22;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2				//Apache Log4j2 Logger 생성
@NoArgsConstructor	//기본 생성자 생성
public class Television implements RemoteControl {
	private int volume;
	
	
	@Override
	public void turnOn() {	//turnOn() 추상 메소드의 실체 메소드
		log.trace("turnOn() invoked.");	//trace() => Log Level: TRACE
	} //turnOn()

	@Override
	public void turnOff() {	//turnOff() 추상 메소드의 실체 메소드
		log.trace("turnOff() invoked.");

	} //turnOff()

	@Override
	public void setVolume(int volume) {	//setVolume() 추상 메소드의 실체 메소드
		log.trace("setVolume({}) invoked.", volume);	//매개변수의 값을 중괄호 기호 안에 찍게 됨.
														//찍고 싶은 매개변수 개수만큼 중괄호 기호 생성. 쉼표로 매개변수 구분
		
		if(volume > RemoteControl.MAX_VOLUME) {			//인터페이스의 static final 상수 사용
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME){
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		} //다중if
		
		log.info("현재 TV 볼륨: " + volume);	//일반로그 => INFO Level
	} //setVolume
	

} //end class
