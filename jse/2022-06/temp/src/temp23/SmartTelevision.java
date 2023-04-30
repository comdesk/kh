package temp23;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
public class SmartTelevision implements RemoteControl, Searchable {
	private int volume;
	
//	-- RemoteControl 인터페이스의 추상메소드(=강제규격) 재정의

	@Override
	public void turnOn() {
		log.trace("turnOn() invoked.");
	} //turnOn

	@Override
	public void turnOff() {
		log.trace("turnOn() invoked.");
	} //turnOff

	@Override
	public void setVolume(int volume) {
		log.trace("setVolume({}) invoked.", volume);
	} //setVolume
	
//	-- Searchable 인터페이스의 추상메소드(=강제규격) 재정의
	
	@Override
	public void search(String url) {
		log.info("search({}) invoked.", url);
	} //search

} //end class
