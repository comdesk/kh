package FirstPackage.SecondPackage;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashtableExample {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		@Cleanup
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			log.info("아이디와 비밀번호를 입력해주세요.");
			log.info("아이디: ");
			
			String id = scanner.nextLine();
			
			log.info("비밀번호: ");
			
			String password = scanner.nextLine();
			
			if(map.containsKey(id) && map.get(id).equals(password)) {
				log.info("로그인 되었습니다.");
				
				break;
			} else {
				log.info("아이디 또는 비밀번호가 일치하지 않습니다.");
			} //if-else
		} //while

	} //main

} //end class







