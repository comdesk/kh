package org.zerock.myapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestUUIDGenerators {	//POJO
	
//	@BeforeAll
//	void beforeAll() {	//1회성 전처리
//		log.trace("beforeAll() invoked.");
//	} //beforeAll
//	@BeforeEach
//	void beforeEach() { //매 테스트 케이스마다 수행하는 전처리
//		log.trace("beforeEach() invoked.");
//	} //beforeEach
	
//	@AfterAll
//	void afterAll() {	//1회성 전처리
//		log.trace("afterAll() invoked.");
//	} //afterAll
//	@AfterEach
//	void afterEach() {	//매 테스트 케이스마다 수행하는 전처리
//		log.trace("afterEach() invoked.");
//	} //afterEach
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: Type1 UUID 생성")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void type1UUID() {
		log.trace("type1UUID() invoked.");
		
		UUID uuid = UUIDGenerator.generateType1UUID();
		log.info("\t+uuid: {}", uuid);
		log.info("\t+ version: {}", uuid.version());
	} //type1UUID

//	@Disabled
	@Test
	@Order(2)
	@DisplayName("테스트2: Type3 UUID 생성")
	@Timeout(value=500, unit=TimeUnit.MILLISECONDS)
	void type3UUID() throws UnsupportedEncodingException {
		log.trace("type3UUID() invoked.");
		
		//Type3 UUID는 이름공간(namespace)과 이 공간 안에 있는 특정 이름(name) 기반으로
		//UUID를 생성하는 방법
		
		//규칙1: 임의의 문자열인 namespace의 길이는 반드시 32 문자길이여야 함.(***)
		String namespace = "01234567890123456789012345678901";
		assert namespace.length() == 32;
		
		String name = "Yoseph";
		
		UUID uuid = UUIDGenerator.generateType3UUID(namespace, name);
		log.info("\t+uuid: {}", uuid);
		log.info("\t+ version: {}", uuid.version());
	} //type3UUID
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("테스트3: Type4 UUID 생성")
	@Timeout(value=500, unit=TimeUnit.MILLISECONDS)
	void type4UUID() throws UnsupportedEncodingException {
		log.trace("type4UUID() invoked.");
		
		UUID uuid = UUIDGenerator.generateType4UUID();
		
		assertNotNull(uuid);
		
		log.info("\t+uuid: {}", uuid);
		log.info("\t+ version: {}", uuid.version());
	} //type4UUID
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("테스트4: Type5 UUID 생성")
	@Timeout(value=500, unit=TimeUnit.MILLISECONDS)
	void type5UUID() throws UnsupportedEncodingException {
		log.trace("type4UUID() invoked.");
		
		//Type5 UUID는 이름공간(namespace)과 이 공간 안에 있는 특정 이름(name) 기반으로
		//UUID를 생성하는 방법
		
		//규칙1: 임의의 문자열인 namespace의 길이는 반드시 32 문자길이여야 함.(***)
		String namespace = "01234567890123456789012345678901";
		assert namespace.length() == 32;
		String name = "Yoseph";
		
		UUID uuid = UUIDGenerator.generateType5UUID(namespace, name);
		
		assertNotNull(uuid);			//if null, throw Some Exception
//		assert uuid != null;			//if false, throw 'AssertionError'
//		Objects.requireNonNull(uuid);	//if null, throw 'NullPointerException'
		
		log.info("\t+uuid: {}", uuid);
		log.info("\t+ version: {}", uuid.version());
	} //type5UUID
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("테스트5: UUID와 Message Digest(메시지축약) 알고리즘을 이용한 Unique Key 생성")
	@Timeout(value=200, unit=TimeUnit.MILLISECONDS)
	void UUIDAndMessageDigest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		log.trace("UUIDAndMessageDigest() invoked.");
		
		String uuid = UUIDGenerator.generateUniqueKeysWithUUIDAndMessageDigest();
		
		Objects.requireNonNull(uuid);
		
		log.info("\t+uuid: {}", uuid);
	} //UUIDAndMessageDigest
} //end class















