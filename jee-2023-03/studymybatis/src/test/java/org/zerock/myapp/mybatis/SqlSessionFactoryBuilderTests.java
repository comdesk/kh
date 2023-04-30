package org.zerock.myapp.mybatis;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SqlSessionFactoryBuilderTests {

	private SqlSessionFactoryBuilder builder;
	private SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	void beforeAll() throws IOException {	//1회성 전처리
		log.trace("beforeAll() invoked.");
		
		//Step.1 SqlSessionFactoryBuilder 객체(비유: 건설사) 생성
		this.builder = new SqlSessionFactoryBuilder();
		Objects.nonNull(builder);
		log.info("\t+ builder: {}", builder);
		
		//Step.2 SqlSessionFactory 객체(비유: 생산공장) 생성
		
		//가. 마이바티스 설정 파일에 대한 InputStream 객체 생성
		
		//1st. method
		String config = "mybatis-config.xml";
		@Cleanup
		InputStream is = Resources.getResourceAsStream(config);
		
		//2nd. method
//		String config = "C:/Temp/mybatis-config.xml";
//		File f = new File(config);	
//		
//		InputStream is = null;
//		if(f.exists()) {
//			is = new FileInputStream(f);
//		} //if
		
		assertNotNull(is);
		log.info("\t+ is: {}", is);
		
		//나. 가에서 생성한 InputStream 객체를 이용해서, 건설사(builder)가 공장(factory)을
		//	  건설할 수 있도록 해준다
		this.sqlSessionFactory = this.builder.build(is);
		
		assert this.sqlSessionFactory != null;
		log.info("\t+ 3. this.sqlSessionFactory: {}", sqlSessionFactory);
		
	} //beforeAll
	@BeforeEach
	void beforeEach() {
		log.trace("beforeEach() invoked.");
	} //@BeforeEach
	
	@AfterAll
	void afterAll() {
		log.trace("afterAll() invoked.");
	} //afterAll
	@AfterEach()
	void afterEach() {
		log.trace("afterEach() invoked.");
	} //afterEach
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: SqlSession 객체 생성")
	@Timeout(value=3, unit=TimeUnit.MINUTES)
	void createSqlSessionFactoryBuilder() {
		
		log.trace("createSqlSessionFactoryBuilder() invoked.");
		
		for(int i = 0; i <= 10; i++) {
			@Cleanup
			SqlSession sqlSession = this.sqlSessionFactory.openSession();
			
			assertNotNull(sqlSession);
			log.info("\t+ [{}]. sqlSession: {}", i, sqlSession);
			
			Connection conn = sqlSession.getConnection();
			
			Objects.requireNonNull(conn);
			log.info("\t+ [{}]. conn: {}", i, conn);
		} //for
	} //createSqlSessionFactoryBuilder
	
} //end class










