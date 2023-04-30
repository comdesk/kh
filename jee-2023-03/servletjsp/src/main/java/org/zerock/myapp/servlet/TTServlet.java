package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/TT")
public final class TTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");	
    	
    	//현재 요청을 보내는 웹브라우저에 대해서,
    	//세션이 없으면(세션ID도 없고, 금고(Session Scope)도 없는)
    	//새로이 세션을 만들라(웹브라우저의 이름으로 새로운 세션ID도
    	//만들고, 이 세션ID로만 열 수 있는 금고상자(Session Scope)도
    	//Servlet Container 의 Session Storage 영역에 만들라! 는 의미
		HttpSession session = req.getSession();
		log.info("\t+ session id: {}", session.getId());
	} //service

} //end class
