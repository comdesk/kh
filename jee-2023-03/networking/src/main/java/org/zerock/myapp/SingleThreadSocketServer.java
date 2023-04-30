package org.zerock.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SingleThreadSocketServer {

	//FOCUS: TCP Networking 기반의 서버 프로그램 제작
	//		 개발 시 핵심은, 현재 단계에서는 지정된 Listen Port로 연결 요청을 기다리다가(Listening)
	//		 (1) 클라이언트의 연결요청이 들어오면 => 수락 => 연결 생성(Connection) 하고,
	//		 (2) 통신을 위한 Socket 객체 생성
	//		 까지가 이번 예제의 목표
	public static void main(String[] args) throws IOException {
		
		// Step.1 ServerSocket 객체의 생성은, Listen Port를 인자값으로 줘서 생성
		int listenPort = 7777;
		
		@Cleanup
//		ServerSocket serverSocket = new ServerSocket(listenPort);		//Default backlog = 50
		ServerSocket serverSocket = new ServerSocket(listenPort, 100);	//Custom backlog = 100
		log.info("1. serverSocket: {}", serverSocket);
		
		//Step.2 무한루프를 이용해서, 언제 들어올지 모르는 클라이언트로부터의 연결요청을
		//		 Listening(대기)하게 한다.
		while(true) {	//무한루프
			log.info("========================");
			log.info("2. Start Listening...");
			log.info("========================");
			
			//지정된 Listen Port로 Listening 수행, 
			//(*주의: 연결요청이 들어오기 전까지, 아래의 accept()메소드는 실행을 멈춤(blocking))
			//즉, 현재의 실행 스레드가 suspended (대기) 상태가 되다가, 연결요청이 들어오면,
			//자동으로 깨어남.(ready -> run 상태가 됨)
			
			//Step.3 만일 연결요청이 클라이언트로부터 들어오면 연결 수락
			//		 연결생성(Connection)하고, 통신을 위한 Socket 객체 생성
			@Cleanup Socket socket = serverSocket.accept();
			
			log.info("3. Accept connection request ...");			
			log.info("4. socket: {}", socket);
			
			//Step.4 통신규약대로, 우선 메시지를 수신한다.
			InputStream is = socket.getInputStream();
			
			byte[] bytes = new byte[100];
			int readBytes = is.read(bytes);
			String message = new String(bytes, 0, readBytes, "utf8");
			log.info("<<< Recv from Sever: {}", message);
			
//			--------------
			OutputStream os = socket.getOutputStream();
			os.write(bytes); os.flush();
			log.info(">>> Sent to Server.");
			
//			--------------
			is.close();
			os.close();
		} //while
		
		
	} //main
} //end class






