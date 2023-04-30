package org.zerock.myapp.domain;

import lombok.Value;

@Value
public class BoardVO {	//자바빈 클래스임.
	private Integer bno;
	private String title;
	private String content;
	private String writer;

} //end class
