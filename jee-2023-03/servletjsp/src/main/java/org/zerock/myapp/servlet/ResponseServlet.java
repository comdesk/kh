package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/Response")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			//1. 공유된 모델 속성을 가져옴.
			String username = (String) req.getAttribute("username");
			String useraddress = (String) req.getAttribute("useraddress");
			
			//사용이 끝난 공유속성을 제거 => 메모리 누수 안 됨. (finally 블록에서 해도 됨.)
			req.removeAttribute("username");
			req.removeAttribute("useraddress");
			
			//2. 응답화면 생성(JSP 대신)
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<h1>1. username: " + username + "</h1>");
			out.println("<h1>1. useraddress: " + useraddress + "</h1>");	
			
			out.flush();			
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class





