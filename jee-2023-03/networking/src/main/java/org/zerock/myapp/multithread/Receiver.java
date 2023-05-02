package org.zerock.myapp.multithread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


//목적: 연결된 각 클라이언트마다 생성/시작되는 "수신전용" 스레드
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
			@Cleanup InputStream is = this.sock.getInputStream();
			@Cleanup ObjectInputStream ois = new ObjectInputStream(is);
			
			while(true) {	//무한정으로, 클라이언트에서 보내는 메시지(객체) 수신
				//입력스트림으로부터 더이상 읽을 객체가 없을 시에(EOF)는, EOFException 예외발생
				Object obj = ois.readObject();	//Blocking
				log.info("\t+ recv: {}", obj);
			} //while
		} catch (Exception e) {	//예외처리: run() 메소드 밖으로 예외가 나가지 못하게 막는 역할
//			e.printStackTrace();	//EOFException이 찍힐 뿐이라 찍어봤자 소용 없음.
		} finally {	//Socket 자원 해제
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
