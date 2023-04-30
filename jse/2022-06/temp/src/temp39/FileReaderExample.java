package temp39;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
	
	//문자기반 입력스트림인 Reader에 대해서 사용법 익히자
	public static void main(String[] args) throws IOException {
		//운영체제 공통의 파일경로 구분자(Path Separator)는 Slash('/')
		FileReader fr = new FileReader("C:/Temp/TTT.dat");
		
		int readCharNo;
		char[] cbuf = new char[10];	//바가지

		while((readCharNo = fr.read(cbuf)) != -1) {
			//char[] => String(Token)으로 변환(도구: String 클래스의 생성자)
			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);
		} //while
		
		fr.close();
	} //main

} //end class
