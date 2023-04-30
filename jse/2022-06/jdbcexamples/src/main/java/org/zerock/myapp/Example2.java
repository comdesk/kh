package org.zerock.myapp;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Objects;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Example2 {
	
	// 1. JDBC 구동기(Driver) 역할을 하는 클래스의 FQCN을 알아야 한다.
	//	  하지만, 이미지 DB별로 정해져 있다. (아래는 Oracel JDBC Driver의 구동기 클래스)
//	static final String jdbcDriver = "oracle.jdbc.driver.OracleDriver";	취사선택
	static final String jdbcDriver = "oracle.jdbc.OracleDriver";
	
	// 2. JDBC url 설정(데이터베이스 위치 정하는 것) (EZCONNECT 방식의 url)
	static final String jdbcEZConnectUrl = "jdbc:oracle:thin:@DESKTOP-F3LHSOP:1521/XEPDB1";
	
	// 2. JDBC url 설정(TNSNAMES 방식)
	static final String jdbcTNSNamesUrl = "jdbc:oracle:thin:@XEPDB1";
	//TNS_ADMIN 시스템 환경변수가 없다면 뒤에 ?TNS_ADMIN="" 붙여줘야함.
	
	// 2. JDBC url 설정(Oracle Cloud 연결방식)
	static final String jdbcOracleCloudUrl = 
			"jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";	//경로구분자 / 써야함.
	// 이름을 발견할 수 있는 환경변수를 직접 지정함.
	
	// 3. 로그인(인증, Authentication) 정보 제공
	static final String user = "HR";
	static final String passForCloud = "Oracle123456789";
	static final String passForLocal = "oracle12345678";
	
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//Step.1 Oracle JDBC Driver Class Loading
	//		Class.forName(jdbcDriver);		//jdbcDriver가 사용할 수 있게 메소드영역에 끌어올림.
			//jdbc 4점대부터 이 작업 필요없어짐. 자동으로 끌어올림.
			
			//Step.2 Get A connection by using EZCONNECT
	//		conn = DriverManager.getConnection(jdbcEZConnectUrl, user, passForLocal);
	//		log.info("1. conn: {}", conn);
			
			//Step.2 Get A Conncection by Using TNSNAME
			conn = DriverManager.getConnection(jdbcTNSNamesUrl, user, passForLocal);
			log.info("1. conn: {}", conn);
			
			//Step.3 Get A Connection from Oracle Cloud by Using TNSNAMES
	//		conn = DriverManager.getConnection(jdbcOracleCloudUrl, user, passForCloud);
	//		log.info("1. conn: {}", conn);
			
			//Step.4 Statement 객체 생성 (용도: Dynamic SQL 문장을 생성)
			stmt = conn.createStatement();	//return type: Statement
			log.info("2. stmt: {}", stmt);
			
			//Step.5 수행시킬 SQL 문장을 문자열로 준비
			String sql = """
					SELECT *
					FROM employees
					WHERE salary > 1000		
					""";
			// dynamic sql
			
			//Step.6 준비된 Statement 객체와 SQL 문자열로 실제 SQL문장을 실행(Oracle Server로 던짐)
			rs = stmt.executeQuery(sql);	//쿼리: DQL
			log.info("3. rs: {}", rs);
			
			//Step.7 ResultSet 객체에 있는 모든행들을 추출
			while(rs.next()) {	//더 이상 추출할 행들이 없을 때까지 반복
				//추출된 각 행의 컬럼들의 값을 얻어낸다
				int empId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("LAST_NAME");
				Timestamp hireDate = rs.getTimestamp("HIRE_DATE");
				double salary = rs.getDouble("salary");
				
				log.info("empId: {}, firstName: {}, lastName: {}, hireDate: {}, salary: {}"
						,empId, firstName, lastName, hireDate, salary);
						
			} //while
			
			//닫는 방법
			assert rs != null;				//1st. method 오류나면 Error가 떨어짐. null이 아니면 무사통과.
			Objects.requireNonNull(rs);		//2nd. method
//			if(rs != null)		//3rd. method 
	//		assertNotNull(rs); //4th. method(단, JUnit Test Framework에 속한 메소드)이거 왜 하는데  테스트 할 때만 쓸 수 있는 라이브러리
						
					
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) {;;}	//자원객체 닫을 때 오류나는 걸 뭘 해줄 수 없어서 비워놓음.
			try { if(stmt != null) stmt.close(); } catch (SQLException e) {;;}
			try { if(conn != null) conn.close(); } catch (SQLException e) {;;}	//여는 순서와 반대로 닫음.
		} //try-catch-finally
		
		
	} //main

} //end class





