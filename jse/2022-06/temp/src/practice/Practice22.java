package practice;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Practice22 {

	public static void main(String[] args) {
		AQueue<Integer> cq = new CircularQueue<Integer>(26);
		
		for(Integer i = 65; i <= 90; i++) {
			cq.offer(i);
		} //for
		
//		cq.offer(65);
		
		cq.poll();
		
		cq.offer(91);
		
		cq.poll();
		
		cq.offer(92);
		
//		log.info((char)((int)cq.peek()));
		
		log.info(cq.peek());

	} //main

} //end class
