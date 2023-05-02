package org.zerock.myapp.multithread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ChatServer {

	//지속적으로 연결된 클라이언트를 보관할 자료구조
	private static Map<String, Socket> clients;	//Map<K, V> = Map<UniqueKey, Socket>
	private static final int listenPort = 7777;
	
	//Thread-Unsafe한 Map 컬렉션 => Thread-Safe 한 컬렉션으로 변경
	static {
		clients = new HashMap<>();	//Thread-unsafe: 다중 스레드 환경에서 조작이 보장 안 됨.
		clients = Collections.synchronizedMap(clients);	//Thread-Safe
	} //static initializer
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(listenPort);
		log.info("1. Listening on port {} ...", listenPort);
		
		try(ss) {	//(1) main thread: 서버 고유의 역할만 수행
			while(true) {
				Socket sock = ss.accept();	//새로운 클라이언트 연결됨
				log.info("\t+ New Client Connected...addr: {}", sock.getRemoteSocketAddress());
				
				MessageBroker broker = new MessageBroker(sock);
				broker.start();
			} //while			
		} //try-with-resources
	} //main
	
	//연결된 클라이언트 당 하나씩 생성/수행되는 스레드
	@Log4j2
	static class MessageBroker extends Thread{	//static멤버인 main에서 쓸 거니까 static class
		private final Socket sock;
		private final String clientkey;
		
		//(1) 새롭게 연결된 클라이언트 소켓과 이 소켓으로 얻어낸 고유한 키를 가지고
		//(2) clients Map 컬렉션 업데이트(Append)
		public MessageBroker(Socket sock) {
			//생성자에게 예외가 발생하면, New 연산자가 생성한 객체는 자동으로 파괴된다.
		
			this.sock = sock;
			
			this.clientkey = Integer.toHexString(sock.hashCode());
			log.info("\t+ New client key: {}", this.clientkey);
			
			super.setName("MessageBroker_" + clientkey);			
			
			//clients Map Collection Update (Append)
			clients.put(clientkey, sock);	
			log.info("\t+ clients: {}", clients);
		} //Constructor
		
		//메시지 브로커(중개자) 역할:
		//(1) 현재 연결된 모든 클라이언트가 보내는 메시지를 수신
		//(2) 수신된 메시지를 메시지를 보낸 클라이언트를 제외한, 그 나머지 아직 연결을 유지하고 있는
		//	  모든 클라이언트에게 다시 메시지를 Broadcasting 해야 함.
		@Override
		public void run() {	//Worker Thread의 Entry Point
			try {
				@Cleanup InputStream is = this.sock.getInputStream();
				@Cleanup ObjectInputStream ois = new ObjectInputStream(is); 
				
				while(true) {
					//(1)Receive 
					Object message = ois.readObject();
					log.info("ClientKey: {}, Message: {}", clientkey, message);
					
					//(2) Broadcasting (= Subscribing)
					clients.forEach((k, s) -> {
						if(!k.equals(clientkey)) {	//나머지 구독자에게 방송
							//방송 중에 이미 끊긴 Socket이나, 오류가 발생하는 Socket은 Clients Map 컬렉션에서
							//제거해줘야 하고, 특정 Socket의 오류로 인해서 방송이 중단되는 일은 없어야 한다.
							try {
								ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
								oos.writeObject(message); oos.flush();
								
								log.info("\t+ Sent to client({}), oos: {}", k, s.isOutputShutdown());
							} catch (Exception e) {;;}
							
						} //if
					});
				} //while
			} catch(Exception e) {
				;;
			} //try-catch
		} //run
		
	} //end class
} //end class












