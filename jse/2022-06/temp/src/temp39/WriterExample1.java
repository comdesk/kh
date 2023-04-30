package temp39;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WriterExample1 {
	
	//핵심포인트: 문자기반의 출력스트림인 FileWriter 객체를 사용해보자
	public static void main(String[] args) throws IOException {
		@Cleanup
		Writer writer = new FileWriter("C:/Temp/TTT.dat", StandardCharsets.UTF_8,true);
		
//		=====================================
		//문자열(String) => char[] 배열로 변환
//		char[] data = "홍길동".toCharArray();
//		
//		for(int i = 0; i < data.length; i++ ) {
//			writer.write(data[i]);	//한 문자씩 쓰기
//		}
//		=====================================
		
		writer.write("홍길동");		//write(String) 메소드 이용해서 출력
		
		
		writer.flush();	//출력버퍼(8KB)의 강제 flushing
	} //main

} //end class




