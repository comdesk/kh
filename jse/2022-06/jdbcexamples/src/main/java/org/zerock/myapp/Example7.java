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
public class Example7 {
	
	//Step.1 jdbcDriver 클래스의 이름을 DriverSpy가 제공하는 클래스로 변경
//	static final String jdbcDriver = "oracle.jdbc.OracleDriver";
	static final String jdbcDriver = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
	
	//Step.2 jdbcUrl에 "log4jdbc"라는 단어를 하나 더 아래와 같이 추가
//	static final String jdbcOracleCloudUrl = 
//			"jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";
	static final String jdbcOracleCloudUrl = 
			"jdbc:log4jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";
	
	static final String user = "HR";
	static final String passForCloud = "Oracle123456789";
	
	//핵심포인트: JDBC 프로그래밍 + DriverSpy 추가하여, 디버깅을 원활하게 하자
	public static void main(String[] args) {	
		
		ResultSet rs = null;

		String sql="""
				SELECT *
				FROM employees
				WHERE salary > ?
				""";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcOracleCloudUrl, user, passForCloud);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			try (conn; pstmt;) {
				
				log.info("1. conn: {}", conn);
				log.info("2. pstmt: {}", pstmt);
				
				pstmt.setDouble(1, 1000);
		
				rs = pstmt.executeQuery();
				log.info("3. rs: {}", rs);
		
				while(rs.next()) {
					int employeeId = rs.getInt("EMPLOYEE_ID");
					String firstName = rs.getString("FIRST_NAME");
					String lastName = rs.getString("LAST_NAME");
					Timestamp hireDate = rs.getTimestamp("HIRE_DATE");
					double salary = rs.getDouble("SALARY");
					
					log.info("employeeId: {}, firstName: {}, lastName: {}, hireDate: {}, salary: {}",
							employeeId, firstName, lastName, hireDate, salary);
				} // while
			
			} // try-with-resources
		} catch(SQLException e) {
			e.printStackTrace();
		} // try-catch
	} // main

} //end class





