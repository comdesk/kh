package temp9;

import java.util.Calendar;

public class EnumWeekExample {
	public static void main(String[] args) {
		Week today = null;		//열거타입인 Week 타입의 변수 선언(null로 초기화)
		
		//열거 상수를 사용시에는, 해당 열거 상수가 선언된 "열거타입명.열거상수명" 형태로
		//아래와 같이 사용 가능함. => 열거 상수의 소속을 밝혀줘야 함.
//		today = MONDAY;			//xx
//		today = Week.MONDAY;	//ok
//		today = Week.FRIDAY;	//ok
//		today = Week.SATURDAY;	//ok
//		today = Week.SUNDAY;	//ok
//		today = Week.THURSDAY;	//ok
//		today = Week.WEDNESDAY;	//ok
		
//		today = 1;				//XX: Week 열거 타입에 선언된 열거 상수가 아님.
//		today = "Hello";		//XX: Week 열거 타입에 선언된 열거 상수가 아님.
		
//		===============================
		
		//자바 표준라이브러리에 있는 것으로, "달력"을 만드는 클래스 이름이 아래의
		//"Calendar"이다.
		Calendar cal = Calendar.getInstance();		//"달력" 객체 생성
		int week = cal.get(Calendar.DAY_OF_WEEK);	//"달력"에서 오늘 요일 획득(숫자 상수로 반환)
		
		switch(week) {	//달력에서 얻은 오늘 요일이 무슨 요일이냐에 따라, 열거 상수로 초기화
			case 1: today = Week.SUNDAY;	break;
			case 2: today = Week.MONDAY;	break;
			case 3: today = Week.TUESDAY;	break;
			case 4: today = Week.WEDNESDAY;	break;
			case 5: today = Week.THURSDAY;	break;
			case 6: today = Week.FRIDAY;	break;
			case 7: today = Week.SATURDAY;	break;
		} // switch
		
		//과연 열거타입의 변수를 그대로 출력하면 무엇이 나올까.
		System.out.println("오늘 요일: " + today);		//FRIDAY
		//열거 상수는 객체인데 왜 열거 상수의 이름이 나오나.
		
		if(today == Week.SUNDAY) {	//오늘이 일요일이라면
			System.out.println("일요일에는 축구를 합니다.");
		} else {					//오늘이 일요일이 아니라면
			System.out.println("열심히 자바 공부합니다.");
		} //if-else
	} //main
	
} //end class














