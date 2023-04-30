package temp40;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class FileExample {
	
	//핵심포인트: 파일시스템의 폴더와 파일을 모델링해서 만든 클래스가 바로 File 클래스
	//			  파일시스템에 대한 조작에 필요한 대부분의 API가 이 File 객체를 매개변수로
	//			  요구하는 경우가 상당히 많다.
	public static void main(String[] args) throws Exception {
		//1. File 객체 생성 - 이때 생성자에 지정한 경로가 실제 존재하지 않아도 상관없음
		File dir = new File("C:/Temp/Dir");				//폴더경로 지정
		File file1 = new File("C:/Temp/file1.txt");		//파일경로 지정
		File file2 = new File("C:/Temp/file2.txt");		//파일경로 지정
		
		//URI객체와 URI 표현방식으로 경로를 지정해도 된다.
		//즉 생성자의 매개변수 타입의 URI인 생성자도 있다만 잘 안 쓴다
		//왜냐하면 위와 같이 간단한게 있는데 일부러 아래처럼 어렵게 경로를 지정할 필요 x
		File file3 = new File(new URI("file:///C:/Temp/file3.txt"));	//file:///: URL의 규격 표준(내 pc 안에 있는 자원 위치 지정. http://와 비슷)
		
		log.info("1. dir: {}", dir);
		log.info("2. file2: {}", file2);
		log.info("3. file3: {}", file3);
//		========================
		
		//File.exists(): File 객체가 가리키고 있는 경로가 존재하는지 여부를 boolean값으로 반환
		if(dir.exists() == false) {
			//C:/Temp/Dir
			dir.mkdirs();	//파일 객체의 경로대로 모든 폴더를 만들어 주는 메소드(전체 경로에 없는 건 다 만듦)
		}
		if(file1.exists() == false) { 
			//C:/Temp/file1.txt
			file1.createNewFile(); 
		}
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }
		
//		=========================
		
		File temp = new File("C:/Temp");
		
		//SimpleDateFormat 클래스: 개발자가 원하는 형식(포맷)으로 날짜와 시간정보를 문자열로
		//						   만들어내는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a  HH:mm:");
		
		//File.listFiles() : 지정된 경로 밑에 존재하는 모든 파일 목록을 획득
		File[] contents = temp.listFiles();
		
		System.out.println("  날짜          시간             형태          크기       이름");
		System.out.println("------------------------------------------------------------------");
		
		for(File file : contents) {
			//File.lastModified(): 지정된 경로의 파일의 최종 수정 시간 획득
			//Date 클래스: 날짜와 시간 정보를 관리하는 클래스
			System.out.print(sdf.format(new Date(file.lastModified())));
			
			//File.isDirectory(): 지정된 경로가 디렉토리인지 파일인지 알려줌.
			if(file.isDirectory()) {
				//Fiile.getName(): 지정된 경로의 이름 획득
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				//File.length(): 지정된 경로의 크기(길이) 획득
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			} //if-else
			
			System.out.println();
		} //enhanced for
	} //main

} //end class









