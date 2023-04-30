package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/PostPre")
public class PostPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	void postConstruct() {
		log.trace("postConstruct() invoked.");
		
		try {
			;;
		} catch(Exception e) {
			e.printStackTrace();
		} //try-catch
	} //postContruct
	
	public void init(ServletConfig config) throws ServletException {
		log.trace("init({}) invoked.", config);
	} //init

	@PreDestroy
	void preDestroy() {
		log.trace("preDestroy() invoked.");
		
		try {
			;;
		} catch(Exception e) {
			e.printStackTrace();
		} //try-catch
	} //preDestroy
	
	public void destroy() {
		log.trace("destroy() invoked.");
	} //destroy
	
	

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
//		============응답처리==============
		
		res.setContentType("text/html; charset=utf-8");
		res.setCharacterEncoding("utf8");
		
		PrintWriter out = res.getWriter();
		
		try(out;) {
			out.print("<h1>PrePostServlet</h1>");
			out.flush();
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-with
	} //service

} //end class





