package temp22;

import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RemoteControlExample2 {
	public static void main(String[] args) {
		log.trace("main({}) invoked.", Arrays.toString(args));
		
		//**익명구현객체** 익명구현객체 코딩기법을 통해, 실제 구현 클래스를 만들지 않고
		//바로 구현객체를 생성하여 Lvalue의 인터페이스 타입의 참조변수에 대입합니다.
		//이름은 알 수 없지만(컴파일러만 알고 있음-묻기전까지) 인터페이스를 구현하는 객체를 만드는 기법(근데 이름 확인할 순 있음)
		
		RemoteControl rc = new RemoteControl() {	//다형성-1: 익명구현객체 생성
													//new 뒤에가 자식 객체가 되는 것임.
			//익명구현객체 코딩기법은 인터페이스로부터 빠르게 구현객체를 생성해는 기법으로
			//구현클래스 생성 없이 new와 함께 생성자가 없어도 생성자처럼 쓰고 중괄호로 쓰면 컴파일러가 자동으로 익명구현클래스를 만들어서 객체를 생성함.
			
			@Override
			public void turnOn() {
				log.trace("turnOn() invoked.");
			} //turnOn
			
			@Override
			public void turnOff() {
				log.trace("turnOff() invoked.");
			} //turnOff
			
			@Override
			public void setVolume(int volume) {
				log.trace("setVolume({}) invoked.", volume);
			} //setVolume
			
		};	//익명구현객체(Anonymous Implementation Object) 코딩기법
		
		log.info(">>>>>rc: " + rc);
		//>>>>>rc: temp22.RemoteControlExample2$1@2fd1433e  => $1은 첫번째 생성한 익명객체, $2,3...
		//인터페이스가 아니라 익명구현객체를 만든 클래스의 이름을 타입 이름으로 가짐.
		//익명구현객체기법은 컴파일러가 구현클래스를 만들어버림(클래스 없이는 객체가 없으므로)
		
		//인터페이스에 선언된 추상 메소드만 보고 사용 (다형성-2)
		rc.turnOn();
		rc.setVolume(RemoteControl.MIN_VOLUME);
		rc.turnOff();
	} //main
} //end class





