package org.zerock.myapp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {
		//LocalHost: 여러분 자신의 PC/디바이스의 도메인명
		//InetAddress => (1) 호스트명 + (2) 할당된 IPv4 주소
		InetAddress localhost = InetAddress.getLocalHost();	//IP주소: 여러분 PC/device에 할당된 IPv4 주소
															//Loopback 주소를 의미하는 게 아님(***)
		log.info("1. localhost: {}, type: {}", localhost, localhost.getClass().getName());
		
		//위의 localhost변수의 내용을 각각 얻는 것
		String hostAddr = localhost.getHostAddress();
		String hostName = localhost.getHostName();
		
		log.info("2. hostAddr: {}", hostAddr);
		log.info("3. hostName: {}", hostName);
	
//		----
		//도메인명 -> IP주소
		//여기서 말하는 이름(name) => "도메인명"
		//아래의 메소드: 인자로 준 도메인명 -> DNS -> 변환된 IP주소
		InetAddress addr = InetAddress.getByName("naver.com");
		log.info("\t+ 1. addr: {}", addr);
		
		InetAddress[] addrs = InetAddress.getAllByName("naver.com");
		log.info("\t2. addrs: {}", Arrays.toString(addrs) );
		
		//localhost: 여러분 PC/device의 Loopback Address에 대한 특수한 도메인 명
		InetAddress[] myAddrs = InetAddress.getAllByName("localhost");
		log.info("\t3. myAddrs: {}", Arrays.toString(myAddrs) );
		
//		----
		
		
		
		
	} //main

} //end class
