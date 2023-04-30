package temp9;

public class EnumMethodExample {
	
	//열거 타입에 선언된 각각의 열거 상수는 바로 힙에 생성되는 객체이다.
	//객체란, 속성과 행위(기능, 메소드)를 가진다.
	//본 예제는, 열거 타입에서 사용 가능한 행위(기능, 메소드)를 알아보는 예제.
	public static void main(String[] args) {
		
		Week today = Week.SUNDAY;	//열거 타입의 변수 선언 및 열거 상수로 초기화
		//열거 상수 SUNDAY는 Week타입의 객체
		//Week 타입의 변수 today에는 열거 상수의 참조가 들어있음. => 참조 타입
		
		//참조타입변수명.메소드()에서, 이 '.'(dot)은 "연산자"이다.
		//이 연산자의 정확한 이름은 "객체멤버(속성, 행위)참조(사용한다)연산자"라고 한다.
		//즉 아래 실행문장은 today 열거타입객체의 name이란 메소드(객체의 멤버)를 실행시키고 있다.
		
		//today 변수 안에 담긴 SUNDAY는 객체이기 때문에 name() 메소드를 호출할 수 있는 것임.
		String name = today.name();	//name() 메소드(객체의 행위, 기능) 수행. 열거 상수의 이름을 String타입으로 돌려줌.
		System.out.println(name);	//과연 name() 메소드의 결과는 무엇이 출력될까. => SUNDAY 열거 상수의 이름 출력
		System.out.println(today);	//SUNDAY	
		
//		---------------------------
		
		//2. ordinal() 메소드
		int ordinal = today.ordinal();	//몇 번째로 선언된 열거 상수인가.
		System.out.println(ordinal);	//6 => 열거 상수의 순서는 0부터 시작.
		
//		---------------------------
		
		//3. compareTo() 메소드
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
					 //기준          비교
					 //----          ----
		int result1 = day1.compareTo(day2);		//같은 요일인가 아닌가 비교
		int result2 = day2.compareTo(day1);		//열거타입에서 정의된 순서를 비교
		int result3 = day2.compareTo(day2);
		
		System.out.println(">> day1: " + day1.ordinal());
		System.out.println(">> day2: " + day2.ordinal());
		
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
		
//		---------------------------
		
		//valueOf() 메소드: 열거 상수와 동일한 문자열을 진짜 열거상수로 바꿔 준다.
		//입력하는 모든 것은 문자열이므로 입력한 문자열을 우리가 원하는 타입으로 바꿀 수 있게 해줌.
		Week weekDay = Week.valueOf("SUNDAY");	//문자열을 열거 상수로 만들어줌.(열거타입에 열거 상수로 선언한 것만 가능)
		
		if((weekDay == Week.SATURDAY) || (weekDay == Week.SUNDAY)) {	//두 객체의 주소를 비교
			System.out.println("주말이군요");
		} else {
			System.out.println("평일이군요");
		} //if-else
		
//		-------------------------
		
		if(args.length == 1) {
			String strDay = args[0];	//***: 프로그램 전달인자를 이용하여,
										//	   변수의 초기값으로 문자열 전달
			Week weekDay2 = Week.valueOf(strDay);
			
			if((weekDay2 == Week.SATURDAY) || (weekDay2 == Week.SUNDAY)) {
				System.out.println("주말이군요");
			} else {
				System.out.println("평일이군요");
			} //if-else
		} //if
		
//		-------------------------
		
		//values() 메소드
		Week[] days = Week.values();	//열거 타입에 선언된 모든 열거상수를 배열로 반환
										//열거 상수는 자신이 선언된 열거 타입이 타입임.
		
		for(Week day : days) {
			System.out.println(day);
		} //enhanced for
		
	} //main
} //end class












