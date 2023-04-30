package temp37;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
//선입선출(FIFO)의 자료구조에 저장할 요소객체
public class Message {
	public String command;
	public String to;
	
} //end class
