package temp23;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

//여러 상위 인터페이스를 상속받는 하위 인터페이스 하나만 implements 합니다.
//이럼으로써, 이 구현 클래스가 지켜야 할 여러 유형의 규격을 상속계층구조를 이용하여
//체계적으로 관리하고 동시에 구현 클래스도 하나의 하위 인터페이스만 implements함으로써
//다중 상속의 복잡도를 줄이고 규격을 체계있게 관리할 수 있게 된다.

@NoArgsConstructor
@Log4j2
public class ImplementationC 
	implements InterfaceC {				//하나의 타입만 extends하든, implements하든,
										//왼쪽과 같이 아래 행으로 내려서 코딩하는 게 일반적인 관례
	
	//InterfaceA 규격 구현(재정의)
	@Override
	public void methodA() {
		log.trace("methodA() invoked.");
	} //methodA
	
	//InterfaceB 규격 구현(재정의)
	@Override
	public void methodB() {
		log.trace("methodB() invoked.");
	} //methodB
	
	//InterfaceC 규격 구현(재정의)
	@Override
	public void methodC() {
		log.trace("methodC() invoked.");
	} //methodC

} //end class








