package org.zerock.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class URLExample {

	//URL 객체의 의미와 용법에 대해서 알자!
	public static void main(String[] args) throws IOException {
		
		String urlString = "https://www.google.co.kr/";
		
		URL url = new URL(urlString);
		log.info("1. url: {}, type: {}", url, url.getClass().getName());
		
//		=== URL 객체를 통해서, 지정된 주소에 대한 다양한 정보를 획득 가능 ===
		log.info("\t+getAuthority : {}", url.getAuthority());
		log.info("\t+getProtocol : {}", url.getProtocol());
		log.info("\t+getHost : {}", url.getHost());
		log.info("\t+getPort : {}", url.getPort());
		log.info("\t+getDefaultPort : {}", url.getDefaultPort());
		log.info("\t+getFile : {}", url.getFile());
		log.info("\t+getPath : {}", url.getPath());
		log.info("\t+getQuery : {}", url.getQuery());
		log.info("\t+getRef : {}", url.getRef());
		log.info("\t+getUserInfo : {}", url.getUserInfo());
		log.info("\t+getContent : {}", url.getContent());	//IOException
		
//		--- URL.getContent 메소드가 반환한 바이트 기반의 입력스트림을 통해, 
//			지정된 URL의 응답데이터(정확히는 HTTP response 메시지)를 읽어서 출력해보자
//		-- 이는 마치, 아래의 명령의 결과를 얻는 것과 같다:
//		   $ curl "https://www.google.co.kr/"
		
		//브라우저 주소창에 주소 치면 오는 응답메시지를 받아내는 것
		
		@Cleanup InputStream is = (InputStream) url.getContent();
		@Cleanup BufferedReader br = new BufferedReader(new InputStreamReader(is));	//브라우저는 다 문자로 응답 주므로(??)

//		String line = null;
//		while((line = br.readLine()) != null) {	//EOF(null)
//			System.out.println(line);
//		} //while
		
		//다음의 기능이 URL 객체에서 가장 중요하지 않을까 싶습니다.
		URLConnection urlConn = url.openConnection();	//*****: 우리가 공공데이터 포털연계 시 사용
		log.info("1. conn: {}", urlConn);
		log.info("2. type: {}", urlConn.getClass().getName());
		
		HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
		HttpsURLConnection httpsUrlConn = (HttpsURLConnection) urlConn;
	} //main

} //end class











