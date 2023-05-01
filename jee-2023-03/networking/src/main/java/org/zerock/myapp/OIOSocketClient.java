package org.zerock.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.zerock.myapp.domain.Member;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class OIOSocketClient {

	public static void main(String[] args ) throws IOException, ClassNotFoundException {
		//Step.1 전송할 Member 객체를 생성
		Member member = new Member();
		member.setId(1);
		member.setName("Yoseph");
		member.setAge(23);
		log.info("\t1. member: {}", member);
		
		//Step.2 Socket 객체로 Server에 연결 시도 => if 성공 => Connection 생성
		int serverListenPort = 7777;
		int connectTimeout = 1000 * 3; //in milliseconds
		
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress("0.0.0.0", serverListenPort), connectTimeout);
		SocketAddress serverAddress = socket.getRemoteSocketAddress();	//연결된 서버의 주소/포트정보 획득
		log.info("\t2. serverSockAddr: {}", serverAddress);
		
		
		try(socket) {
			//Step.3 Member 객체를 서버로 전송
			@Cleanup OutputStream os = socket.getOutputStream();
			@Cleanup ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject(member); oos.flush();
			log.info("\t3. Sent a member to server");
		
//			----
			
//			Step.4 서버에서 수정한 member 객체를 수신하여 콘솔에 출력
			@Cleanup InputStream is = socket.getInputStream();
			@Cleanup ObjectInputStream ois = new ObjectInputStream(is);
			
			Object obj = ois.readObject();
			Member recvMember = (Member) obj;
			log.info("\t4. Recv member: {}", recvMember);
		
		} //try-with-resources
	} //main
} //end class




















