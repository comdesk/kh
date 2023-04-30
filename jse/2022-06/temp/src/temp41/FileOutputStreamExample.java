package temp41;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FileOutputStreamExample {

	//핵심포인트: 파일 copy 프로그램 작성
	public static void main(String[] args) throws IOException {
		String sourceFileName = "C:/Temp/eclipse-inst-jre-win64.exe";
		String targetFileName = "C:/Temp/eclipse-installer.exe";
		
		@Cleanup("close")	//블록에 @Cleanup이 여러 개 있을 때 닫는 순서가 아래->위
		FileInputStream fis = new FileInputStream(sourceFileName);
		log.info("Size of source file: {} bytes", fis.available());
		@Cleanup
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo;
//		byte[] readBytes = new byte[fis.available()];  //바가지 생성
		byte[] readBytes = new byte[100];
		
		int counter = 0;
		while((readByteNo = fis.read(readBytes)) != -1) {	//바가지로 읽어내고
			fos.write(readBytes, 0, readByteNo);			//바가지로 출력([0, readByteNo))
			log.info("\t+counter: {}", ++counter);
		} //while
		
		fos.flush();	//출력버퍼에 잔류가능한 바이트들을 강제로 flush
		
		log.info("File Copy Finished.");
	} //main

} //end class
