package org.zerock.myapp.di;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

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
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

//1. For JUnit ver 4.x
//@RunWith(SpringRunner.class)				//JUnit4이 제공하는 클래스
//@RunWith(SpringJUnit4ClassRunner.class)	//스프링이 제공하는 클래스

//2. For JUnit ver 5.x
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DIbyConstructorTests {
	
	@Autowired
	private Restaurant restaurant;
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: 의존성 주입 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void dependencyINjection() {
		
		log.trace("dependencyInjection() invoked.");
		
		assertNotNull(this.restaurant);
		log.info("\t+this.restaurant:{}", this.restaurant);
	} //dependencyINjection
} //end class







