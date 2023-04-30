package temp41;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BufferedOutputStreamExample {
	//핵심포인트: Base 출력스트림(OutputStream/Writer)에 성능보조스트림(BufferedOutputStream/BufferedWriter)
	//을 붙이면 성능 대폭 향상
	public static void main(String[] args) throws Exception {
//		FileInputStream fis = null;			//Base 입력스트림
//		FileOutputStream fos = null;		//Base 출력스트림
//		
//		BufferedInputStream bis = null;		//성능보조입력스트림
//		BufferedOutputStream bos = null;	//성능보조출력스트림
		
//		int data = -1;
		long start = 0;
		long end = 0;
//		==========================
		FileInputStream fis = new FileInputStream("C:/Temp/eclipse-installer.exe");	//Base 입력스트림 생성
		BufferedInputStream bis = new BufferedInputStream(fis);	//성능입력보조스트림 연결
		
		//Base 출력스트림 생성
		FileOutputStream fos = new FileOutputStream("C:/Temp/eclispe-installer-copy.exe");	
		
		try(fis; bis; fos;) {
			start = System.currentTimeMillis();
				
				int data = -1;
				while((data = bis.read()) != -1) {
					fos.write(data);
				}	//while
			
			fos.flush();
			
			end = System.currentTimeMillis();
		}	//try-with-resources
//		fos.close(); 	//Base 출력스트림 해제
//		bis.close();  	//성능보조스트림 해제
//		fis.close();	//Base 입력스트림 해제
		
		log.info("사용하지 않을 때: " + (end-start) + "ms");
//		==========================
		FileInputStream fis2 = new FileInputStream("C:/Temp/eclipse-installer.exe");
		BufferedInputStream bis2 = new BufferedInputStream(fis2);
		
		FileOutputStream fos2 = new FileOutputStream("C:/Temp/eclipse-installer-copy2.exe");		
		BufferedOutputStream bos2 = new BufferedOutputStream(fos2);
		
		try(fis2; bis2; fos2; bos2) {
			start = System.currentTimeMillis();
			
			int data2 = -1;
			while((data2 = bis2.read()) != -1) {
				bos2.write(data2);
			}
			
			bos2.flush();
			
			end = System.currentTimeMillis();
		} //try-with-resources
//		bos2.close(); fos2.close(); 	
//		bis2.close(); fis2.close();
		
		log.info("사용할 때: " + (end-start) + "ms");
	} //main
} //end class

