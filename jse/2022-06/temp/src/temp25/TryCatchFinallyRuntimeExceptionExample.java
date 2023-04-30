package temp25;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TryCatchFinallyRuntimeExceptionExample {

	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		
		try {
			log.info("-- 1st. Exception Handling -------------------");
			
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			
			log.error("실행 매개값의 수가 부족합니다.");	//예외 발생했을 때 해결 용법
			log.error("[실행 방법]");
			log.error("java TryCatchFinallyRuntimeExceptionExample num1 num2");
			
//			return;		//*** 종료시킴. 밑의 구문 실행x
			System.exit(1);		//종료코드로 왜 오류났는지 알려주고 죽는 System.exit(*)를 쓸 수도 있음.
		} //try-catch
		
//		====================
		
		try {
			log.info("-- 2nd. Exception Handling -------------------");
			
			int value1 = Integer.parseInt(data1);	//RuntimeException > NumberFormatException
			int value2 = Integer.parseInt(data2);	//RuntimeException > NumberFormatException
			//parseInt 메소드는 throws절로 exception을 보여주고 있으므로 처리해줘라.
			
			int result = value1 + value2;
			
			log.info(data1 + "+" + data2 + "=" + result);
		} catch (NumberFormatException e) {		//실행예외가 발생하면 어떻게 할래요?
			e.printStackTrace();
			
			log.info("숫자로 변환할 수 없습니다.");
		} finally {
			log.info("다시 실행하세요.");
		} //try-catch-finally
	} //main

} //end class










