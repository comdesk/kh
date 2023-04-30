package org.zerock.myapp;

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

@Log4j2
//@NoArgsConstructor

@WebServlet(
		name="HelloServlet", 
//		urlPatterns={"/Hello", "Hello2", "Hello3"}
		value="/Hello"
)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	//부모가 serializable하기 때문
       
	public HelloServlet() {
		super();
		
		log.trace("Defulat Constructor invoked.");
	} //default constructor

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service({}, {}) invoked.", req, res);
		
		res.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf8");
//		res.setStatus(500);
		
		throw new NullPointerException("test");
		
//		@Cleanup
//		PrintWriter out = res.getWriter();
//		out.println("<h1>Hello, Yoseph!</h1>");
//		
//		out.flush();
	} //service

} //end class
