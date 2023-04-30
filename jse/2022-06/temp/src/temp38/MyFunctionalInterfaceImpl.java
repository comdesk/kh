package temp38;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class MyFunctionalInterfaceImpl 
	implements MyFunctionalInterface {

	@Override
	public void method() {
		log.trace("method() invoked.");

	} //method

} //end class
