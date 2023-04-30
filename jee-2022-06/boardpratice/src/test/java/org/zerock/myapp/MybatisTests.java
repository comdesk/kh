package org.zerock.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MybatisTests {
	private SqlSessionFactory factory;
	
	@BeforeAll
	void beforeAll() throws IOException {
		log.trace("beforeAll() invoked.");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		log.info("1. builder: {}", builder);
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		log.info("2. is: {}", is);
		
		this.factory = builder.build(is);
		log.info("3. factory: {}", factory);
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("테스트3: insertBoard 테스트")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void insertBoard() {
		log.trace("insertBoard() invoked.");

		@Cleanup
		SqlSession sqlSession = this.factory.openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		log.info("mapper: {}", mapper);
		
		int n = mapper.insertBoard("안녕", "hhh", "123456");
		
		log.info("n: {}", n);
		
	} //insertBoard
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("테스트3: insertBoard 테스트")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void updateBoard() {
		log.trace("insertBoard() invoked.");

		@Cleanup
		SqlSession sqlSession = this.factory.openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		log.info("mapper: {}", mapper);
		
		int n = mapper.updateRepStep("67", "1");
		
		log.info("n: {}", n);
		
	} //insertBoard
	
	
} //end class
