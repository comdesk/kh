package org.zerock.myapp.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {	//오류메시지
		super(message);
	} //constructor1
	
	public BusinessException(Exception e) {		//다른 예외를 래핑할 수 있는 생성자
		super(e);
	} //constructor2
} //end class
