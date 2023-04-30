package org.zerock.myapp.persistence;

import java.sql.Connection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
public class SqlSessionFactoryBeanTests {
	
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
	@DisplayName("테스트1: SqlSessionFactoryBean ")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testSqlSessionFactoryBean() {
		log.trace("testSqlSessionFactoryBean() invoked.");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		log.info("\t+ 1. sqlSession: {}", sqlSession);
		
		Connection conn = sqlSession.getConnection();	//세션이 닫히면 자동으로 닫히므로 따로 닫아주지 않음.
		Objects.requireNonNull(conn);
		log.info("\t+ 2. conn: {}", conn); 	//HikariFroxyConnection이어야 함.
	} //testSqlSessionFactoryBean
} //end class




