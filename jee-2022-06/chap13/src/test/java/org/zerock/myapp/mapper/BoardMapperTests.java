package org.zerock.myapp.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Objects;
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
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardMapperTests {
	
	@Setter(onMethod_= {@Autowired})
	private BoardMapper mapper;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
		
		Objects.requireNonNull(this.mapper);
//		assertNotNull(this.mapper);
//		assert this.mapper != null;
		
		log.info("\t+ this.mapper: {}, type: {}", this.mapper, this.mapper.getClass().getName());
	} //beforeAll

////	@Disabled
//	@Test
//	@Order(1)
//	@DisplayName("페이징 처리전(deprecated): testSelectAll")
//	@Timeout(value=4, unit=TimeUnit.SECONDS)
//	void testSelectAll() {
//		log.trace("testSelectAll() invoked.");
//		
//		List<BoardVO> list = this.mapper.selectAll(); //Deprecated
//		assertNotNull(list);
//		
//		list.forEach(log::info);
//	} //testSelectAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("페이징 처리 적용: testSelectAll")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testSelectAll() {
		log.trace("testSelectAll() invoked.");
		
//		int currPage = 2; //현재 페이지 변호
//		int amount = 20;  //한 페이지 당 보여줄 게시물의 개수
//		
//		List<BoardVO> list = this.mapper.selectAll(currPage, amount);
		
//		===================
//		Criteria 적용
//		===================
		Criteria cri = new Criteria();
		cri.setCurrPage(2);
		cri.setAmount(20);
		
		List<BoardVO> list = this.mapper.selectAll(cri);
		
		assertNotNull(list);
		
		list.forEach(log::info);
	} //testSelectAll
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testSelect")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testSelect() {
		log.trace("testSelect() invoked.");
		
		Integer bno = 33;
		BoardVO vo = this.mapper.select(bno);
		
		assertNotNull(vo);
		log.info("\t+ vo: {}", vo);

	} //testSelect
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testDelete")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testDelete() {
		log.trace("testDelete() invoked.");
		
		Integer bno = 300;
		int affectedLines = this.mapper.delete(bno);

		log.info("\t+ affectedLines: {}", affectedLines);

	} //testDelete
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("testInsert")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testInsert() {
		log.trace("testInsert() invoked.");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle("TITLE_NEW");
		dto.setContent("CONTENT_NEW");
		dto.setWriter("WRITER_NEW");
		
		int affectedLines = this.mapper.insert(dto);
		log.info("\t+ affectedLines: {}", affectedLines);

	} //testInsert
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("testUpdate")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testUpdate() {
		log.trace("testUpdate() invoked.");
		
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(302);
//		dto.setTitle("TITLE_302");
//		dto.setContent("CONTENT_302");
//		dto.setWriter("WRITER_302");
		
		BoardVO vo = this.mapper.select(302);
		BoardDTO dto = new BoardDTO();
		dto.setBno(vo.getBno());
		dto.setTitle(vo.getTitle());
		dto.setWriter(vo.getWriter());
		dto.setContent("CONTENT_NEW");
		
		int affectedLines = this.mapper.update(dto);
		log.info("\t+ affectedLines: {}", affectedLines);

	} //testUpdate
} //end class












