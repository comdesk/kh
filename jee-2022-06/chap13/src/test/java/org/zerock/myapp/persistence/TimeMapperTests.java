package org.zerock.myapp.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
import org.zerock.myapp.mapper.TimeMapper;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
//@AllArgsConstructor

//Spring Framework를 함께 구동시킴
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "file:src/main/webapp/WEB-INF/**/root-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeMapperTests {
	
	@Setter(onMethod_= @Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	void beforeAll() {	//의존성주입 잘 됐나 확인.
		log.trace("beforeAll() invoked.");
		
		assert this.sqlSessionFactory != null;
		
		log.info("\t+ this.sqlSessionFactory: {}", this.sqlSessionFactory);
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: To test getNow method annotation")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testGetNow() {
		log.trace("testGetNow() invoked.");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		TimeMapper mapper = sqlSession.<TimeMapper>getMapper(TimeMapper.class);
		
		assertNotNull(mapper);
		log.info("\t+ mapper: {}, type: {}", mapper, mapper.getClass().getName());
		
		Date now = mapper.getNow();
		
		log.info("\t+ now: {}", now);
	} //testGetNow

	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("테스트2: To test getNow2 method interface+xml")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testGetNow2() {
		log.trace("testGetNow3() invoked.");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		TimeMapper mapper = sqlSession.<TimeMapper>getMapper(TimeMapper.class);
		
		assertNotNull(mapper);
		log.info("\t+ mapper: {}, type: {}", mapper, mapper.getClass().getName());
		
		Date now = mapper.getNow2();
		
		log.info("\t+ now: {}", now);
	} //testGetNow2
} //end class










