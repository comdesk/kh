package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

@WebServlet("/EmpSelect")
public class EmpSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		log.trace("service(req, res) invoked.");
		
//		========================
//				응답 준비
//		========================
		res.setContentType("text/html; charset=utf8");
		res.setCharacterEncoding("utf8");
		
		@Cleanup
		PrintWriter out = res.getWriter();

		
//		========================
//				JDBC 연동
//		========================
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";
		String user = "SCOTT";
		String pass = "Oracle12345678";
		
		
		try {
			//WAS 안에는, JVM의 표준 Class Loader를 대체하는, Change-aware Class Loader가 구현되어 있음.
			//때문에, WAS 안에서는 JDBC Driver Class를 직접 로딩해야 함.(생략 불가!!)
			Class.forName(jdbcDriver);
			
			@Cleanup
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass); 	//Connection 생성
			log.info("\t+ conn: " + conn);
			
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
