package temp25;

import java.io.IOException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MultiCatchExample {
	
	//다중 Catch가 아니라 Multi-Catch 구문에 대해서 배우자
	public static void main(String[] args) {
		
		try {
			String data1 = args[0];
			String data2 = args[1];
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			
			int result = value1 + value2;
					
			log.info(data1 + "+" + data2 + "=" + result);	//파이프 기호 n개 쓸 수 있다.
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {		//Multi-Catch
			e.printStackTrace();
			
			try {
				log.error("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
			} catch(Exception e1) {;;}	//throws절이 없어 예외가 발생 안해도 Exception을 넣으면 오류나지 않는다.
										//그러나 중첩된 catch절 안에서 같은 변수 이름 e를 쓰면 중복돼서 오류남.
										//매개변수는 지역변수로 간주하므로 => e1, e2 이런식으로 이름 지음.
										//printStackTrace도 안찍고 아무것도 처리 안하는 케이스가 많다.(알 필요도 없는 오류일 때)
			
		} catch(Exception e) {
			e.printStackTrace();
			
			log.error("알 수 없는 예외 발생");
		} finally {
			log.info("다시 실행하세요.");
		} //try-catch-finally
	} //main
	
	private static int staticMethod(String number) 
			throws NumberFormatException, IllegalArgumentException, IOException {	//여러 개 예외 던질 수 있음.
		//강제로 개발자가 지정한 예외를 만들어 throw하는 구문에 대해서 배워보자
		if(number.equals("100")) {
			throw new NumberFormatException("100");	//예외 클래스의 생성자를 이용해서 예외 객체를 만듦.-> 메소드의 호출자한테 던져라.
		} else if(number.equals("200")) {
			throw new IllegalArgumentException("200");	//위의 throws절에 없다. 런타임 익셉션이라 오류는 안나지만 throws절에 기재해야 한다.
		} else if(number.equals("300")) {
			throw new IOException("300"); 	//checked exception은 throws절에 없으면 무조건 오류.
		} //if-else if
		
		return 0;
		
//		return Integer.parseInt(number);
//		int intValue = Integer.parseInt(number);
//		
//		return intValue;
	} //staticMethod
} //end class








