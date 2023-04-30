package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import org.zerock.myapp.service.*;

@NoArgsConstructor
@Log4j2

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/**/root-*.xml"
})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogAdivceServiceTests {

	@Setter(onMethod_= @Autowired)
	private SampleService service;
	
	@BeforeAll
	void beforeAll() {		//일회성 전처리
		log.trace("beforeAll() invoked.");
		
		assertNotNull(this.service);
		log.info("\t+ this.service: {}", this.service);
		log.info("\t+ type: {}", this.service.getClass().getName());
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("testPlus")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testBeforeAdvice() throws Exception {
		log.trace("testPlus() invoked.");
		
		Integer result = this.service.plus("100", "200");
		log.info("\t+result: {}", result);
	}  //testPlus
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testAfterReturningAdvice")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testAfterReturningAdvice() throws Exception {
		log.trace("testAfterReturningAdvice() invoked.");
		
		Integer result = this.service.plus("100", "200");
		log.info("\t+result: {}", result);
	}  //testAfterReturningAdvice
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testAfterThrowingAdvice")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testAfterThrowingAdvice() throws Exception {
		log.trace("testAfterThrowingAdvice() invoked.");
		
		Integer result = this.service.plus("삼백", "200");	//예외 발생
		log.info("\t+result: {}", result);
	}  //testAfterThrowingAdvice
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("testAfterAdvice")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testAfterAdvice() throws Exception {
		log.trace("testAfterAdvice() invoked.");
		
//		Integer result = this.service.plus("100", "200");	//정상처리
		Integer result = this.service.plus("백", "200");	//예외 발생
		log.info("\t+result: {}", result);
	}  //testAfterAdvice
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("testAroundAdvice")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testAroundAdvice() throws Exception {
		log.trace("testAfterAdvice() invoked.");
		
		Integer result = this.service.plus("100", "200");	//정상처리
		log.info("\t+result: {}", result);
	}  //testAroundAdvice
} //end class












