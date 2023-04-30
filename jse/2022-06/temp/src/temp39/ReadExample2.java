package temp39;

import java.io.FileInputStream;
import java.io.InputStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReadExample2 {
	
	//핵심포인트: 파일 입력스트림에서 바이트를 읽을 때, 양동이로 푸자
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp/Hello.txt");
		
		int readByteNo;	//실제 입력스트림에서 읽어낸 바이트 개수를 저장하는 변수
		
		byte[] readBytes = new byte[3];	//양동이 생성(크기: 3)
		String data = "";
		
		while(true) {	//무한루프
			readByteNo = is.read(readBytes);	//인자로 주어진 양동이로 퍼냄.
			
			
			//파일의 끝(EOF, End-Of-File)을 만나면 무한루프 종료시킴.
			if(readByteNo == -1) {	//탈출조건
				break;
			} //if
			
			//양동이에 저장된 바이트를 가지고 문자열 조각(Token)을 만들어서
			//계속 이전의 Token과 이어 붙임.
			data += new String(readBytes, 0, readByteNo);	//문자열은 정수코드값이니, 정수로 문자열을 만들 수 있다.
															//배열이 꽉 채워지지 않을 수도 있으니 offset과 length를 줘야 함.
//			System.out.println(data + "-" + readByteNo);
		} //while
		
		System.out.print(data);	//최종 문자열을 출력
		is.close();	//입력스트림 자원 객체 해제
		

	} //main

} //end class







