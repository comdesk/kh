package org.zerock.myapp.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String passwd;
	
} //end class
