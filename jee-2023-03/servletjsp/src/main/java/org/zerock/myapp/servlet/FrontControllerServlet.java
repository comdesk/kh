package org.zerock.myapp.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.service.DeleteService;
import org.zerock.myapp.service.InsertService;
import org.zerock.myapp.service.SelectService;
import org.zerock.myapp.service.UnknownService;
import org.zerock.myapp.service.UpdateService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		log.trace("service(req, res) invoked.");
		
		try {
			//약속된 요청식별자: /select.do, /insert.do, /update.do, /delete.do
			String requestURI = req.getRequestURI();
//			String requestURL = req.getRequestURL().toString();		
//			String contextPath = req.getContextPath();
			
			//ex) URI: "/a/b/c/insert1.do"; => "/insert1.do" (command)
//			String command = requestURI.substring(requestURI.lastIndexOf("/"));
			
			String command = "";
			String regex = "/[a-zA-z0-9]+.do$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(requestURI);
			if(m.find()) {
				command = m.group();
			} //if
			
//			log.info("\t1. requestURL: {}", requestURL);
			log.info("\t0. requestURI: {}", requestURI);
//			log.info("\t3. contextPath: {}", contextPath);
			log.info("\t1. command: {}", command);
			
//			-------------------------------------
//			Command Pattern 적용: 수신한 요청을  식별하고, 식별된 요청을 비즈니스 계층의
//								  서비스 객체(XXXService.java)에 처리를 위임(Delegation)함.
//			-------------------------------------
			switch(command) {	//(1) 요청을 식별하고, (2) 식별된 요청을 처리할 서비스에 위임
				case "/insert.do": new InsertService().process(req, res); break;
				case "/update.do": new UpdateService().process(req, res); break;
				case "/delete.do": new DeleteService().process(req, res); break;
				case "/select.do": new SelectService().process(req, res); break;
				default: new UnknownService().process(req, res);
			} //switch
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class





