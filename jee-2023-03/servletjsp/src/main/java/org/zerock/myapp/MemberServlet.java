package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

@WebServlet("/Member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			Enumeration<String> enu = req.getParameterNames();
			
			res.setContentType("text/html; charset=utf8");
			res.setCharacterEncoding("utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();

			out.println("<html><body>");
			
			out.println("<ul>");
			while(enu.hasMoreElements()) {
				String paramName = enu.nextElement();//전송파라미터명 획득(값은 아직 못 얻음)
				String paramValue = req.getParameter(paramName);
				log.info("name: {}, value: {}", paramName, paramValue);
				String param = 
						String.format("<li>name: %s, value: %s</li>", paramName, paramValue);
				out.println(param);
			} //while
			out.println("</ul>");
			out.println("</body></html>");
			
			out.flush();
			
		} catch (Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class






