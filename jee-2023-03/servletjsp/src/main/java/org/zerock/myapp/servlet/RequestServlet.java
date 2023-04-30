package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/Request")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			//1. 전송파라미터 획득
			String username = req.getParameter("username");
			String useraddress = req.getParameter("useraddress");
			
			//2. Request Scope 공유 영역에 모델 속성 바인딩
			req.setAttribute("username", username);
			req.setAttribute("useraddress", useraddress);
			
			//3. Requests Forwarding (요청 위임) => 응답화면을 만들어낼 servlet에게 위임
//			RequestDispatcher dis = req.getRequestDispatcher("/Response");
			RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/index.jsp");
			dis.forward(req, res);	//요청과 응답 객체를 그대로 넘겨줘야 함
			
			//위의 의미: 현재 이 서블릿은 여기까지만 하고, 나머지는 위임시킨 쪽에서 하라! 라고 함.
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
		
	} //service

} //end class







