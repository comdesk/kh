package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/RequestRedirect")
public class RequestRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			//Request Scope에 공유속성 바인딩하는 것은 더 이상 의미 없음
			//(요청 위임으로, Re-direction 기법을 사용한다면..)
//			req.setAttribute("username", "Yoseph");
//			req.setAttribute("useraddress", "Canada");
			
			//Re-direction 응답을 보낼 때에, 아래의 target URI 뒤에,
			//Query String("요청 문자열") 형태로 전달할 데이털르 붙여줌.
			//그러면, GET 방식의 전송 파라미터 형태로 전달되는 것임.
			res.sendRedirect("/ResponseRedirect?username=Yoseph&useraddress=Canada");
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class






