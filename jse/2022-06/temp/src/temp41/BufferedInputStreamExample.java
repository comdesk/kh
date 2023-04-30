package temp41;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import lombok.Cleanup;

public class BufferedInputStreamExample {
	//핵심포인트: 성능을 대폭 향상시키는 성능보조스트림
	//			  BufferedInputStream / BufferedOutputStream
	//			  즉 입/출력스트림에 버퍼를 생성함으로써 성능을 향상시킴.
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
//		==========================
		@Cleanup
		FileInputStream fis1 = new FileInputStream("C:/Temp/eclipse-installer.exe");
		
		start = System.currentTimeMillis();
		
		while(fis1.read() != -1);
		
		end = System.currentTimeMillis();
		
		System.out.println("버퍼를 사용하지 않았을 때: " + (end-start) + "ms");
//		fis1.close();
		
//		==========================
		@Cleanup
		FileInputStream fis2 = new FileInputStream("C:/Temp/eclipse-installer.exe");
		//성능보조스트림 생성
		@Cleanup
		//입력스트림에는 버퍼가 없는데 버퍼 생성(보완)
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		start = System.currentTimeMillis();
		
		while(bis.read() != -1);
		
		end = System.currentTimeMillis();
		
		System.out.println("버퍼를 사용했을 때: " + (end-start) + "ms");
//		bis.close();
//		fis2.close();
	} //main
} //end class

