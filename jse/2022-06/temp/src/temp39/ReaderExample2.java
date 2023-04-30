package temp39;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.Charset;

import lombok.Cleanup;

public class ReaderExample2 {

	public static void main(String[] args) throws Exception {
		@Cleanup
		Reader reader = new FileReader("C:/Temp/TTT.dat", Charset.forName("utf-8"));
		
		//문자기반스트림에서 양동이는 byte[] 이 아니라, char[]이다.
		char[] cbuf = new char[2]; 
		String data = "";
		
		while(true) {	//무한루프
			//실제 읽어낸 문자 개수를 반환
			int readCharNo = reader.read(cbuf);	//Using Bucket, char[] array
			
			if(readCharNo == -1) break;	//탈출조건 when countering EOF(End-Of-File)
			
			data += new String (cbuf, 0, readCharNo);	//문자열 토큰 생성 및 연결
		} //while
		
		System.out.println(data);
	} //main

} //end class






