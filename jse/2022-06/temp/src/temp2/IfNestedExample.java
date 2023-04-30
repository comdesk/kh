package temp2;

public class IfNestedExample {
	
	//제어문의 중첩(Nested): 제어문 블록 안에, 또 다른 제어문이 나온다.
	//중첩의 깊이(Depth)의 제약은 없다.
	//*주의*: 중첩의 깊이가 3 depth 이상 나오면 ,무언가 대단히 코드가 잘못되어 가고 있다.
	//		  => 알고리즘 문제 or 개발자의 실력 부족
	public static void main(String[] args) {
		int score = (int) (Math.random()*20) + 81;	//무작위로 임의의 정수값 만듦. 20~81
		System.out.println("점수: " + score);
		
		String grade;
		
		if(score >= 90) {
			
			//중첩된(Nested) if-else문
			if(score >= 95) {
				grade = "A+";
			} else {
				grade = "A";
			} //Inner if-else	바깥쪽의 범위를 선정하고 그 범위를 세분화시키고 싶을 때, elseif문 써도 됨.
		} else {
			
			//중첩된(Nested) if-else문
			if(score >= 85) {
				grade = "B+";
			} else {
				grade = "B";
			} //Inner if-else
			
		}//Outer if-else
		
		System.out.println("학점: " + grade);
		
	} //main
} //end class










