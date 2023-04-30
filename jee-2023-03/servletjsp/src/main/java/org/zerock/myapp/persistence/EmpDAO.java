package org.zerock.myapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.zerock.myapp.domain.EmpDTO;
import org.zerock.myapp.domain.EmpVO;

import lombok.Cleanup;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2
//@NoArgsConstructor
public class EmpDAO {	//POJO
	
//	@Resource(name="jdbc/OracleCloudATPWithDriverSpy")
	private DataSource dataSource;
	
	//JNDI Tree 에서, 공유된 데이터소스 자원을 이름으로 찾아내어 필드에 저장
	public EmpDAO() throws NamingException {
		log.trace("Default constructor invoked.");
		
		String prefix = "java:comp/env/";
		String name = "jdbc/OracleCloudATPWithDriverSpy";
		
		//Step.1 JNDI tree에 접근하게 해주는 Context 객체를 생성
		Context ctx = new InitialContext();
		log.info("\t+ ctx: {}", ctx);
		
		//STep.2 JNDI tree를 지정된이름으로 공유자원 검색(JNDI tree)
		Object obj = ctx.lookup(prefix + name);
		log.info("\t+ obj: {}", obj);
		
		Objects.requireNonNull(obj);
//		assert obj != Null;
		this.dataSource = (DataSource) obj;	
	} //default Constructor
	
	//1. 전체사원을 조회하여 리스트로 반환(순서보장 필요)
	public List<EmpVO> selectAll() throws SQLException {
		log.trace("selectAll() invoked.");
		
		final String sql = "SELECT * FROM emp_2";
		
		@Cleanup Connection conn = this.dataSource.getConnection();
		
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		
		@Cleanup ResultSet rs = pstmt.executeQuery();
		
		List<EmpVO> list = new ArrayList<>();	//결과셋까지 얻어냈으니 성공했으니까 리스트 생성
		
		while(rs.next()) {
			Integer empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			Integer mgr = rs.getInt("mgr");
			Date hireDate = rs.getDate("hiredate");
			Double sal = rs.getDouble("sal");
			Double comm = rs.getDouble("comm");
			Integer deptno = rs.getInt("deptno");
			
			EmpVO vo = new EmpVO(empno, ename, job, mgr, hireDate, sal, comm, deptno );
			
			list.add(vo);
		} //while
		return list;
	} //selectAll
	
	//2. 특정 사원 정보를 조회하여 반환
	public EmpVO select(EmpDTO dto) throws SQLException {
		log.trace("select({}) invoked.", dto);
		
		final String sql = "SELECT * FROM emp_2 WHERE empno = ?";
		
		@Cleanup Connection conn = this.dataSource.getConnection();
		
		@Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getEmpno());
		
		@Cleanup ResultSet rs = pstmt.executeQuery();
	
		if(rs.next()) {
			Integer empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			Integer mgr = rs.getInt("mgr");
			Date hireDate = rs.getDate("hiredate");
			Double sal = rs.getDouble("sal");
			Double comm = rs.getDouble("comm");
			Integer deptno = rs.getInt("deptno");
			
			EmpVO vo = new EmpVO(empno, ename, job, mgr, hireDate, sal, comm, deptno );
			
			return vo;
		} else {
			return null;
		} //if-else
	} //select
} //end class









