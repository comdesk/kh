package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Value;

//VO,DTO 필드의 타입은 반드시 참조 타입으로 할 것!
//이유는 테이블의 NULL값(=결측치)를 표현할 방법이 필요하기 때문.
//@EqualsAndHashCode
//@ToString
//@Getter
//@AllArgsConstructor

@Value
public class EmpVO {	//POJO
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private Double sal;
	private Double comm;
	private Integer deptno;
	
//	public EmpVO(
//			Integer empno, 
//			String ename, 
//			String job, 
//			Integer mgr, 
//			Date hireDate, 
//			Double sal,
//			Double comm, 
//			Integer deptno) {
//		this.empno = empno;
//		this.ename = ename;
//		this.job = job;
//		this.mgr = mgr;
//		this.hireDate = hireDate;
//		this.sal = sal;
//		this.comm = comm;
//		this.deptno = deptno;
//	} //constructor
//
//	//Getters
//	public Integer getEmpno() {
//		return this.empno;
//	} //empno
//
//	public String getEname() {
//		return this.ename;
//	} //ename
//
//	public String getJob() {
//		return this.job;
//	} //job
//
//	public Integer getMgr() {
//		return this.mgr;
//	} //mgr
//
//	public Date getHireDate() {
//		return this.hireDate;
//	} //hireDate
//
//	public Double getSal() {
//		return this.sal;
//	} //sal
//
//	public Double getComm() {
//		return this.comm;
//	} //comm
//
//	public Integer getDeptno() {
//		return this.deptno;
//	} //deptno
} //end class








