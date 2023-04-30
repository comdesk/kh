package temp;

public class LogicalOperatorExample {
	
	//논리연산자의 활용: 보통 비교연산자와 논리연산자가 함께 사용되어
	//					 소위 '조건문/조건식'을 작성하게 된다.
	public static void main(String[] args) {
		int charCode = 'A';		//??? 문자를 저장하는 타입은 char인데... 
		//문자는 문자에 할당되어 있는 코드 값이 들어간다. 
		//int는 문자를 보관하는 게 아니라 65라는 정수를 보관함.
		
		//'>=', '<=': 비교연산자 =>boolean, '()': 우선순위연산자(사실 연산자는 아님), '&': 논리연산자(AND) => 조건식을 이어주거나 부정
		if( 
			( charCode >= 65 ) 	//첫 번째 조건식
			
			& 					//그리고(AND)
			
			( charCode <= 90 ) 	//두 번째 조건식
		
		) {
			System.out.println("대문자이군요.");
		} //if
		
//		=======================
		//비교연산자와 그 수행결과 타입에 대해 확인
		
//		boolean result = 1 > 0;		//비교연산자: '>'
//		boolean result = 1 < 0;		//비교연산자: '<'
//		boolean result = 1 >= 0;	//비교연산자: '>='
//		boolean result = 1 <= 0;	//비교연산자: '<='
//		boolean result = 1 == 0;	//비교연산자: '==' (동등비교연산자)  =은 대입연산자
//		boolean result = ( 1 != 0 );	//비교연산자: '!=' (동등비교연산자) =>소괄호로 코드 상의 모호성 해결
		
		//논리연산자: 
		//	(1) AND(그리고, & &&) -이항 => 둘 다 참이어야 참.
		//	(2) OR(또는, | ||) - 이항 => 둘 중 하나만 참이어도 참.
		//	(3) NOT(부정, !) - 단항
		
//		boolean result = (100 > 0) & (10 > 30);	// 논리곱  피연산자로 비교식이 나와도 됨.
		
		//&&: Short Circuiting 효과를 발생시킴. (첫 번째 항에서 false가 나오면(논리연산자 결과가 결정됐으면) 두 번째 항은 굳이 실행x => 자원 절약)
//		boolean result = (10 > 30) && (100 > 0);
		
//		boolean result = (100 > 0) | (10 > 30); // 논리합	//무조건 두 항 다 따져봄.
		
		//&&: Short Circuiting 효과를 발생시킴.
//		boolean result = (100 > 0) || (10 > 30);	//하나라도 참이면 참	
		boolean result = (10 > 30) || (100 > 0);	//첫 번째 항에 의해서 결론이 안 나면 쇼트서키팅이 일어나지 않고 두 번째 항 따짐.
		
//		boolean result = !true;
//		boolean result = !(100 > 0);
//		boolean result = !(100 < 0);
		
//		boolean result = !10;	//부정연산자는 boolean타입에만 적용 가능.
		
		System.out.println(result);
		
	} //main
} //end class





















