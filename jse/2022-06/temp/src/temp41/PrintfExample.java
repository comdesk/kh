package temp41;

import java.util.Date;

public class PrintfExample {
	//핵심포인트: PrintStream/PrintWriter 보조스트림이 제공하는 메소드
	public static void main(String[] args) {
		//System.out => 표준 출력(PrintStream)
		System.out.printf("상품가격:%d원\n", 123);		//%d: 십진수
		System.out.printf("상품가격:%6d원\n", 123);		//6자리, 오른쪽 정렬
		System.out.printf("상품가격:%-6d원\n", 123);	//6자리, 왼쪽 정렬
		System.out.printf("상품가격:%06d원\n", 123);
		
		System.out.printf("반지름이 %d인 원의 넓이: %10.2f\n", 10, Math.PI*10*10);
		
		System.out.printf("%6d | %-10s | %10s\n", 1, "홍길동", "도적");
		
		//날짜와 시간정보를 가지고 있는 달력객체(즉, 달력을 모델링해서 만든 클래스)
		Date now = new Date();	//생성자 많이 없어짐
		
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다.\n", now, now, now);
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일 입니다.\n", now);
		System.out.printf("현재 %1$tH시 %1$tM분 %1$tS초 입니다.\n", now);
	} //main
} //end class

