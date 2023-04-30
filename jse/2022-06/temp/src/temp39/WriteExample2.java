package temp39;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import lombok.Cleanup;

public class WriteExample2 {
	
	//핵심포인트: 양동이째로 출력스트림에 쓰자
	public static void main(String[] args) throws Exception {
		@Cleanup	//lombok의 자원해제 어노테이션
		OutputStream os = new FileOutputStream("C:/Temp/TTT.dat",true);
		
		byte[] data = "내용2".getBytes("utf-8");	//문자열 => 바이트 배열로 변환
		
		System.out.println(data.length);	//9바이트를 한 번에 보냄
		
		os.write(data);	//출력버퍼에 쓰자? 출력버퍼?
		os.flush();	//출력버퍼를 강제로 비우기(출력버퍼에 강제로 쓰기)

	} //main

} //end class





