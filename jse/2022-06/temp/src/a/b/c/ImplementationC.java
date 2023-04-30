package a.b.c;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
public class ImplementationC 
	implements InterfaceC {
	
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
