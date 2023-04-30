package org.zerock.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.UserVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	//Target of LoginInterceptor: /user/loginPost(로그인처리)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	//전처리
		log.trace("=============================================");
		log.trace("preHandle(req, res, handler) invoked." );
		log.trace("=============================================");
		
		//Step.1 현재 요청을 보낸 웹브라우저에 대한 세션 획득
		HttpSession session = request.getSession();
		
		//Step.2 획득한 세션영역(Session Scope, 금고상자)에 "__AUTH__" 이름으로, 
		//UserVO 객체가 있으면 삭제 (이전 로그인 정보가 바뀌지 않으니까 삭제 해주는 것)
		Object auth = session.getAttribute("__AUTH__");
		log.info("\t+ auth: {}", auth);
		
		if(auth != null) {
			session.removeAttribute("__AUTH__");	//금고상자에서 미리 약속된 인증 객체를 삭제
			log.info("\t1. 세션영역에서, 인증객체(__AUTH__) 삭제 완료");
		} //if
		
		
		return true;
	}

	//아직 응답이 생성 및 전송되기 직전에 수행
    //단, 컨트롤러의 핸들러 메소드에서 예외가 발생하면 수행 안됨.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.trace("=============================================");
		log.trace("postHandle(req, res, handler, modelAndView) invoked." );
		log.trace("=============================================");
		
		log.info("\t+ modelAndView: {}" , modelAndView );
		
		//Step.1` 모델에서 얻은 새로운 __AUTH__란 이름으로 저장된 UserVO 객체를 획득
		ModelMap modelMap = modelAndView.getModelMap();
		
		UserVO userVO = (UserVO) modelMap.get("__AUTH__");
		log.info("\t2. userVO: {}", userVO);
		
		//Step.2 새로이 획득한 __AUTH__(UserVO) 인증객체를, 현재 웹브라우저의 세션영역(금고상자)에
		//		 넣는다.
		if(userVO != null) {	//인증에 성공한 현재의 웹브라우저의 새로운 인증객체를 세션영역에 저장
			HttpSession session = request.getSession();	//세션이 없으면 새로이 만들고, 있으면 재사용
			
			//Step.2-1 인증에 성공한 현재의 웹브라우저의 새로운 인증객체를 세션영역에 저장
			session.setAttribute("__AUTH__", userVO);
			log.info("\t3. 세션영역에 새로운 인증 객체 저장 성공");
		} //if
		
	} //preHandle
	
	
	
} //end class










