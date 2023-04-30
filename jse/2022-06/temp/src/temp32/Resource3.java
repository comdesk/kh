package temp32;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class Resource3 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		log.trace("close() invoked.");

	} //close

} //end class
