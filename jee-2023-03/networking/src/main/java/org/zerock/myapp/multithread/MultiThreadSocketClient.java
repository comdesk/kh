package org.zerock.myapp.multithread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MultiThreadSocketClient {

	private static final String serverAddress = "localhost";
	private static final int serverPort = 7777;
	private static final int connectTimeout = 1000 * 1;
	
	public static void main(String[] args) throws IOException {
		log.trace("main({}) invoked.", Arrays.toString(args));
		
		//Step.1 Socket 객체 생성하고, 서버로 연결시도
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(serverAddress, serverPort), connectTimeout);
		log.info("\t1. socket: {}", socket);
		
		//Step.2 서버로 메시지(객체)를 보내는 역할을 하는 스레드 생성/시작
		new Sender(socket, "Sender").start();
		
	} //main
} //end class
