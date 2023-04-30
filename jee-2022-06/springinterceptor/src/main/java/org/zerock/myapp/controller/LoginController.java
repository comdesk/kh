package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2

//아래의 어노테이션은 "반드시" "Model 상자에 넣은 KEY"를 지정하면,
//이 Key 이름으로 Session Scope에 공통 속성으로 넣어준다.
//@SessionAttributes({"__AUTH__"})	//LoginInterceptor에서 처리
@RequestMapping("/user")
@Controller
public class LoginController {	//POJO

	private UserService service;
	
	@PostMapping("/loginPost")
	public String loginPost(LoginDTO dto, RedirectAttributes rttrs, Model model) 
			throws ControllerException{
		log.trace("loginPost({}, {}, {}) invoked.", dto, rttrs, model);		
		try {
			UserVO vo = this.service.login(dto);
			log.info("\t+ vo: {}", vo);
			
			if(vo != null) {	//if 인증 성공
				model.addAttribute("__AUTH__", vo);
				
//				return null;	//=="/user/loginPost" (return타입이 반드시 있어야 해서 정하지 않아도 뷰 이름 정해지지만, null을 넣음.
				return null;		//메인화면
			} else {			//if 인증 실패
				rttrs.addAttribute("result", "Login Failed");
				return "redirect:/user/login";		//인증실패결과와 함께 로그인 화면으로 다시 밀어버림
			} //if-else
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
		
	} //loginPOst
	
	//LogoutInterceptor가 로그아웃요청(/user/logout)을 가로채서(preHandle),
	//인터셉터에서 로그아웃 처리 완료(세션객체 파괴), 요청을 이 핸들러 메소드로 보내지 않음.
	@GetMapping("/logout")
	public void dummyLogout() {
		log.trace("logouot() invoked.");
	} //logout
} //end class







