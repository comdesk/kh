package temp23;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

//해당 인터페이스를 implements 하는 "구현클래스"라 부른다.
//구현클래스이름은 뒤에 Impl 붙인다.
@Log4j2
@NoArgsConstructor
public 
//abstract 
class IMyInterfaceImpl implements IMyInterface {
	
	//상속받은 추상메소드(=강제 규격)대로 "재정의(Method Overriding)"
	//더 이상 추상 메소드가 아니라 재정의(구현)했기 때문에 "abstract" 키워드는 삭제해줘야 한다.
	@Override
	public void abstractMethod() {
		log.trace("abstractMethod() invoked.");
		
	} //abstractMethod
	
	//부모 타입인 인터페이스로부터 public default 메소드가 상속된다(재정의하지 않고 그대로 사용 가능)
	//가. 상속되기 때문에 마음에 안들면 얼마든지 "재정의(Overriding)"할 수 있다.
	//나. 인터페이스 타입의 참조변수.디폴트메소드를 호출하면, 다형성-2에 의해서
	//	  - 인터페이스에 선언된 public default 메소드는 가려지고(hidden)
	//	  - 자식 타입인 "구현클래스"에 "재정의"된 메소드가 호출된다 (다형성-2)
	//다. 상속받는 것도 싫고, 재정의하는 것도 싫고, 아예 디폴트 메소드 자체가 있다는 게 마음에 안 들면
	//	  인터페이스에 선언된 디폴트 메소드를 아예 abstract 메소드로 바꿔버릴 수도 있다.
	//	  => 구현 클래스조차 추상 클래스로 변경해야 한다 (이런 경우 거의 없다)
	@Override
	public void defaultMethod() {
		log.trace("defaultMethod() invoked.");
	} //defaultMethod
	
//	public abstract void defaultMethod();
	
	
} //end class









