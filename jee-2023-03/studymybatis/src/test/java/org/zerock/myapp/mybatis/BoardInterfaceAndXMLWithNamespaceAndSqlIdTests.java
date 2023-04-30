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

@Log4j2
@NoArgsConstructor

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardInterfaceAndXMLWithNamespaceAndSqlIdTests {

	private SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	void beforeAll() throws IOException {
		log.trace("beforeAll() invoked.");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		this.sqlSessionFactory = builder.build(config);
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("1. 테스트1: selectBoard 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void selectBoard() {
		log.trace("selectBoard() invoked.");

		//Step.1 SqlSession 객체 획득 from SqlSessionFactory
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		// Step.2 Mapper Interface에 등록된 Annotation으로 SQL 수행
		//		  수행시키되, namespace + sqlId 두 가지로 수행
		String namespace = "org.zerock.myapp.mapper.BoardMapper";
		String sqlId = "selectBoard";
		String mappedStatement = namespace + "." + sqlId;
		log.info("\t+ mappedStatement: {}", mappedStatement);
		
		//Step.3 Mapper Interface에 선언된 추상 메소드를 호출, 결과를 출력
		BoardVO vo = sqlSession.selectOne(mappedStatement, 7);
		log.info("\t+ vo: {}", vo);
	} //selectBoard
	
	//@Disabled
	@Test
	@Order(1)
	@DisplayName("1. 테스트1: selectBoard 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void selectAllBoards() {
		log.trace("selectAllBoards() invoked.");

		//Step.1 SqlSession 객체 획득 from SqlSessionFactory
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		// Step.2 Mapper Interface에 등록된 Annotation으로 SQL 수행
		//		  수행시키되, namespace + sqlId 두 가지로 수행
		String namespace = "org.zerock.myapp.mapper.BoardMapper";
		String sqlId = "selectAllBoards";
		String mappedStatement = namespace + "." + sqlId;
		log.info("\t+ mappedStatement: {}", mappedStatement);
		
		//Step.3 Mapper Interface에 선언된 추상 메소드를 호출, 결과를 출력
		List<BoardVO> list = sqlSession.selectList(mappedStatement);
		list.forEach(log::info);
	} //selectAllBoards
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("3. 테스트3: selectBoardRange 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void selectBoardRange() {
		log.trace("selectBoardRange() invoked.");

		//Step.1 SqlSession 객체 획득 from SqlSessionFactory
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		// Step.2 Mapper Interface에 등록된 Annotation으로 SQL 수행
		//		  수행시키되, namespace + sqlId 두 가지로 수행
		String namespace = "org.zerock.myapp.mapper.BoardMapper";
		String sqlId = "selectBoardRange";
		String mappedStatement = namespace + "." + sqlId;
		log.info("\t+ mappedStatement: {}", mappedStatement);
		
		//Step.3 Mapper Interface에 선언된 추상 메소드를 호출, 결과를 출력
		Map<String, Integer> params = new HashMap<>();
		params.put("startBno", 20);		//xml에 있는 바인드 변수명 가져옴.
		params.put("endBno", 30);
		
		List<BoardVO> list = sqlSession.selectList(mappedStatement, params);
		list.forEach(log::info);
	} //selectBoardRange

} //end class











