package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

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

@WebServlet("/EmpInsert")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/OracleCloudATPWithDriverSpy")
	private DataSource dataSource;
	
	private final String sql = "INSERT INTO emp_2 (empno, ename, sal, deptno) VALUES(?, ?, ?, ?)";
	
//	@PostConstruct
//	void postConstruct() {
////		Objects.requireNonNull(this.dataSource);
//		assert this.dataSource != null;
//	} //postConstruct
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
//			Objects.requireNonNull(this.dataSource);
			assert this.dataSource != null;
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //init
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			//1. 전송파라미터 추출
			String empId = req.getParameter("emp_id");
			String ename = req.getParameter("ename");
			String salary = req.getParameter("salary");
			String depart = req.getParameter("depart");
			
//			if(empId == null) throw new Exception("empId is Null");
//			if(ename == null) throw new Exception("ename is Null");
//			if(salary == null) throw new Exception("salary is Null");
//			if(depart == null) throw new Exception("depart is Null");	//유효성검사

			Objects.requireNonNull(empId);
			Objects.requireNonNull(ename);
			Objects.requireNonNull(salary);
			Objects.requireNonNull(depart);
			
			//2. SCOTT.emp 테이블에 INSERT 수행
			@Cleanup
			Connection conn = this.dataSource.getConnection();
			
			@Cleanup
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(empId));	//문자열로 들어온 걸 스키마대로 number타입으로 바꿔줌.
			pstmt.setString(2, ename);	
			pstmt.setDouble(3, Double.parseDouble(salary));	
			pstmt.setInt(4, Integer.parseInt(depart));	
			
			
			int afftedLines = pstmt.executeUpdate();
			log.info("\t+ affectedLines: {}", afftedLines);
			
			//3. 응답메시지 생성 및 전송
			res.setCharacterEncoding("utf8");
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<h1> AffectedLines:" + afftedLines + "</h1>");
			
			out.flush();
			
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch
	} //service



} //end class
