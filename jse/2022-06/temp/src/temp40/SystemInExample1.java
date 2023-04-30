package temp40;

import java.io.InputStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SystemInExample1 {
	
	//표준입력(즉, 키보드)의 사용 예: 사용자의 키보드 입력을 수신
	public static void main(String[] args) throws Exception {
		System.out.println("==메뉴==");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료 하기");
		System.out.println("메뉴를 선택하세요: ");
		
		InputStream is = System.in;	//표준 입력(InputStream 객체임)
		
//		int java.io.InputStream.read() throws IOException
		char inputChar = (char) is.read();	//1byte return (4바이트 int로 반환) (1바이트씩 읽어 다국어는 깨짐)
		switch(inputChar) {
		case '1' -> log.info("예금 조회를 선택하셨습니다.");
		case '2' -> log.info("예금 출금을 선택하셨습니다.");
		case '3' -> log.info("예금 입금을 선택하셨습니다.");
		case '4' -> log.info("종료 하기를 선택하셨습니다.");
		} //switch expression

	} //main

} //end class
