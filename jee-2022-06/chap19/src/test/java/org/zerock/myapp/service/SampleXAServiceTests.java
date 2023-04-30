package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
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
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/**/root-*.xml"
})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SampleXAServiceTests {

	@Autowired
	private SampleXAService service;
	
	
	@BeforeAll
	void beforeAll() {		//일회성 전처리
		log.trace("beforeAll() invoked.");
		
		assertNotNull(this.service);
		log.info("\t+ this.service: {}", this.service);
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("contextLoads")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void contextLoads() throws ServiceException {
		log.trace("contextLoads() invoked.");
		
		String testData = "01234567890123456789012345678901234567890123456789";	//51바이트 크기
		boolean success = this.service.register(testData);
		
		log.info("\t+ success: {}", success);
	}  //contextLoads
} //end class







