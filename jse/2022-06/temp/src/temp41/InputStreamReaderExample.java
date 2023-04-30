package temp41;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import lombok.Cleanup;

public class InputStreamReaderExample {
	
	//핵심포인트: 바이트 기반의 입력스트림(InputStream) => 문자기반 입력스트림(Reader)
	//			  자동 변환해주는 보조스트림에 대해
	public static void main(String[] args) throws IOException {
//		@Cleanup: 표준자원(표준입력/출력/에러)은 절대 닫으면 안 됨.
		InputStream is = System.in;	//표준입력(System.in = in의 타입은 InputStream)

		//바이트기반 입력스트림(InputStream) >  문자기반입력스트림으로 자동변환해주는
		//보조스트림 생성(이때, 생성자 매개변수로 base 스트림을 넣는다)
		//만일 보조스트림 생성자에 이미 base 스트림에 연결된 또 다른 보조스트림을 주면
		//"보조스트림 체인"이 형성된다
		@Cleanup Reader reader = new InputStreamReader(is, "utf-8");	//문자집합 지정 안하면 플랫폼의 문자집합 따라감.
		
		int readCharNo;
		char[] cbuf = new char[100];	//바가지도 문자기반의 배열로 바뀜(보조스트림으로 문자변환했으므로)
		
		while((readCharNo = reader.read(cbuf)) != 1) {	//강제종료하지 않으면 EOF가 없음
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		
		//자원해제: 핵심포인트2 - 보조스트림을 사용하는 경우 그림과 같이 프로그램에
		//가까운 보조스트림부터 차례대로 보조스트림 체인을 닫고 마지막으로 base 스트림을 닫는다.
		reader.close();	//보조스트림 해제
//		is.close();		//base 스트림 해제
	} //main

} //end class




