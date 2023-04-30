package org.zerock.myapp.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
import org.zerock.myapp.domain.BoardVO;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardSQLMapperTests {
	
	//마이바티스의 핵심객체 2가지: (1) SqlSessionFactory (2) SqlSession
	private SqlSessionFactory factory;
	private SqlSession sqlSession;
	
	@BeforeAll
	void beforeAll() throws IOException {	//1회성 전처리
		log.trace("beforeAll() invoked.");
		
		//SqlSessionFactoryBuilder를 생성해서,
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		//SqlSessionFactory 객체를 획득
		//build 메소드의 매개변수는 마이바티스 설정파일인 'mybatis-config.xml'
		//파일에 대한 입력스트림을 의미: Resources Helper Class를 제공
		
		//1st. method
//		String config = "C:/app/2023/eclipse/workspace/jee-2023-03/studymybatis/src/main/resource/mybatis-config.xml";
//		InputStream is = new FileInputStream(config);
		
		//2nd. method : XX (CLASSPATH 환경변수에 대한 개념이 잡히기 전까지는..)
//		InputStream is = 
//				BoardSQLMapperTests.
//					class.  클래쯔 객체에 걸쳐있는 설정파일을 갖고 오는 거
//					getResourceAsStream("/studymybatis/src/main/resource/mybatis-config.xml");
		
		//3rd.method: 가장 표준적인 방법으로, 마이바티스가 제공하는 helper class 이용
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		this.factory = builder.build(is);
		
		//3. 옳게 공장 객체를 획득했는지 확인
		log.info("\t+ this.factory: {}", this.factory);
	} //beforeAll
	
	@BeforeEach
	void beforeEach() {
		//1. SqlSessionFactory 공장에서, SqlSession이란 핵심객체를 생성
		this.sqlSession = this.factory.openSession();	//항상 성공하는 메소드라 throws 절 없음.
	} //beforeEach
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: Mapper_1.SQL_1 문장테스트 수행")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void SQL_1() {
		
		log.trace("SQL_1() invoked.");	
		
		//2. Mapped Statement를 지정해서, SQL 문장 처리하기
		String namespace = "Mapper_1";
		String sqlId = "SQL_1";
		String mappedStatement = namespace + "." + sqlId;
		
		log.info("\t2. mappedStatement: {}", mappedStatement);
		
		List<BoardVO> list = sqlSession.<BoardVO>selectList(mappedStatement);
			
		list.forEach(log::info);
		
		this.sqlSession.close();	//자원해제
	
	} //SQL_1
	
//  @Disabled
    @Test
    @Order(2)
    @DisplayName("테스트2: Mapper_1.SQL_2 문장테스트 수행")
    @Timeout(value=5, unit=TimeUnit.MINUTES)
    void SQL_2() {
	    log.trace("SQL_2() invoked.");
	     
	    // 2. Mapped Statement 을 지정해서, SQL 문장 처리하기
	    String namespace = "Mapper_1";
	    String sqlId = "SQL_2";
	     
	    String mappedStatement = namespace + "." + sqlId;
	    log.info("\t2. mappedStatement: {}", mappedStatement);
	     

    	BoardVO vo = this.sqlSession.selectOne(mappedStatement, 12);
        log.info(vo);
        
        this.sqlSession.close();	//자원해제

  	} // SQL_2
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("테스트3: Mapper_1.SQL_3 문장테스트 수행")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void SQL_3() {
		
		log.trace("SQL_3() invoked.");
		
		//2. Mapped Statement를 지정해서, SQL 문장 처리하기
		String namespace = "Mapper_1";
		String sqlId = "SQL_3";
		
		String mappedStatement = namespace + "." + sqlId;		
		log.info("\t2. mappedStatement: {}", mappedStatement);
		
		//2. 2개 이상의 바인드 변수를 가지고 있는 SQL 문장에 전달할 값을
		//	 Map 객체를 통해서 준비하고 전달하자!
		//2개 이상의 바인드 변수(#{바인드변수명})를 가지고 있는
		//SQL 문장에 전달할 바인드 값은 보통 아래와 같이,
		//Map 객체로 만들어 전달하거나, 최소한 get<바인드변수명>이름의 Getter 메소드를 가지고 있는
		//객체면 전달 가능하다. (***) 
		@Cleanup("clear")
		Map<String, Integer> params = new HashMap<>();
		params.put("startBno", 10);
		params.put("endBno", 20);
		
//											 selectList(String statement, Object parameter)
		List<BoardVO> list = this.sqlSession.selectList(mappedStatement, params);
		list.forEach(log::info);

		this.sqlSession.close();	//자원해제
	} //SQL_3
	
} //end class











