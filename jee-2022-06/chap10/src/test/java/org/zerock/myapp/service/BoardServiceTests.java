package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
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
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private BoardService service;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll invoked.");
		
		assertNotNull(this.service);
		log.info("\t+ this.service: {}", this.service);
	} //beforeAll
	
//	@Disabled
	@Test
	@DisplayName("testGetList")
	@Order(1)
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testGetList() throws ServiceException{
		log.trace("testGetList() invoked.");
		
		List<BoardVO> list = this.service.getList();
		
		assert list != null;
		list.forEach(log::info);
	} //testGetList
	
//	@Disabled
	@Test
	@DisplayName("testGet")
	@Order(2)
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testGet() throws ServiceException{
		log.trace("testGet() invoked.");
		
		int bno = 77;
		BoardVO vo = this.service.get(bno);
		
		if(vo != null) {
			log.info("\t+ vo: {}", vo);
		} else {
			throw new ServiceException("BorardVO is NULL.");
		} //if-else
	} //testGet
	
//	@Disabled
	@Test
	@DisplayName("testRemove")
	@Order(3)
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testRemove() throws ServiceException{
		log.trace("testRemove() invoked.");
		
		int bno = 302;
		boolean isSuccess = this.service.remove(bno);
		
		log.info("\t+ isSuccess: {}", isSuccess);
	} //testRemove
	
//	@Disabled
	@Test
	@DisplayName("testRegister")
	@Order(4)
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testRegister() throws ServiceException{
		log.trace("testRegister() invoked.");
		
		BoardDTO dto = new BoardDTO();
		
		dto.setTitle("NEW_TITLE");
		dto.setContent("NEW_CONTENT");
		dto.setWriter("Yoseph");
		
		boolean isSuccess = this.service.register(dto);		
		log.info("\t+ isSuccess: {}", isSuccess);
	} //testRegister
	
//	@Disabled
	@Test
	@DisplayName("testModify")
	@Order(4)
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testModify() throws ServiceException{
		log.trace("testModify() invoked.");
		
		BoardVO vo299 = this.service.get(299);
		BoardDTO dto = new BoardDTO();
		
		dto.setBno(299);
		dto.setTitle(vo299.getTitle());
		dto.setContent("CONTENT_UPDATE");
		dto.setWriter(vo299.getWriter());
		
		boolean isSuccess = this.service.modify(dto);		
		log.info("\t+ isSuccess: {}", isSuccess);
	} //testModify
} //end class








