package org.zerock.myapp.multithread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.zerock.myapp.domain.Member;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Sender extends Thread {

	private Socket sock;
	
	public Sender(Socket sock, String name) {
		log.trace("Constructor({}, {}) invoked.", sock, name);
		
		this.sock = sock;
		super.setName(name);
	} //constructor

	@Override
	public void run() {
		log.trace("run() invoked.");
		
		try {
			//Step.1 객체의 직렬화를 통해, Member 객체를 송신할 준비
			@Cleanup OutputStream os = sock.getOutputStream();
			@Cleanup ObjectOutputStream oos = new ObjectOutputStream(os);
			
			//Step.2 송신할 Member 객체 생성
			Member m = new Member();
			m.setId(1);
			m.setName("Yoseph");
			m.setNickName("- PYRAMIDE");
			m.setMessage("Hello from Clinet");
			log.info("\t+ m: {}", m);
			
			//Step.3 생성한 Member 객체를 객체의 직렬화를 통해 서버로 전송
			oos.writeObject(m); oos.flush();
			
			log.info("Done.");			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(this.sock != null && !this.sock.isClosed()) {
				try { this.sock.close(); } 
				catch (IOException e) { ;; }
			}
		} //try-catch-finally
		
	} //run
	
	
} //end class
