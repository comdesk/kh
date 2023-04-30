package temp39;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import lombok.Cleanup;

public class WriterExample2 {
	
	//핵심포인트: 문자기반 출력스트림에 문자 출력 시, 양동이를 이용해서 출력
	public static void main(String[] args) throws Exception {
		@Cleanup
		Writer writer = new FileWriter(
				"C:/Temp/TTT.dat", 			//Target to write
				StandardCharsets.UTF_8,		//Charset
				true);
		
		//문자기반의 출력스트림은 문자열을 그대로 출력스트림에 write 해주는 메소드
		//즉 write(String) 메소드가 있다. 때문에 더 이상 "양동이"를 만들어 출력하지 않아도 된다.
		writer.write("""
				안녕하세요
				반갑습니다
				""");	//실제로는 출력버퍼(8KB)에 쓰기 수행
		
		writer.flush();	//출력 버퍼에 잔류 가능한 문자들을 모두 강제로 내보내기

	} //main

} //end class
