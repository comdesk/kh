package temp13;

public class Car {
	//1. 필드
	int gas;
	
	
	//2. 생성자
	
	//3. 메소드
	void setGas(int gas) {
		this.gas = gas;
	} //setGas
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			
			return false;
		}
		
		System.out.println("gas가 있습니다.");
		
		return true;
	} //isLeftGas
	
	void run() {	//달려라.
		while(true) {	//무한루프 => 탈출조건 먼저 생각
			if(gas > 0) {
				System.out.println("달립니다.(gas잔량: " + gas + ")");
				gas -=1;
			} else {
				System.out.println("멈춥니다.(gas잔량: " + gas + ")");
				
//				return문의 2가지 역할:
				//* 중괄호 블록 내에서만 return문 사용 가능(예: 생성자, 메소드)
				//(1) 그 즉시 중괄호 블록을 끝내버림 => 즉, 생성자/메소드 실행종료
				//(2) 만일 return 키워드 뒤에 "표현식"이 있으면 , => 호출자에게 값 반환
				//	  여기서 호출자란, 생성자 또는 메소드의 호출자(실행시킨 자)
				return;	//그 즉시 메소드의 실행을 종료시킴
			} //if-else: 탈출조건
		} //while
	} //run
} //end class













