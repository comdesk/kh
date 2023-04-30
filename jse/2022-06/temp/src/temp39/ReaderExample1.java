package temp39;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import lombok.Cleanup;

public class ReaderExample1 {
	
	//핵심포인트: 문자 기반의 파일입력스트림 Reader에 대해서 배우자
	//문자기반의 입/출력스트림(Reader/Writer)는 문자기반 입/출력에
	//아주 편리한 기능을 제공한다.
	public static void main(String[] args) throws Exception {
		//Charset 타입의 객체를 생성하고, UTF-8 문자집합을 지정하는 방법
		Charset utf8 = Charset.forName("utf-8");
		Charset utf_8 = StandardCharsets.UTF_8;
		Charset defaultCharset = Charset.defaultCharset();	//JVM의 문자집합 획득
		
		@Cleanup
		Reader reader = new FileReader("C:/Temp/TTT.dat", StandardCharsets.UTF_8);
		
//		int readData;
		while(true) {
			int readData = reader.read();	//한 문자씩 읽어내는 read 메소드
			
			if(readData == -1) break;	//탈출조건
			System.out.print((char) readData);
		} //while

	} //main

} //end class
