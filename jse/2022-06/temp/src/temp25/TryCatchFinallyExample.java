package temp25;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TryCatchFinallyExample {

	public static void main(String[] args) {
		try {
			log.info("This is a try block.");
			
			String name = null;
			log.info("Length: {}", name.length());
			
			Class.forName("java.lang.String");
//			System.exit(0);
		} catch (NullPointerException e) {		
			e.printStackTrace();	//다형성-1에 의해 Exception이지만 NullPointerException을 잡을 수 있음.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			log.info("finally.");	//System.exit(0) 때문에 버추얼머신이 죽어버려서 finally 블록이라도 실행x
		} //try-catch-finally
			
		
	} //main

} //end class








