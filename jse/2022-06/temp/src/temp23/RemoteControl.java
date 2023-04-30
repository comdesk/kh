package temp23;

public interface RemoteControl {
	//인터페이스 구성 멤버 #1 - static final 상수(불변의 진리값)
	public static final int MAX_VOLUME = 10;	//앞에 3개를 다 생략해도 컴파일러가 자동으로 생성해줌. => 그래도 생략하지 말기!
//	int MIN_VOLUME = 0;		//=public static final int MIN_VOLUME = 0;
	public static final int MIN_VOLUME = 0;
	
	//인터페이스 구성 멤버 #2 - 추상 메소드
	public abstract void turnOn();	//앞에 2개 생략해도 컴파일러가 자동 생성 => 벗, 의존x
	public abstract void turnOff();
	public abstract void setVolume(int volume);
	
//	====== @until 7 ======
	
//	====== @since 8 ======
	//인터페이스 구성 멤버 #3 - 디폴트 메소드(default methods)
	//디폴트 메소드가 인스턴스 메소드로 나온 이유: 기존 타켓객체의 기능의 확장을 위해서
	public default void setMute(boolean mute) {		//**** 인스턴스 메소드이다!
		if(mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		} //if-else
	} //setMute
	
	//인터페이스 구성 멤버 #4 - 정적 메소드(static methods) -> 정적멤버는 정적멤버답게(인터페이스명.정적메소드명)
	//이유: 기존 타켓객체의 기능의 확장을 위해서(디폴트 메소드랑 생성 이유 같음)
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	} //changeBattery
	
} //end interface














