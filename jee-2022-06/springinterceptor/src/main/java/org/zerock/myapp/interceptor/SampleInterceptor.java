package org.zerock.myapp.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2

@Component
public class SampleInterceptor implements HandlerInterceptor {

	//HTTP request가 해당 컨트롤러의 핸들러 메소들에게 위임(전달)되기 직전에
	//자동으로 Callback (스프링 프레임워크가 콜백)
	@Override
	public boolean preHandle(			//전처리(Pre-processing)
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object handler) throws Exception {
		log.trace("================================================================");
		log.trace("1. preHandle(req, res, {}) invoked.", handler);
		log.trace("================================================================");
		
//		//============== 1. 인증체크(Authentication) =================
//		HttpSession session = req.getSession(false);
//		if(session == null) {	//세션 자체가 없으니, 인증정보도 없음 => 로그인 창으로 밀어버림
//			res.sendRedirect("/login");	//로그인 창으로 밀어버림
//			return false;	//요청을 뒤로 넘겨서는 안됨(***)
//		} else {	//세션은 있는데, Session Scope 공유영역에 미리 약속된 인증데이터가 없을 때
//			String authKey = "__AUTH__";
//			Object auth = session.getAttribute(authKey);
//			
//			if(auth == null) {	//미인증상태임 => 로그인 창으로 밀어버림
//				res.sendRedirect("/login");
//				
//				return false;	//요청을 뒤로 넘겨서는 안됨(***)
//			} //if
//		} //if-else
		
		
		
		//============== 2. 인가: 접근제한(Authorization) ===============
		String requestURL = req.getRequestURL().toString();
		HttpSession session = req.getSession(false);
		String sessionId = (session != null)? session.getId() : "NO SESSION";
		String clientAddress = req.getRemoteAddr();
		
		if("192.168.10.102".equals(clientAddress)) {	//블랙리스트 IP주소에 해당한다면
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<h2>Access Denied.</h2><hr>");
			out.println("<p>1. requestURL: " + requestURL + "</p>");
			out.println("<p>2. sessionId: " + sessionId + "</p>");
			out.println("<p>3. clientAddress: " + clientAddress + "</p>");
			
			out.flush();
			
			return false;	//요청을 넘기지 않고, 여기서 응답메시지 보내 버림.
		} //if

		return true; 	//기본값은 true로 그 다음으로 요청을 넘김(위임) 
	} //preHandle

	//Controller의 Handler 메소드가 위임받은 HTTP request를 처리완료하여
	//Model과 View 이름을 반환한 직후에(그리고 아직까지 View는 호출되기 전에)
	//자동으로 Callback(*주의*: View가 호출되기 전이다.)
	//주의: 컨트롤러의 핸들러메소드에서 예외가 발생하면, Callback되지 않음.
	@Override
	public void postHandle(
			HttpServletRequest req, HttpServletResponse res, 
			Object handler,	ModelAndView modelAndView) throws Exception {
		log.trace("================================================================");
		log.trace("2. postHandle(req, res, {}, {}) invoked.", handler, modelAndView);
		log.trace("================================================================");
		
		log.info("\t+ handler type: {}", handler.getClass().getName());
	} //postHandle

	//View(JSP)까지 호출 완료되어, HTTP response가 전송완료된 직후에 Callback
	//(주의): 컨트롤러의 핸들러 메소드에서 예외가 발생하든/안하든 무조건 Callback
	@Override
	public void afterCompletion(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object handler, 
			Exception e) throws Exception {
		log.trace("================================================================");
		log.trace("e. afterCompletion(req, res, {}, e) invoked.", handler, e);
		log.trace("================================================================");
	} //afterCompletion

} //end class








