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

@WebServlet("/TT2")
public final class TT2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		//현재 이 요청을 보낸 웹브라우저에 대한 세션(금고상자)이 
		//있으면 반환해주고, 없으면 null을 반환
		HttpSession sess = req.getSession(false);
		
		//현재 이 요청을 보낸 웹 브라우저에 대한 세션(금고상자)를
		//강제로 파괴하고, 금고상자(세션)의 키인 세션ID도 무력화시켜라 => 로그아웃
		if(sess != null) sess.invalidate();
		else log.error("세션이 없습니다.");
	} //service

} //end class
