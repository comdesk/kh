package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req,res) invoked.");
		
		
//		==1. 전송파라미터 수신==
		
		//전송파라미터에 포함된 다국어 문자들이 깨지지 않도록,
		//가장 먼저 문자집합 설정
//		req.setCharacterEncoding("utf8");
		
		String userid = req.getParameter("userid");
		String passwd = req.getParameter("passwd");
		
		log.trace("userid: {}, password: {}", userid, passwd);
		
//		==2. 응답문서 만들기==
				
//		res.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = res.getWriter();
		
		try(out) {
			out.print("<html><body>");
			out.print("아이디값: " + userid + "<br>");
			out.print("비밀번호값: " + passwd + "<br>");
			out.print("</body></html>");
			
			out.flush();
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-with
		
	} //service

} //end class
