package temp39;

import java.io.FileOutputStream;
import java.io.OutputStream;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WriteExample1 {
	
	//핵심포인트: 파일에 대한 출력스트림을 생성하고, 1바이트씩 출력시킨다.
	public static void main(String[] args) throws Exception {
		//1.바이트기반의 출력스트림 생성
		@Cleanup("close")
		OutputStream os = new FileOutputStream("C:/Temp/TTT.dat");
		
		//2. 문자열 => 바이트 열(바이트 타입의 배열)로 변환
		byte[] data = "김지연".getBytes();	//getBytes 메소드 잘 숙지하기!
		//"ABC"는 String 객체이므로 필드와 메소드 사용 가능.
		
//		======================
//		"Text Block" standardized @since 15
//		다중행 문자열 리터럴 생성방법
							   //옆에 공백문자는 가능하지만 안 넣는 게 좋다.
		String multiLine = """
				1. %s 행		
					2. %s 행
				3. %s 행
				""".formatted("1", "2", "3");
		
		
		System.out.println(multiLine);
		
		for(int i = 0; i < data.length; i++) {	
			os.write(data[i]);		//1바이트씩 파일 출력스트림에 쓰기
		} //for
		
		//*** 출력버퍼에 잔류가능한 바이트들을 모두 강제로 출력스트림에 쓰기 함.
		os.flush();


	} //main

} //end class
