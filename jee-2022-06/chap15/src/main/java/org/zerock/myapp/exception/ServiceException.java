package org.zerock.myapp.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServiceException(String message) {
		super(message);
	} //Constructor#1
	
	public ServiceException(Exception originalException) {		//래핑용 생성자
		super(originalException);	//이걸 찍으면 caused by가 나옴.
	} //Constructor#1
} //end class
