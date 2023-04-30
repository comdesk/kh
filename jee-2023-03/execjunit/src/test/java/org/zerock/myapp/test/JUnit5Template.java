package org.zerock.myapp.test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

@NoArgsConstructor	//(3) 매개변수 없는 기본 생성자를 가져야 함.
@Log4j2

//(2)테스트 클래스 하나당, 인스턴스 하나를 생성해서, 테스트 수행(Lifecycle.PER_CLASS)(싱글톤처럼) (***)
//	 OR 테스트 메소드 하나당, 인스턴스 하나 생성해서 테스트 수행(Lifecycle.PER_METHOD)
@TestInstance(Lifecycle.PER_CLASS)
//(4) 단위 테스트 메소드의 수행순서를 @Order(수행번호) 어노테이션 방식으로 정하겠음.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5Template {	//(1)POJO
	
	//(5) 전처리
	@BeforeAll		//1회성
	void beforeAll() {
		log.trace("beforeAll() invoked.");
	} //beforeAll
	@BeforeEach		//매 단위 테스트 케이스 마다 수행
	void beforeEach() {
		log.trace("beforeEach() invoked.");
	} //beforeEach
	//(6) 후처리
	@AfterAll		//1회성
	void afterAll() {
		log.trace("afterAll() invoked.");
	} //afterAll
	@AfterEach		//매 단위 테스트 케이스 마다 수행
	void afterEach() {
		log.trace("afterEach() invoked.");
	} //afterEach
	
	//(7) 각 단위 테스트 케이스 메소드마다 아래의 어노테이션들을 붙일 수 있음.
	//	  가. 단위 테스트 수행 순서를 결정
	//	  나. 단위 테스트의 만료 시간(timeout) 설정
	//	  다. JUnit View 같은 개발도구에 표시될 단위 테스트 이름을 스스로 결정
	//(8) 더 이상 테스트 케이스 메소드에 'test~'란 접두사는 필요 없음.(맘대로 선언)
//	@Disabled	// (9) 현재의 테스트 케이스 메소드를 수행시키지 않겠다(무력화)
	@Test		//(10) 현재의 메소드가 테스트 메소드임을 알려줌
	@Order(1)	//(11) 테스트의 순서를 결정
	@DisplayName("단위테스트 1: Oracle Cloud ATP로의 연결테스트 수행")	//(12) 개발도구에 표시될 이름을 결정
	@Timeout(value=1, unit=TimeUnit.SECONDS)	//(13) 테스트 타임아웃을 결정
	void contextLoads() {
		log.trace("contextLoads() invoked.");
	} //contextLoads
} //end class














