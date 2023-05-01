package org.zerock.myapp.domain;

import java.io.Serializable;

import lombok.Data;


@Data
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer age;
	
	//채팅용
	private String nickName;
	private String message;
} //end class
