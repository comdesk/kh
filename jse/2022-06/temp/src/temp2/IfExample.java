package temp2;

public class IfExample {
	
	//점수에 따라, 등급을 출력하는 예제, 물론 등급은 A,B만 고려
	public static void main(String[] args) {
		int score = 0;
		
		
		//위의 변수선언문과 그 다음의 실행문장 또는 제어문 사이는 공백 2개
		//행을 넣어준다.
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		} //if
		
		if(score < 90)	//중괄호 기호 생략 => 절대 생략하지 말라.
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		
		//조건에 따라 실행시킬 문장이 아예 하나도 없는 경우에는
		// 아래와 같이 바로 세미콜론(;)으로 마감 처리한다.
		if(score == 0);
		
//		==========================
		
		int scores = 85;
		
		
		//제어문에서 절대 중괄호 기호를 생략하지 말 것.
		if(scores >= 90) {	//조건식이 true일 때 수행되는 블록
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		} else {	//조건식이 false일 때 수행되는 블록
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		} //if-else
	} //main
} //end class













