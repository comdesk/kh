package org.zerock.myapp.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

//Spring Framework도 함께 구동
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HikariDataSourceBeanTests {

	@Setter(onMethod_= @Autowired)
	private DataSource dataSource;	//의존성 주입
	
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoke.");
		
		assertNotNull(this.dataSource);
		log.info("\t+ this.dataSource: {}", this.dataSource);
	} //beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("Test1: To get a JDBC Connection from the DataSource")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testGetConnection() throws SQLException {
		log.trace("testGetConnection() invoked.");
		
		@Cleanup
		Connection conn = this.dataSource.getConnection();
		
		Objects.requireNonNull(conn);
		log.info("\t+ conn: {}", conn);
	} //testGetConnection
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("Test2: To test a SQL using the connection.")
	@Timeout(value=4, unit=TimeUnit.SECONDS)
	void testSQL() throws SQLException {
		log.trace("testSQL() invoked.");
		
		@Cleanup
		Connection conn = this.dataSource.getConnection();
		@Cleanup
		Statement stmt = conn.createStatement();
		@Cleanup
		ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
		
		while(rs.next()) {
			String employee_id = rs.getString("employee_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String email = rs.getString("email");
			String phoneNo = rs.getString("phone_number");
			String hireDt = rs.getString("hire_date");
			String jobId = rs.getString("job_id");
			String sal = rs.getString("salary");
			String commPct = rs.getString("commission_pct");
			String deptId = rs.getString("department_id");
			
			log.info("({},{},{},{},{},{},{},{},{},{})", 
					   employee_id, first_name, last_name, email, phoneNo, hireDt, jobId, sal, commPct, deptId);
		} // while
		
	} //testSQL
} //end class










