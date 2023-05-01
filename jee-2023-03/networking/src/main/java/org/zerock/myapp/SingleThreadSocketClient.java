package org.zerock.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SingleThreadSocketClient {

	public static void main(String[] args) throws IOException{
		log.info("* Client started ...");
		
		//서버의 지정된 Listen Port로 새로운 연결 요청을 생성/전송 => 연결 생성
		//=> 데이터를 주고 받을 수 있는 Socket을 완성한다.

		//Step.1 클라이언트 용 Socket 객체 생성
		@Cleanup
		Socket socket = new Socket();		//연결할 서버의 주소 정보가 없음.
		log.info("1. socket: {}", socket); 	
		
		//Step.2 연결을 요청할 서버의 IP주소 + Listen Port를 가지는 InetSocketAddress 객체 생성
//		String serverIPAddress = "localhost";		//Loopback Address
		String serverIPAddress = "192.168.10.102";	//IPv4 Address
		int serverListenPort = 7777;	
		int timeout = 1000 * 3;		//in milliseconds
		
		InetSocketAddress socketAddr = new InetSocketAddress(serverIPAddress, serverListenPort);
		log.info("2. socketAddr: {}", socketAddr);
		
		//Step.3 지정된 IP주소와 포트번호로 Listen 하고 있는 서버로 연결 요청
//		socket.connect(socketAddr);
		socket.connect(socketAddr, timeout);	//Blocking I/O
		
		log.info("3. socket after connected to the server: {}", socket);
		
		//Step.4 통신규약을 정했습니다. 아래와 같이:
		//(1) 클라이언트가 문자열 메시지 송신(Send)
		//(2) 서버가 문자열 메시지 수신(Receive)하고 콘솔에 출력
		//(3) 서버는 받은 문자열을 다시 클라이언트로 송신(Send)
		//(4) 클라이언트는 받은 문자열을 콘솔에 출력
		
		String message = "Hello From Client.";
		byte[] bytes = message.getBytes("utf8");
		
//		-------------------
		
		OutputStream os = socket.getOutputStream();
		os.write(bytes); os.flush();		//Blocking I/O
		
		log.info(">>> Sent to Server.");
		
//		-------------------
		
		InputStream is = socket.getInputStream();
		
		bytes = new byte[100];
		int readBytes = is.read(bytes);
		
		message = new String(bytes, 0, readBytes, "utf8");		
		log.info("<<< Recv from Server: {}", message);
		
//		--------------
		os.close();
		is.close();
		
	} //main]
} //end class







