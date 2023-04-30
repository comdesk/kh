package temp36;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;


import lombok.extern.log4j.Log4j2;


@Log4j2
public class PropertiesExample {
	
	//리소스 번들 파일을 읽어서 메모리 Map 컬렉션으로 구성해주는
	//Map<K,V> 인터페이스의 구현클래스 중에 properties를 배우자
	public static void main(String[] args) throws IOException {
		//1. Properties Map 객체 생성
		Properties properties = new Properties();	//매개변수 없는 생성자로 생성
		
		//2. Properties Map 객체가 읽을 리소스 번들파일의 경로 획득
		String path = 
				PropertiesExample.
				class.									//Clazz 객체 획득
				getResource("database.properties").		//지정된 리소스 파일을 찾아서 URL 객체로 반환(경로 중간의 다국어들은 인코딩되어 있음)
//				getResource("/database.properties").	//다른 패키지에 리소스 파일이 있을 때
				                                        //'/': 바로 프로젝트 폴더 밑에 있는 src 소스폴더를 의미(다른 소스폴더가 있어도 상관 없음
														//	   사실은 bin폴더(root 폴더)에 있는 파일 실행하므로 bin폴더 의미
//				getResource("/FirstPackage/SecondPackage/database.properties").
				getPath();								//찾아낸 리소스 파일의 절대경로 획득
		
		log.info("0. path: {}", path);
		
		//3. 웹 구현에서 나오는 개념으로, URL Encoding/Decoding 중에
		//	 URL Decoding 수행
		path = URLDecoder.decode(path, "utf-8");	//한글이 정상적으로 표시가 된 경로를 얻을 수 있음.
													//근데 지금은 영어,숫자만 있어서 사실 할 필요가 없음.
		
		//4. 획득한 리소스 번들의 경로를 주어서 Properties Map 컬렉션 생성
		//	 new FileReader(path): 지정된 경로의 파일에 대한 읽기 객체를 생성
		//	 => 이 객체를 이용해서 파일의 내용을 읽음.
		properties.load(new FileReader(path));	//Properties 객체 내부에 파일리더 객체를 필드 안에 컬렉션 형태로 읽어 넣음.
		
		//5. Properties 객체에서 지정된 이름의 설정 정보를 획득/출력
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String name = properties.getProperty("이름");	//\uC774\uB984로 해도 가능
		
		log.info("1. driver: {}", driver);
		log.info("2. url: {}", url);
		log.info("3. username: {}", username);
		log.info("4. password: {}", password);
		log.info("5. name: {}", name);
		
	
	} //main

} //end class








