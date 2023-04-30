package org.zerock.myapp;

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

@WebServlet("/A")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service({}, {}) invoked.", req, res);
		
		//Request Scope에 공유데이터를 속성바인딩 수행
		req.setAttribute("_A_", "A");
		
//						  (위임자)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/B");
		dispatcher.forward(req, res);
	} //service

} //end class





