package org.zerock.myapp.httpclient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HttpURLConnectionTests {	//POJO

	//이미 URL Encoding 되어 있는 서비스 키
	private String serviceKey = "za%2FI4esx8hY%2F2ai3R759VtWOcO05iDsE%2FKbg9YkvCliD84cTEvJGnFUWgOxzA2nuAnLJc3dD5EMP1fU0uWsIdA%3D%3D";
	
	//URL Encoding 되어 있지 않은 서비스 키
	private String originalServiceKey = "za/I4esx8hY/2ai3R759VtWOcO05iDsE/Kbg9YkvCliD84cTEvJGnFUWgOxzA2nuAnLJc3dD5EMP1fU0uWsIdA==";
	private String endPoint = "https://apis.data.go.kr/1360000/AwsYearlyInfoService/getStnbyMmSumry";
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: 기상청 방재기상연보 조회서비스 OpenAPI 테스트")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testOpenAPI() throws IOException {
		log.trace("testOpenAPI() invoked.");
		
		//java.net.HttpURLConnection 용법에 대해서 알자
		
		//이 클래스는 웹브라우저와 동일하게 웹클라이언트의 기능을 수행할 수 있다.
		//하지만, 웹브라우저가 POST방식 전송은 안 되듯이, 이 클래스 또한 POST방식은 지원하지 않는다.
		//다른 말로 하면, GET 방식만 지원한다.
		
		//Step.0 OpenAPI 서버로 전송할 전송파라미터로 구성된 "쿼리스트링(Query String)" 생성
		//		 개별 전송파라미터의 값은 반드시 URL Encoding을 수행해야 한다 => How? URLEncoder.encode() 메소드 사용 (***)
		String queryString = 
				String.format("?serviceKey=%s&pageNO=%s&numOfRows=%s&dataType=%s&year=%s&month=%s&station=%s", 
						URLEncoder.encode(originalServiceKey, "UTF-8"), 
						URLEncoder.encode("1", "UTF-8"),
						URLEncoder.encode("10", "UTF-8"), 
						URLEncoder.encode("JSON", "UTF-8"),
						URLEncoder.encode("2017", "UTF-8"), 
						URLEncoder.encode("09", "UTF-8"),
						URLEncoder.encode("96", "UTF-8")
				);
		log.info("0. queryString: {}", queryString);
		
		//Step.1 웹브라우저가 접속할 URL 주소와 같이, 
		//우리가 접속 요청할 OpenAPI의 서비스 URL을 "생성"
		URL url = new URL(endPoint+ queryString);
		assertNotNull(url);
		log.info("1. url: {}", url);
		
		//Step.2 실제 준비된 URL로 HTTP 통신 규약에 따라 접속 시도할 연결객체를 준비 
//		URLConnection conn = url.openConnection();
		@Cleanup("disconnect")
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		Objects.requireNonNull(conn);
		log.info("2. conn: {}", conn);
		log.info("3. type: {}", conn.getClass().getName());
		
		//Step.3 진짜 연결시도하기 전에, 연결 설정부터 하고...
		conn.setConnectTimeout(5000); //milliseconds
		conn.setUseCaches(false); //캐시 사용하지 말라! => 매번 실제 접속하라(기본값: true => 최초 접속하고 캐시를 쓰고 다시 접속 안 함.)
		conn.setDoInput(true);		//HTTP response 메시지는, 우리가 직접 InputStream을 열어서 읽어내기로 함. 요청을 보낼 때, 응답을 받을 때를 고려한 자바 입출력 스트림의 사용 여부를 결정
		conn.setDoOutput(false);		//HTTP request 메시지는 기본 구현에 맡김.
		conn.setRequestMethod("GET"); //HTTP method 설정
		conn.setReadTimeout(3000);		//지정된 밀리초 시간 내에, HTTP response의 BODY(JSON이 들어있음)를 읽어낼 수 있어야 한다는 의미
		

		
		//Step.4 진짜 연결시도(물론, 전송파라미터도 보내고...)
		conn.connect();			//연결시도
		
		log.info("2. conn: {}", conn);
		log.info("3. type: {}", conn.getClass().getName());
		
		//Step.5 응답 메시지의 기본 정보 확인(HTTP status code / message)
		int statusCode = conn.getResponseCode();
		String responseMessage = conn.getResponseMessage();
		log.info("4. statusCode: {}", statusCode);
		log.info("5. responseMsg: {}", responseMessage);	//200 OK일 때, 응답 바디에 있는 거 끄집어내면 됨.
		
		//------------------------------------------------------------//
		//Step.6 HTTP response의 body에 있는 데이터(JSON)를 읽어냄.(conn.setDoInput(true)) 읽어내려면 인풋스트림 얻어야 함.
		//정상 처리 응답(200, OK)으로 왔을 때에, JSON 읽어낸다.
		if(statusCode == 200) {	
			@Cleanup
			InputStream is = conn.getInputStream();	//if conn.setDoInput(true)..
			
			//만약에 응답데이터에 한글 같은 다국어 문자가 하나도 없다면,
			//아래와 같이 하면 된다만..
	//		@Cleanup
	//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//만약에 응답데이터에 한글 같은 다국어 문자가 포함되어 있다면,
			//다국어 지원을 위해서, InputStream -> Reader 로 변환 시, Reader가 사용할
			//문자집합(Charset)을 지정해주는 것이 좋다. (즉, 무조건 UTF-8로 지정할 것)
	//		@Cleanup     //3rd. method
	//		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));	//UTF-8(정석), UTF8, utf-8, utf8
			
	//		Charset charset = StandardCharsets.UTF_8;	//1st. method
			Charset charset = Charset.forName("UTF-8");	//2nd. method
			@Cleanup
			BufferedReader br = new BufferedReader(new InputStreamReader(is, charset));	//Charset 객체로 지정
			
			String line = null;
			while((line = br.readLine()) != null) {	//if null, it means "EOF"
				System.out.println(line);
				
			} //while
		} //if
		
//		conn.disconnect();		//연결해제
		
	} //testOpenAPI
	
} //end class














