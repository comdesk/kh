package temp39;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileWriterExample {
	
	//핵심포인트: 문자기반의 파일에 출력하는 FileReader에 대해서 알자
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Temp/TTT.dat");
		
		FileWriter fw = new FileWriter(file, true);	//두 번째 매개변수: 추가모드(append)
		
		try(fw;) {
			fw.write("FileWriter는 한글로 된 " + "\r\n");
			fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
			
			fw.flush();	//강제 flush 반드시 한 번 수행
			
			log.info("File write done.");
		} //try-with-resources		

	} //main

} //end class
