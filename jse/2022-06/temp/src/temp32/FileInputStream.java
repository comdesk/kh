package temp32;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

//어떤 클래스인가? 파일을 읽는 기능을 제공하는 클래스(가상으로 만듦)
@Log4j2
//@NoArgsConstructor	//기본 생성자
@AllArgsConstructor		//모든 인스턴스 필드를 매개변수로 가지는 생성자
public class FileInputStream implements AutoCloseable {
	private String file;
	
	public void read() {
		log.info("read() invoked.");
	} //read
	
	@Override
	public void close() throws Exception {
		log.info("close() invoked.");		
	} //close

} //end class
