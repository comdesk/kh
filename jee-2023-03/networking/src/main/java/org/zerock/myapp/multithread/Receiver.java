package org.zerock.myapp.multithread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Receiver extends Thread {
	
	private Socket sock;

	public Receiver(Socket sock, String name) {
		log.trace("Constructor({}, {}) invoked.", sock, name);
		
		this.sock = sock;
		super.setName(name);
	} //Constructor
	
	@Override
	public void run() {
		log.trace("run() invoked.");
		
		try {
			@Cleanup InputStream is = sock.getInputStream();
			@Cleanup ObjectInputStream ois = new ObjectInputStream(is);
			
			while(true) {	//무한정으로, 클라이언트에서 보내는 메시지(객체) 수신
				Object obj = ois.readObject();
				log.info("\t+ recv: {}", obj);
			} //while
		} catch (Exception e) {
			;;
		} finally {
			if(this.sock != null && !this.sock.isClosed()) {
				try {
					this.sock.close();
				} catch (IOException e) {
					;;
				} //try-catch
			} //if
		} //try-catch-finally
		
		
	} //run

} //end class
