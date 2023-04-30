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
public class Example3 {
	
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

//		Statement stmt = null;					// for dynamic SQL
//		PreparedStatement pstmt = null;			// for prepared SQL
		ResultSet rs = null;
		
		//Step.1 수행시킬 SQL 문장을 문자열로 준비
		String sql = """
				SELECT *
				FROM employees
				-- ? = Bind Variable
				WHERE salary > ?	
				""";
		// prepared sql
		
		try (	//JAVA 7 
				//Step.2 Get A Connection by Using TNSNAME
				Connection conn = DriverManager.getConnection(jdbcTNSNamesUrl, user, passForLocal);
				//Step.3 Statement 객체 생성 (용도: Prepared SQL 문장을 생성)
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				log.info("1. conn: {}", conn);	
				log.info("2. pstmt: {}", pstmt);
				
				//Step.4 준비된 SQL 문장의 바인드변수(Bind Variables)에 값을 설정
				pstmt.setDouble(1, 1000);
				
//				//Step.5 준비된 PreparedStatement 객체로 실제 SQL문장을 실행(Oracle Server로 던짐)
				rs = pstmt.executeQuery();	//쿼리: DQL		//매개변수 없는 메소드
				log.info("3. rs: {}", rs);
//			
//				//Step.7 ResultSet 객체에 있는 모든행들을 추출
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
					
		} catch(SQLException e) {
			e.printStackTrace();
		} //try-catch
		
	} //main

} //end class





