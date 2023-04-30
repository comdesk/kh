package org.zerock.myapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
public class BCryptPasswordEncoderTests {

	@Test
	public void testBcryptPasswordEncoder() {
		
		log.trace("testBcryptPasswordEncoder() invoked.");
		
		String passwd = "Oracle12345678";
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
										  //CharSequence=String
		String cipherText = encoder.encode(passwd);
		
		assertNotNull(cipherText);
		log.info("\t+ cipherText: {}", cipherText);
	} //testBcryptPasswordEncoder
	
	@Test(timeout=1000)
	public void testPasswordMathing() {
		
		log.trace("testPasswordMathing() invoked.");
		
		String passwd = "Af12$%#BG";
		
		//입력한 실제 암호와 데이터베이스에 저장된 해시의 일치여부를 판정하는 방법에 대해서 배우자
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hash1 = encoder.encode(passwd);	//입력 암호에 대한 해시값만 DB에 저장
		log.info("1. hash1: {}", hash1);
		
//		-----------------------
//		입력된 암호의 일치여부 판정
//		-----------------------
		String rawPasswd = passwd;
		
		String hash2 = encoder.encode(passwd);
		log.info("2. hash2: {}", hash2);
		
		boolean isMatched1 = encoder.matches(rawPasswd, hash1);	//rawPasswd: 사용자가 로그인하기 위해 입력한 암호 그대로 / encodedPasswd: 해시값
		log.info("3. isMatched1: {}", isMatched1);
		
		boolean isMatched2 = encoder.matches(rawPasswd, hash2);	//rawPasswd: 사용자가 로그인하기 위해 입력한 암호 그대로 / encodedPasswd: 해시값
		log.info("4. isMatched: {}", isMatched2);
	} //testPasswordMathing
} //end class
















