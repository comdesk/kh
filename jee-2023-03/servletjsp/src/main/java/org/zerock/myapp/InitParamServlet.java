package org.zerock.myapp;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

//@WebServlet(
//		urlPatterns = { "/InitParam" }, 
//		initParams = { 
//				@WebInitParam(name = "dirPath", value = "C:/temp", description = "Test Description"), 
//				@WebInitParam(name = "userid", value = "pyramide", description = "Test2 Description")
//		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		log.trace("init({}) invoked.", config);
		
		try {
			Objects.requireNonNull(config);
			
			String dirPath = config.getInitParameter("dirPath");
			String userid = config.getInitParameter("userid");
			
			log.info("1. dirPath({}), userid({})", dirPath, userid);
			
			Enumeration<String> enu = config.getInitParameterNames();
			
			while(enu.hasMoreElements()) {
				String paramName = enu.nextElement();
				String paramValue = config.getInitParameter(paramName);
				
				log.info("2. pramName({}), paramValue({})", paramName, paramValue);
			} //while
			
		} catch(Exception e) {
			throw new ServletException(e);
		}	//try-catch
	}	//init

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			;;
		} catch(Exception e) {
			throw new ServletException(e);
		}	//try-catch
	}	//service

} //end class







