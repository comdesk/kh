package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/Sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			//=====1. 요청처리=====
	//		더 이상 GET/POST 방식의 한글 전송파라미터에 대한 인코딩 설정은 필요없음
	//		Tomcat WAS의 설정으로 WAS에서 처리함(하지만, 잊지는 말기!!)
	//		req.setCharacterEncoding("utf8");
			
			String[] sports = req.getParameterValues("sports");	//다중값 전송 파라미터
			String gender = req.getParameter("sex");				//단일값 전송 파라미터
			
			log.info("1. sports: {}", Arrays.toString(sports));
			log.info("2. gender: {}", gender);
			
			//=====2. 응답처리=====
			res.setContentType("text/html; charset=utf-8");
			res.setCharacterEncoding("utf8");
			PrintWriter out = res.getWriter();
			
			try(out) {
				out.print("<html><body>");
				
				for(String sport : sports) {
					out.print("좋아하는 운동: " + sport + "<br>");
				} //enhanced for
				
				out.print("성별: " + gender + "<br>");
				out.print("</body></html>");
				
				out.flush();
			} //try-with-resources
		} catch(Exception e) {
			throw new ServletException(e);	//어떠한 예외가 발생하더라도, 규약대로 ServletException으로 wrapping해서 던짐.
		} //try-with
	} //service

} //end class







