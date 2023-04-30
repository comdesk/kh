package org.zerock.myapp.domain;

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

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CriteriaTests {	//POJO
	
	@BeforeAll
	void beforeAll() {	//1회성 전처리
		log.trace("beforeAll() invoked.");
	} //beforeAll
	
	@AfterAll
	void afterAll() {	//1회성 후처리
		log.trace("afterAll() invoked.");
	} //afterAll
	
	@BeforeEach
	void beforeEach() {
		log.trace("beforeEach() invoked.");
	} //beforeEach
	
	@AfterEach
	void afterEach() {
		log.trace("afterEach() invoked.");
	} //afterEach
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("contextLoads")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void contextLoads() {
		log.trace("contextLoads() invoked.");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(3);
		cri.setAmount(20);
		cri.setPagesPerPage(10);
		
		//검색기능이 추가될 경우에 설정
//		cri.setType("작성자");
//		cri.setKeyword("안녕");
		
		String queryString = cri.getPagingUri();
		log.info("\t+ queryString: {}", queryString);
	} //contextLoads
	
} //end class






