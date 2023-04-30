package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.domain.EmpVO;
import org.zerock.myapp.persistence.EmpDAO;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/EmpSelectDAO")
public class EmpSelectDAOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDAO dao;


	@Override
	public void init(ServletConfig config) throws ServletException {	//오류가 발생하면 서블릿컨테이너가 알수 있도록 서블릿익셉션을 던져라.
		log.trace("init({}) invoked.", config);
		
		try {
			this.dao = new EmpDAO();
			log.info("\t+ this.dao: {}", this.dao);
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //init
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		log.trace("service(req, res) invoked.");
		
		try {
			//----------------------------------------//
			//Core Business Logic
			//----------------------------------------//
			
			@Cleanup("clear") List<EmpVO> employees = this.dao.selectAll();
			
			//----------------------------------------//
			//응답 문서 생성 및 전송 (MVC 패턴에서, View의 역할)
			//----------------------------------------//
			
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup PrintWriter out = res.getWriter();
			
			//전체 사원 정보를 적절한 모양으로 태그 구성
			out.println("<ol>");
			
			employees.forEach(vo -> out.println("<li>" + vo + "</li>"));	//.forEach	//vo는 list 객체 안의 요소 -> vo객체
			
			out.println("</ol>");
			out.flush();
			
			
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service

} //end class






