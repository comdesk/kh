package temp36;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashtableExample {
	
	//Hashtable == HashMap + alpha(thread-safe)
	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		@Cleanup
		Scanner scanner = new Scanner(System.in);
		
		while(true) {	//무한루프
			log.info("아이디와 비밀번호를 입력해주세요");
			log.info("아이디: ");
			
			String id = scanner.nextLine();	//blocking IO(입력하기 전까지 멈춰버린다. => 무한루프도 멈춤)
			
			log.info("비밀번호: ");
			
			String password = scanner.nextLine();
			
			//지정된 키가 Map 컬렉션에 존재하는가? map.contatinsKey(key) 메소드
			if(map.containsKey(id)) {
				//Method Chaining
				if(map.get(id).equals(password)) {
					log.info("로그인 되었습니다");
					
					break;	//탈출조건
				} else {
					log.info("비밀번호가 일치하지 않습니다.");
				} //if-else
			} else {
				log.info("입력하신 아이디가 존재하지 않습니다.");
			} //if-else
		} //while

	} //main

} //end class







