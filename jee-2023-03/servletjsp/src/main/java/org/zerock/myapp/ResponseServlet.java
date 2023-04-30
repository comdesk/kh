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

@NoArgsConstructor
@Log4j2

//@WebServlet("/Response")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		log.trace("service(req, res) invoked.");
		
//		===========응답처리===========
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("utf8");
		
		try (PrintWriter out = res.getWriter();) {
			String result = """
					<html>
					<body>
						ResponseServlet 요청성공
					</body>
					<html>
					""";
			out.print(result);
			
			out.flush();
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class
