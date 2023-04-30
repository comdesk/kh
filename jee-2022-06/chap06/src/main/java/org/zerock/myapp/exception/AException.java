package org.zerock.myapp.exception;


//비즈니스 예외
public class AException extends Exception {
	
	private static final long serialVersionUID = 1l;
	
	
	public AException(String message) {
		super(message);
	} //Constructor #1
	
	public AException(Exception e) {
		super(e);
	} //Constructor#2
} //end class
