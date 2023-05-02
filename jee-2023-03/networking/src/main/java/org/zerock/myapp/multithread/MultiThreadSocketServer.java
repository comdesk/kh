package org.zerock.myapp.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MultiThreadSocketServer {

	private static final int listenPort = 7777;
	private static int countCilents = 1;
	
	public static void main(String[] args) throws IOException {
		log.trace("main({}) invoked.", Arrays.toString(args));
		
		//Step.1 지정된 Listen Port로 바인딩하는 ServerSocket 객체 생성
		ServerSocket ss = new ServerSocket(listenPort);
		log.info("* Listening on port {} ...", listenPort);
		
		try(ss) {
			while(true) {	//main스레드 역할: 
							//무한루프: 연결 요청 수신 > 수락 > 새로운 Socket객체 생성
				
				//Step.2 연결 요청을 기다리고 요청이 오면 수신 > 수락 > Socket 객체 생성
				Socket socket = ss.accept();
				log.info("\t+ Connection Request Accepted. socket: {}", socket.getRemoteSocketAddress());	//소켓을 만드는 건 서버니까 여기서 로그 찍어줌.
				
				//Step.3 Receiver란 이름의 스레드(Worker Thread) 역할:
				//		 HandShake Protocol 대로, 클라이언트에서 보내는 객체(메시지)를 수신
				//		 (이 작업은 main 스레드의 역할이 아님.)
				( new Receiver(socket, "ServerReceiver_" + countCilents++) ).start();	//새로운 Worker 스레드 생성 및 시작
				//클라이언트 하나당 리시버 스레드가 한 번씩 생성됨.
				//클라이언트마다 대응되는 스레드 생성 (10개의 클라이언트 -> 10개의 리시버 스레드)
				
				//Step.4 "Sender"란 이름의 스레드 역할:
				//		 HandShake Protocol 대로, 클라이언트로 객체(메시지) 송신
				//		 (이 작업 역시 main 스레드의 역할이 아님)
				( new Sender(socket, "ServerSender_" + countCilents++) ).start();
				
			} //while
		} //try-with-resources

	} //main

} //end class
