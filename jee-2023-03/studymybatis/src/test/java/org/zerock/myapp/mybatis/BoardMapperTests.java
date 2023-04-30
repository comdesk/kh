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
public class BoardMapperTests {

	private SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	void beforeAll() throws IOException {
		log.trace("beforeAll() invoked.");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
		Objects.nonNull(config);
		this.sqlSessionFactory = builder.build(config);
		log.trace("\t+ this.sqlSessionFactory: {}", sqlSessionFactory);
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("1. 테스트1: selectAllBoards 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void selectAllBoards() throws DAOException {
		log.trace("selectAllBoards() invoked.");

		try {
			//Step.1 SqlSession 객체 획득 from SqlSessionFactory
			@Cleanup
			SqlSession sqlSession = this.sqlSessionFactory.openSession();
			assert sqlSession != null;
			log.info("\t+ 1. sqlSession:{}", sqlSession);
			
			// Step.2 MyBatis Framework의 설정 파일에 등록된 Mapper Interface에 대한
			//		  DP(Dynamic Proxy) 객체를 획득
			//Mapper Interface에 선언된 추상 메소드를 호출 => SQL 처리 => 그 결과를 얻자
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			
			Objects.requireNonNull(mapper);
			log.info("\t+2. mapper: {}", mapper);
			log.info("\t+3. type: {}", mapper.getClass().getName());
			
			//Step.3 Mapper Interface에 선언된 추상 메소드를 호출, 결과를 반환
			List<BoardVO> boards = mapper.selectAllBoards();
			
			assertNotNull(boards);
			boards.forEach(log::info);
		} catch(Exception e) {
			throw new DAOException(e);
		} //try-catch

	} //SelectAllBoards
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("2. 테스트2: selectBoards 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void selectBoard() {
		
		log.trace("selectBoard() invoked.");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);	//다형성-1
		
		if(mapper != null) {
			log.info("\t+1. mapper: {}, type: {}", mapper, mapper.getClass().getName() );
			
			BoardVO vo = mapper.selectBoard(33);
			log.info("\t+2. vo: {}", vo);
		}
	} //selectBoard
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("3. 테스트3: selectBoardRange() 메소드 테스트")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void selectBoardRange() {
		
		log.trace("selectBoardRange() invoked.");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);	//다형성-1
		
		if(mapper != null) {
			log.info("\t+1. mapper: {}, type: {}", mapper, mapper.getClass().getName() );
			
			List<BoardVO> list = mapper.selectBoardRange(10, 20);
			list.forEach(log::info);
		} //if
	} //selectBoard
} //end class











