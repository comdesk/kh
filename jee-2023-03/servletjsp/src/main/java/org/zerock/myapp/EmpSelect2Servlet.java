package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebServlet("/EmpSelect2")
public class EmpSelect2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//JNDI lookup 과정을 통해, 지정한 이름을 가지고 있는 자원객체의 주소를 획득/주입
	@Resource(name="jdbc/OracleCloudATPWithDriverSpy")	//WAS 컨테이너 안에 생성된 자원객체를 얻는 어노테이션
	private DataSource dataSource;
		
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		log.trace("init({}) invoked.", config);
//		
//		try {
//			log.info("\t+ this.dataSource: {}", this.dataSource);
//			
////			Objects.requireNonNull(dataSource);
//			assert this.dataSource != null;
//			
//			Connection conn = this.dataSource.getConnection(); //풀에 있는 커넥션 하나를 꺼내다가 씀.
//			log.info("\t+ conn: {}", conn);
//		} catch(Exception e) {
//			throw new ServletException(e);
//		} //try-catch
//	} //init
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		log.trace("service(req, res) invoked.");
		
		res.setContentType("text/html; charset=utf8");
		res.setCharacterEncoding("utf8");
		
		@Cleanup
		PrintWriter out = res.getWriter();
		out.println("<html><head></head><body>");
		
		try {
			@Cleanup
			Connection conn = this.dataSource.getConnection();
			log.info("\t+ conn: {}", conn);
			
			String sql = "SELECT empno, ename, sal, deptno FROM emp";	//SQL 준비
			
			@Cleanup
			PreparedStatement pstmt = conn.prepareStatement(sql);	//Prepared SQL 준비			
			
			@Cleanup
			ResultSet rs = pstmt.executeQuery();	//SQL 수행
			while(rs.next()) {						//결과셋에서 데이터 추출
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String sal = rs.getString("sal");
				String deptno = rs.getString("deptno");
				
				//응답문서로 출력
				out.println(String.format("<p>%s\t%s\t%s\t%s</p>", empno, ename, sal, deptno));
			} //while

		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			out.println("</body><html>");
			out.flush();
		} //try-catch-finally		
	} //service


} //end class
