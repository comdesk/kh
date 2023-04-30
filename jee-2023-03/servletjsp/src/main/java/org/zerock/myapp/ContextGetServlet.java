package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletConfig;
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

@WebServlet("/ContextGet")
public class ContextGetServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.trace("service(req,res) invoked.");
				
		try {
//			Step.1 To get Attribute from the Application Scope
			
			ServletContext sc = this.getServletContext();
			ServletConfig config = this.getServletConfig();
			
			log.info("\t+sc: {}, config: {}", sc, config);
			
			Objects.requireNonNull(sc);
			Objects.requireNonNull(config);
			
			String servletName = this.getServletName();
			String servletInfo = this.getServletInfo();
			String contextPath = sc.getContextPath();
			
			log.info("\t+servletName: {}, servletInfo: {}, contextPath: {}", servletName, servletInfo, contextPath);
			
			//Applicaition Scope에 공유된 2개의 속성값을 획득
			String name = (String) sc.getAttribute("name");
			int age = (int) sc.getAttribute("age");	//Auto-Unboxing: INteger -> int
			
			log.info("\t+name: {}, age:{}", name, age);
			
			//Application Scope에 공유된 2개의 속성값을 삭제
			sc.removeAttribute("name");
			sc.removeAttribute("age");
			
//			Step.2 Ready and Go HTTP response
					
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<h3>contextPath: " + contextPath + "</h3>");
			out.println("<h3>contextPath: " + servletName + "</h3>");
			out.println("<h3>contextPath: " + servletInfo + "</h3>");
			
			out.println("<h3>name: " + name + "</h3>");
			out.println("<h3>age: " + age + "</h3>");
			
			out.flush();
			
			
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service
} //end class






