package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Data;

//VO: Read-Only
//DTO: Not read-only
//@ToString
//@EqualsAndHashCode
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor

@Data
public class EmpDTO {	//POJO
	
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private Double sal;
	private Double comm;
	private Integer deptno;
} //end class





