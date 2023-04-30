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
public class Example5 {

	static final String jdbcDriver = "oracle.jdbc.OracleDriver";
	static final String jdbcTNSNamesUrl = "jdbc:oracle:thin:@XEPDB1";
	static final String jdbcOracleCloudUrl = 
			"jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";

	static final String user = "HR";
	static final String passForCloud = "Oracle123456789";
	static final String passForLocal = "oracle12345678";
	
	
	public static void main(String[] args) {
		String sql = """
				DELETE FROM employees
				WHERE employee_id = ?
				""";
				
		try {
			Connection conn = DriverManager.getConnection(jdbcTNSNamesUrl, user, passForLocal); 
			
				try(conn;) {
				
				conn.setAutoCommit(false); 	//TX 시작	//sql문장을 실행시키기 전에 꺼야 함.(커넥션 객체를 얻자마자)
				
				try {
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
						
					try (pstmt;) {
						
		//				=======================================================================
		//				* 아래 코드는 Local Transaction (Local TX) <-> Global(=Distributed) TX
		//				=======================================================================
										
						pstmt.setInt(1, 112);		//Number(6)
						pstmt.executeUpdate();		//DML, DDL, DCL
						
						//TCL - Connect 인터페이스의 추상메소드로 선언되어 있다.
						conn.commit();			//TX 종료지점 (if Success)
		//				===============================================================
					}// try-with-resources
				} catch (SQLException e) {
					conn.rollback();  			//TX 종료지점(if Failed) 
				} //try-catch
			} //Try-with resources
		} catch(SQLException e) {
			e.printStackTrace();
		} //try-catch
		
	} //main

} //end class





