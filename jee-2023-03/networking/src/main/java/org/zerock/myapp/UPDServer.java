package org.zerock.myapp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Objects;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UPDServer {

	//DatagramPacket 수신할 임무:
	//지금 예제는, UDP 서버가 UDPClient로부터 오는 패킷들을 계속 수신만 함.
	//수신한 패킷으로부터 얻어낸 데이터(문자열)를 콘솔에 계속 출력
	public static void main(String[] args) throws IOException {	//예외를 위로 던진다는 건 예외가 나면 소켓을 못 닫을 수도 있단 의미.
		int listenPort = 5001;
		DatagramSocket sock = new DatagramSocket(listenPort);	//포트번호만 지정하면 ip주소는 수신자가 구동중인 pc의 모든 ip주소
		log.info("1. sock: {}", sock);
		
		try {
			log.info("2. Waiting receiving from port {} ...", listenPort);
			
			while(true) {	//무한루프 - 언제 올지 모르고, 몇 번이나 패킷이 올지 모르니... 
				//만일에 패킷이 송신자(sender)로부터 들어온다면, 이 패킷을 받을 준비를 해야 됨.
				DatagramPacket packet = new DatagramPacket(new byte[100], 100);
				sock.receive(packet); 		//Blocking I/O
				
				String recvMessage = new String(packet.getData(), 0, packet.getLength());
				log.info("\t+ recvMessage: {}", recvMessage);
			} //while
		} catch(IOException e) {
			log.info("3. Finished receiving ...");
			throw e;
		} finally {
			Objects.requireNonNull(sock);
			if(!sock.isClosed())  {
				sock.close();
				log.info("4. Socket closed.");
			} //if
			
		} //try-catch-finally
		
	} //main

} //end class






