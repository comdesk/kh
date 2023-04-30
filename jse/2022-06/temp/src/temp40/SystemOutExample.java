package temp40;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutExample {
	
	//핵심포인트: 표준 자원인 표준출력(System.out)을 이용해보자
	public static void main(String[] args) throws Exception {
		OutputStream os = System.out;	//1. 표준 출력을 참조변수에 저장
		
		for(byte b = 48; b < 58; b++) {	//2. ASCII 테이블에서 48~57까지의 숫자를 그대로
			os.write(b);				//표준출력을 통해 출력하면 문자로 출력
		} //for
		
		os.write(10);	//LF(Line Feed, 행바꿈 문자) 출력
		
//		=========
		
		for(byte b = 97; b <123; b++) {	//2. ASCII 테이블에서 97~122까지의 숫자를 그대로
			os.write(b);				//표준출력을 통해 출력하면 문자로 출력
		} //for
		
		os.write(10);	//LF(Line Feed, 행바꿈 문자) 출력
		
		os.write(100);
		os.write(101);
//		os.write(500);	//아스키코드를 기본으로 출력시키는데 아스키코드는 범위가 127까지
		
		for(int i = 128; i <= 200; i++) {
			os.write(i);
		} //for
//		=========
		
		String hangul = "가나다라마바사아자차카타파하";
		
		byte[] hangulBytes = hangul.getBytes();	//String -> byte[] 변환
		
		os.write(hangulBytes);	//byte[] 출력
		
		os.flush();  //강제 flush
	} //main

} //end class
