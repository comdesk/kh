package temp39;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class ReadExample1 {
	
	//핵심포인트: 파일을 소스로, 파일의 데이터를 읽어보자!(바이트 기반으로)
	public static void main(String[] args) throws Exception {
		//1. 바이트 기반의 파일 입력 스트림 객체 생성
		InputStream is = 
				//경로구분자(Path Separator): Windows('\'), 리눅스/맥/유닉스('/')
				//운영체제 상관 없이 공통의 경로구분자: '/'
				//경로구분자: 폴더와 폴더를 구분해주는 기호
				new FileInputStream("C:/Temp/hello.txt");	//다형성-1
		
		//2. 파일로부터 읽어낸 **"1바이트"**를 저장하는 변수 선언
		int readByte;	//read()가 1바이트씩 읽어냄에도 4바이트인 int로 리턴하기 때문에 int로 타입 설정
						//바이트는 정수고, 정수 연산은 기본이 int이기 때문에로 추론..
		
		//3. 파일의 끝을 만날 때까지 계속해서 반복적으로 파일의 내용을 읽어서 콘솔에 출력
		while(true) {	//무한루프
			readByte = is.read();	//파일입력스트림에서 1바이트를 읽어냄.
			
			if(readByte == -1) {	//탈출조건: 읽어낸 값이 -1이면, 파일의 끝(EOF)을 의미
									//EOF: End-Of-File
				break;
			} //if
			
			System.out.print((char) readByte);	//읽어낸 바이트를 콘솔로 출력 시 "문자"로 출력
												//int지만 실질적으로 1바이트만 들어있으므로 강제형변환해도 데이터 유실은 없다.
		} //while
		
		//4. 모든 입/출력 스트림 객체는 소위 "자원객체"이다.
		//	 즉 AutoClosable하므로 다 사용하면 반드시 닫아 줘서 자원을 JVM으로 반납해야 한다.
		is.close();
	} //main

} //end class




