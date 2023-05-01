package org.zerock.myapp.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MultiThreadSocketServer {

	private static final int listenPort = 7777;
	
	public static void main(String[] args) throws IOException {
		log.trace("main({}) invoked.", Arrays.toString(args));
		
		//Step.1 지정된 Listen Port로 바인딩하는 ServerSocket 객체 생성
		ServerSocket ss = new ServerSocket(listenPort);
		log.info("\t+ ss: {}", ss);
		
		try(ss) {
			while(true) {	//main스레드 역할: 
							//무한루프: 연결 요청 수신 > 수락 > 새로운 Socket객체 생성
				
				//Step.2 연결 요청을 기다리고 요청이 오면 수신 > 수락 > Socket 객체 생성
				log.info("* Listening on port {} ...", listenPort);
				Socket sock = ss.accept();
				log.info("\t+ sock: {}", sock);
				
				//Step.3 Receiver란 이름의 스레드 역할:
				//		 HandShake Protocol 대로, 클라이언트에서 보내는 객체(메시지)를 수신
				//		 (이 작업은 main 스레드의 역할이 아님.)
				new Receiver(sock, "Receiver").start();
				
				//Step.4 "Sender"란 이름의 스레드 역할:
				//		 HandShake Protocol 대로, 클라이언트로 객체(메시지) 송신
				//		 (이 작업 역시 main 스레드의 역할이 아님)

			} //while
		} finally {
			
		} //try-with-resources

	} //main

} //end class
