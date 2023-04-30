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

@WebServlet("/ResponseRedirect")
public class ResponseRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
//			String username = (String) req.getAttribute("username");
//			String useraddress = (String) req.getAttribute("useraddress");
			
			String username = (String) req.getParameter("username");
			String useraddress = (String) req.getParameter("useraddress");
			log.info("1. username: {}, useraddress: {}", username, useraddress);
			
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println(String.format("<h2> username: %s, useraddress: %s</h2>", username, useraddress));
			
			out.flush();
			
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class





