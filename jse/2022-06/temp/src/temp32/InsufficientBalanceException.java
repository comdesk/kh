package temp32;


//사용자 정의 Runtime Exception
//잔고 부족 실행 예외(평소엔 몰랐다가 실행 중에만 잔고 부족을 알 수 있으므로)
public class InsufficientBalanceException 
	extends RuntimeException {	//RuntimeException 상속
	
	public InsufficientBalanceException() {	//기본 생성자(오류메시지 없는 예외)
		super();
	} //default constructor
	
	public InsufficientBalanceException(String message) {	//오류메시지를 보여주는 생성자
		super(message);
	} //constructor
	
} //end class
