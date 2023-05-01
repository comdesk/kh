package org.zerock.myapp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Objects;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UDPClient {

	//UDP Networking에서 메시지 송신자의 역할, 송신하기만 함. (수신은 반대로 없다)
	public static void main(String[] args) throws IOException {
		//송신자 입장에서 아래의 DatagramSocket은 단지 생성된 DatagramPacket을 인터넷에 그냥 던지는 역할
		//밖에는 안 한다.
		DatagramSocket sock = new DatagramSocket();
		try {
			for(int i = 1; i <= 10; i++) {	//10번 패킷 생성 및 전송 (이 패킷이 편지 봉투의 역할)
				//때문에 이 DatagramPacket에 "보내는 사람 주소/포트, 받는 사람 주소/포트" 기재해야 한다.
				String message = "MESSAGE_" + i;
				byte[] bytes = message.getBytes("utf8");
				
				//이 패킷에 보내는 사람/받는 사람 주소/포트 기재하고, 편지봉투 안에는 실제 메시지 넣어야함.
				DatagramPacket packet = new DatagramPacket(
							bytes, bytes.length,
							//받는 사람(수신자) 주소만 기재
							//보내는 사람(송신자) 주소는 자동으로 결정/기재
							new InetSocketAddress("localhost", 5001)
							//보낸 사람 주소는 자동으로 기재됨. 이건 운영체제가 결정하는 거라.
						);
				log.info("\t+ packet: {}", packet);
				
				//인터넷으로 패킷을 던져버림(어떻게 갈지, 언제 도착할지 모름)
				sock.send(packet);
			} //for
		} finally {
			Objects.requireNonNull(sock);
			if(!sock.isClosed()) {
				sock.close();
			} //if
		} //try-finally
		
		

//		sock.close();
	} //main

} //end class






