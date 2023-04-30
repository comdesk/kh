package temp2;

public class IfElseIfElseExample {
	public static void main(String[] args) {
		int score = 75;
		
		//다중 if 조건문 => 판정할 조건식이 2개 이상일 때 사용
		if(score >= 90) {			//if 블록
			System.out.println("점수가 100~90입니다.");
			System.out.println("등급은 A입니다.");
		} else if(score >= 80) {	//else if 블록: 다음 조건식을 구성하는 블록
			System.out.println("점수가 80~89입니다.");
			System.out.println("등급은 B입니다.");
		} else if(score >= 70) {	//else if 블록: 다음 조건식을 구성하는 블록
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C입니다.");
		} /*else { 					//else 블록: 위의 모든 조건식이 모두 false일 때 수행
			System.out.println("점수가 70 미만입니다."); 
			System.out.println("등급은 D입니다."); 
		}*/ //if-else if-else
	} //main
} //end class
