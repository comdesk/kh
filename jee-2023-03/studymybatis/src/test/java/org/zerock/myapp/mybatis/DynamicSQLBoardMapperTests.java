package org.zerock.myapp.mybatis;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
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
import org.zerock.myapp.exception.DAOException;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DynamicSQLBoardMapperTests {

	private SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	void beforeAll() throws IOException {
		log.trace("beforeAll() invoked.");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		Objects.nonNull(config);
		this.sqlSessionFactory = builder.build(config);
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("1. 테스트1: BoardMapper.findBoardsByBno 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void findBoardsByBno() throws DAOException {
		log.trace("findBoardsByBno() invoked.");

		//----------------------------------------------------//
		//동적 SQL (Dynamic SQL) 방식으로, SQL문장 수행 테스트
		//----------------------------------------------------//
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		//1st. method: MapperProxy (Mapper Interface 방식 의미) 방식으로 호출
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);	//To get the MapperProxy object.
		
//		Objects.requireNonNull(mapper);
		
//		Integer searchBno = 7;		//OK //7번 게시글 검색 수행
		Integer searchBno = null;	//XX
		
//		List<BoardVO> list = mapper.findBoardByBno(searchBno);			
		
		//2nd. method: namespace with sqlId 방식으로 호출
		String namespace = "org.zerock.myapp.mapper.BoardMapper";
		String sqlId = "findBoardByBno";
		String mappedStatement = namespace + "." + sqlId;
		List<BoardVO> list = sqlSession.selectList(mappedStatement, searchBno);
		
		
		list.forEach(log::info);

	} //findBoardsByBno
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("2. 테스트2: BoardMapper.findBoardByTitle 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void findBoardByTitle() throws DAOException {
		log.trace("findBoardByTitle() invoked.");

//		String searchTitle = "_27";		//OK 
		String searchTitle = null;
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);	//MapperProxy

		List<BoardVO> list = mapper.findBoardByTitle(searchTitle);			
		list.forEach(log::info);

	} //findBoardByTitle
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("2. 테스트2: BoardMapper.findBoardByTitle 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void findBoardsByBnoOrTitle() {
		log.trace("findBoardsByBnoOrTitle() invoked.");

//		Integer searchBno = 277;		//OK
		Integer searchBno = null;	//XX
		
		String searchTitle = "_27";		//OK 
//		String searchTitle = null;
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);	//MapperProxy

		List<BoardVO> list = mapper.findBoardsByBnoOrTitle(searchBno, searchTitle);			
		list.forEach(log::info);

	} //findBoardsByBnoOrTitle
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("3. 테스트2: BoardMapper.findBoardByTitle 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void insertBoard() {
		log.trace("insertBoard() invoked.");

		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);	//MapperProxy

		int n = mapper.insertBoard("TITLE_INSERT", "insert", "hhh");		
		
		log.info("n: {}", n);

	} //insertBoard
} //end class











