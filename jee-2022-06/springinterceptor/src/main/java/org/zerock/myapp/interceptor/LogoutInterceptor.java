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
public class LogoutInterceptor implements HandlerInterceptor{
	
	//Target of LogoutInterceptor: /user/loginPost(로그아웃처리)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	//전처리
		log.trace("=============================================");
		log.trace("preHandle(req, res, handler) invoked." );
		log.trace("=============================================");
		
		//Step.1 현재 요청을 보낸 웹브라우저에 대한 세션 획득
		HttpSession session = request.getSession(false);	//기존 세션만 획득(새로운 세션을 만들면 안 됨)
		
		//Step.2 세션객체(금고상자) 자체를 파괴시킴
		//		 금고상자(Session Scope) 안에 있었던 모든 공유 속성은 삭제가 발생
		session.invalidate();
		log.info("\t+ 세션객체 파괴완료");
		
		//Step.3 세션 파괴 후, 홈 또는 로그인 화면으로 강제 이동시킴.
		response.sendRedirect("/user/login");
		
		//Step.4 이미 Step.3 에서 웹브라우저를 로그인 창으로 강제 이동시켰으니,
		//		 원래의 요청은 컨트롤러로 보내지 않음.(보낼 필요도 없음)
		return false;	//요청을 컨트롤러 핸들러로 보내지 않음.
	} //preHandle	
	
} //end class










