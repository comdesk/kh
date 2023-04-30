package temp32;


//사용자 정의 Checked Exception
public class UserDefinedCheckedException 
	extends Exception {		//Exception 상속
	
	public UserDefinedCheckedException() {	//기본 생성자
		super();
	} //default constructor
	
	public UserDefinedCheckedException(String message) {	//오류메시지를 보여주는 생성자
		super(message);		//Exception이 stack trace 찍어줌
	} //constructor
} //end class
