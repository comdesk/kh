package temp41;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
//	핵심포인트: 파일 입력 수행을 위하여 FileInputStream의 사용법
//	주의: 실제 파일이 존재해야 한다. => FileNotFoundException
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/TTT.dat");
					
			int data;
			
			//입력스트림(강에 물이 흐르듯이 파일데이터인 바이트가 흘러들어오는 것)으로부터
			//손으로 1바이트씩 퍼내겠다.
			while((data = fis.read()) != -1) {	//EOF
				System.out.write(data);
			} //while
			
			fis.close();
		} catch(IOException e) {
			e.printStackTrace();
		} ///try-catch
		
		
	} //main

} //end class
