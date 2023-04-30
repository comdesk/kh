package org.zerock.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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

@WebServlet("/ContextFile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String textFile = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		log.trace("init(config) invoked.");
		
		try {
			ServletContext ctx =  config.getServletContext();
			
//			Objects.requireNonNull(ctx);
			assert ctx != null;
			
			@Cleanup
			InputStream is = ctx.getResourceAsStream("/WEB-INF/testFile.txt");
			
			@Cleanup
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			StringBuffer sb = new StringBuffer();
			
			String line = null;
			while((line = br.readLine()) != null) {	//EOF = null
				sb.append(line).append("<br>");
			} //while
			
			this.textFile = sb.toString();
			
			log.info(textFile);
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //init

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
//			===응답처리===
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println(this.textFile);	
			out.flush();			
		} catch(Exception e) {
			throw new ServletException(e);
		}  //try-catch
	} //SERVICE

	

} //end class
