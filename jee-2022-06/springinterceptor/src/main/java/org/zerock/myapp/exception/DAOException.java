package org.zerock.myapp.exception;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DAOException(String message) {
		super(message);
	} //Constructor#1
	
	public DAOException(Exception originalException) {		//래핑용 생성자
		super(originalException);	//이걸 찍으면 caused by가 나옴.
	} //Constructor#1
} //end class
