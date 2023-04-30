package org.zerock.myapp.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.BoardVO;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={
//		"file:src/main/webapp/spring/**/*.xml"
		"file:src/main/webapp/**/spring/root-*.xml",
		"file:src/main/webapp/**/spring/**/servlet-*.xml",
		})

//Spring MVC 까지 작동(=> 결과적으로 Spring core인, **Spring Beans Container**까지 생성함)시키는
//어노테이션으로, 표현계층의 컨트롤러 핸들러 메소드를 테스트할 때에는,
//반드시 넣어주어야 하는 어노테이션. (*******)
@WebAppConfiguration	

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardControllerTests {
	
	//다른 계층처럼 아래와 같이 하면 안 된다!
//	@Setter(onMethod_= {@Autowired})
//	private BoardController controller;
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;	//Spring beans container의 구현객체(***)
	
	//가상의 Spring Mvc를 테스트해주는 POSTMAN 과 비슷한 역할을 수행
	//이 타입의 객체를 통해서, 실질적으로 컨트롤러의 핸들러 메소드 테스트를 수행한다.
//	private MockMvc mockMvc;
	
	@BeforeAll
	void beforeAll() {		//1회성 전처리 수행
		log.trace("beforeAll() invoked.");
		
		//의존성 주입(DI) 확인
		assertNotNull(this.ctx);
		log.info("\t+ this.ctx: {}", this.ctx);
	} //beforeAll
	

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("testList")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testList() throws Exception {
		log.trace("testList() invoked.");
		
		//MockMvc를 지어줄 "건설사(Builder)"부터 획득
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//BoardController의 /board/list, GET 핸들러 테스트
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/list");
		
		//이제 가상의 MVC 환경에서, BoardController에 요청 생성 및 전송			
		ModelAndView modelAndView = mockMvc.perform(requestBuilder).andReturn().getModelAndView();
		log.info("\t+ viewName: {}, type: {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		
		//테스트 대상 컨트롤러 핸들러(메소드)가 반환한, (1) 모델 (2) 뷰이름 중에,
		//모델(ModelMap)을 얻었으니, 순회하여 그 안의 모든 모델속성(즉, 비즈니스 데이터인 모델객체들)
		//출력
//		@Cleanup("clear")	
//		ModelMap modelMap = mockMvc.perform(requestBuilder).andReturn().getModelAndView().getModelMap();
//		log.info("\t+ modelMap: {}", modelMap);
		
	} //testList
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testGet")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testGet() throws Exception {
		log.trace("testGet() invoked.");
		
		//MockMvc를 지어줄 "건설사(Builder)"부터 획득
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//BoardController의 /board/list, GET 핸들러 테스트
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/get").param("bno", "200");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/get");
		requestBuilder.param("bno", "33");
		
		
		//이제 가상의 MVC 환경에서, BoardController에 요청 생성 및 전송	
		ModelAndView modelAndView = mockMvc.perform(requestBuilder).andReturn().getModelAndView();
		log.info("\t+ viewName: {}, type: {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		
	} //testGet
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testRemove")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testRemove() throws Exception {
		log.trace("testRemove() invoked.");
		
		//MockMvc를 지어줄 "건설사(Builder)"부터 획득
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//BoardController의 /board/list, GET 핸들러 테스트
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/remove").param("bno", "304" );
		
		//이제 가상의 MVC 환경에서, BoardController에 요청 생성 및 전송
		@Cleanup("clear")		
		ModelAndView modelAndView = 
				mockMvc.
					perform(requestBuilder).
					andReturn().
					getModelAndView();
		
		log.info("\t+ viewName: {}, type: {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		log.info("\t+ model: {}", modelAndView.getModel());		
	} //testRemove
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("testRegister")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testRegister() throws Exception {
		log.trace("testRegister() invoked.");
		
		//MockMvc를 지어줄 "건설사(Builder)"부터 획득
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//BoardController의 /board/list, GET 핸들러 테스트
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.
				post("/board/register").
				param("title", "305" ).param("content", "305").param("writer", "305");
		
		//이제 가상의 MVC 환경에서, BoardController에 요청 생성 및 전송
		@Cleanup("clear")		
		ModelAndView modelAndView = 
				mockMvc.
					perform(requestBuilder).
					andReturn().
					getModelAndView();
		
		log.info("\t+ viewName: {}, type: {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		log.info("\t+ model: {}", modelAndView.getModel());		
	} //testRegister
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("testModify")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testModify() throws Exception {
		log.trace("testModify() invoked.");
		
		//MockMvc를 지어줄 "건설사(Builder)"부터 획득
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//======== Step.1 305 bno 게시글을 상세 조회 ========//
		
		//BoardController의 /board/list, GET 핸들러 테스트
		MockHttpServletRequestBuilder requestBuilder = 
					MockMvcRequestBuilders.
					get("/board/get").param("bno", "305");
		
		//이제 가상의 MVC 환경에서, BoardController에 요청 생성 및 전송	
		ModelAndView modelAndView = 
				mockMvc.
					perform(requestBuilder).
					andReturn().
					getModelAndView();
		
		log.info("\t+ viewName: {}, type: {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		
		ModelMap model = modelAndView.getModelMap();
		log.info("\t+ model: {}", model, model.getClass().getName());
		
		BoardVO vo = (BoardVO) model.getAttribute("board");
		log.info("\t+ vo: {}", vo);
		
		//======== Step.2 305 bno 게시글을 수정 ========//
		Integer bno = vo.getBno();
//		String title = vo.getTitle();
//		String content = vo.getContent();
		String writer = vo.getWriter();
		
		
		requestBuilder = MockMvcRequestBuilders.post("/board/modify");
		requestBuilder.param("bno", bno.toString());
		requestBuilder.param("title", "NEW TITLE");			//수정항목1
		requestBuilder.param("content", "NEW CONTENT");		//수정항목2
		requestBuilder.param("writer", writer);
		
		modelAndView = 
				mockMvc.
					perform(requestBuilder).
					andReturn().
					getModelAndView();
		
		log.info("\t+ viewName: {}, type: {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		
	} //testModify
	
//	@Disabled
	@Test
	@Order(6)
	@DisplayName("testRegisterByGet")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testRegisterByGet() throws Exception {		//단순 뷰 컨트롤러
		log.trace("testRegister() invoked.");

		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/board/register");
					
		ModelAndView modelAndView = 
				mockMvc.
					perform(requestBuilder).
					andReturn().
					getModelAndView();
		
		log.info("\t+ modelAndView: {}", modelAndView);
	} //testRegisterByGet
	
//	@Disabled
	@Test
	@Order(7)
	@DisplayName("testModifyByGet")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testModifyByGet() throws Exception {		//단순 뷰 컨트롤러
		log.trace("testModifyByGet() invoked.");

		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();

		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/board/modify").param("bno", "305");
					
		ModelAndView modelAndView = 
				mockMvc.
					perform(requestBuilder).
					andReturn().
					getModelAndView();
		
		log.info("\t+ modelAndView: {}", modelAndView);
	} //testModifyByGet
} //end class

























