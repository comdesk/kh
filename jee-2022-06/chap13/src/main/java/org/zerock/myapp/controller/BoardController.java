package org.zerock.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
//@NoArgsConstructor
@AllArgsConstructor		//생성자 주입 받기 위해서.

@RequestMapping("/board")
@Controller

//아래 어노테이션의 속성인 배열({속성명1, 속성명2, ...})에 지정한
//모델 속성들은 자동으로 세션에도 저장하게 해주는 어노테이션
//@SessionAttributes({"board", "boardDTO"})
public class BoardController {

	//@Setter(onMethod_= {@Autowired})
	
	//Spring framework v4.3 이후부터는, 아래와 같은 조건 시, 자동주입:
	//1. 주입받을 필드가 오직 1개이고
	//2. 이 필드를 매개변수로 가지는 생성자가 있다면
	//생성자 자동 주입	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) throws ControllerException {	//게시판전체목록조회요청처리 핸들러
		log.trace("list({}) invoked.", cri);
		
		try {
			List<BoardVO> list = this.service.getList(cri);
			model.addAttribute("list", list);
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch		
	} //list
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Integer bno, Model model) throws ControllerException {
		log.trace("get({}, {}) invoked.", bno, model);
		
		try {
			BoardVO vo = this.service.get(bno);
			model.addAttribute("board", vo);
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch	
	} //get
	
	@PostMapping("/remove")
	public String remove(Criteria cri, Integer bno, RedirectAttributes rttrs) throws ControllerException {
		log.trace("remove({}, {}, {}) invoked.", cri, bno, rttrs);
		
		try {
			boolean success = this.service.remove(bno);
			log.info("\t+ success: {}", success);
			
			//페이징 처리용 전송파라미터도 함께 전송처리
			rttrs.addAttribute("currPage", cri.getCurrPage());
			rttrs.addAttribute("amount", cri.getAmount());

			//Model 전송 처리
			rttrs.addAttribute("result", (success) ? "success" : "failure");
			
			return "redirect:/board/list";
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
	} //remove
	
	@PostMapping("/modify")  //BoardDTO는 Command Object로 자동으로 수집됨.
	public String modify(Criteria cri, BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
		log.trace("modify({}, {}, {}) invoked.", cri, dto, rttrs);
		
		try {
			boolean success = this.service.modify(dto);
			log.info("\t+ success: {}", success);
			
			//페이징 처리용 전송파라미터도 함께 전송처리
			rttrs.addAttribute("currPage", cri.getCurrPage());
			rttrs.addAttribute("amount", cri.getAmount());

			//Model 전송 처리
			rttrs.addAttribute("result", (success) ? "success" : "failure");
			
			return "redirect:/board/list";
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
	}//modify
	
	@PostMapping("/register")
	public String register( BoardDTO dto, Criteria cri, RedirectAttributes rttrs) throws ControllerException {
		log.trace("register({}, {}, {}) invoked.", dto, cri, rttrs);
		
		try {
			boolean success = this.service.register(dto);
			log.info("\t+ success: {}", success);

			//페이징 처리용 전송파라미터도 함께 전송처리
			rttrs.addAttribute("currPage", cri.getCurrPage());
			rttrs.addAttribute("amount", cri.getAmount());
			
			//비즈니스 요청 처리용 전송파라미터 전송처리
			rttrs.addAttribute("result", (success) ? "success" : "failure");
			
			return "redirect:/board/list";
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
	}//modify
	
	@GetMapping("/register")
	void register() {
		log.trace("register() invoked.");
	} //register
	
//	================================================= //
//	HttpSession, HttpServletRequest, HttpServletResponse 객체가 정말 필요하면,
//	DispatcherServlet에게 "달라!"라고 지정하면 준다.
//	(주의사항) 하지만, 이 객체를 직접 핸들링하는 것은, 스프링에 반하는 행위이다. (권장하지 않음)
//	================================================= //
//	@GetMapping("/temp")
//	void temp(
//				HttpSession session, 
//				HttpServletRequest req, 
//				HttpServletResponse res,
//				@SessionAttribute("board") BoardVO vo
//			) {
//		log.trace("temp({}, {}, {}, {}) invoked.", session, req, res, vo);		
//	} //temp
//	
//	@ModelAttribute("boardDTO")
//	BoardDTO createBoardDTO() {	//이 메소드는 요청을 처리하는 핸들러 메소드가 아님(리퀘스트 매핑 안 해서)
//		log.trace("createBoardDTO() invoked.");
//		
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(1000);
//		dto.setTitle("TEST");
//		
//		return dto;
//	} //createBoardDTO
	

} //end class














