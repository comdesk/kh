package org.zerock.myapp;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/ContextParam")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		log.trace("init(config) invoked.");
		
		try {
			ServletContext ctx = config.getServletContext();
//			ServletContext ctx = super.getServletContext();	//GenericServlet이 상속한 메소드 XX
			
			Objects.requireNonNull(ctx);
			log.info("\t1. ctx:{}", ctx);
			
			String driver = ctx.getInitParameter("driver");
			String savePath = ctx.getInitParameter("savePath");
			
			log.info("\t2. driver({}), savePath({})", driver, savePath);
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
		
	} //init

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
//			//GenericServlet이 상속한 메소드
////			ServletContext ctx = this.getServletContext();		//XX
////			ServletContext ctx = super.getServletContext();		//XX
//			ServletContext ctx = getServletContext();				//XX
//			
//			Objects.requireNonNull(ctx);
//			log.info("\t3. ctx:{}", ctx);
		} catch(Exception e ) {
			throw new ServletException(e);
		} //try-catch
	}
} //end class





