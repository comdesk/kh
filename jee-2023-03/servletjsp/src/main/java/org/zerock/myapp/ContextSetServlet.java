package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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

@WebServlet("/ContextSet")
public class ContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.trace("service(req,res) invoked.");
		
		try {
			ServletContext sc = this.getServletContext();
			
//			Step.1 To bind new attributes into the Application Scope
			sc.setAttribute("name", "Yoseph");
			sc.setAttribute("age", 23);	//Auto-Boxing: int -> Integer
			
//			Step.2 Ready and Go HTTP response
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<h1>Success to bind new attributes into the application scope</h1>");
			out.flush();
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class








