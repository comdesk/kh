package temp5;

public class BreakExample {
	
	//주사위를 던져서, 6이라는 눈이 나오면, 프로그램 종료.
	public static void main(String[] args) {
		
		TTT: while(true) {	//무한루프
			int num = (int)(Math.random() * 6) + 1;	//주사위 던진다!
			System.out.println(num);				//주사위 눈 출력
			
			//무한루프의 "탈출 조건"
			if(num == 6) {	//만일 주사위 눈이 6이 나오면
				break TTT;		//반복문을 깨뜨리고 나오라!(주의: 조건문을 깨뜨리고 나오는 게 아님.)
			} //if
		} //while
		
		System.out.println("프로그램 종료");
		
//		================================
		
		Outter: //Label 붙임(바깥쪽 반복문에), 왼쪽이 아니라 위에 붙여도 됨.
		for(char upper = 'A'; upper <= 'Z'; upper++) {	//아스키코드에 있는 정수값, 'A'~'Z'까지 반복
			
			for(char lower = 'a'; lower <= 'z'; lower++) {	//'a'~'z'까지 반복
				System.out.println(upper + "-" + lower);
						
				if(lower =='g') {	//소문자 'g'일 때, 안쪽/바깥쪽 반복문 깨뜨림.
					break Outter;	//Label과 함께 사용
				} //if
				
			} //안쪽 for
		} //바깥쪽 for
		//break문이 없었다면 24*24 반복
		
		System.out.println("프로그램 실행 종료");
		
//		=================================
		
		label:
		for(int j = 0; j < 3; j++) {
			System.out.println("j = " + j);
			
			for(int i = 1; i <= 10; i++) {
				//산술연산자가 비교연산자보다 우선순위가 높다.
				if(i % 2 != 0) {	//2의 배수가 아니라면, 홀수이면
					continue label;		//증감식으로 돌아가서 "계속" 수행하라!
				} //if
				
				System.out.println("i = " + i);
				
			} //in for
		} //out for
			
		
	} //main
} //end class





















