package temp5;

public class SwitchExpression {
	
	//JAVA 14부터 표준기능으로 포함된 Switch Expression에 대해서 배우자
	public static void main(String[] args) {
		int value = 1000;
		
		//-- (1) 기존의 Switch문 복습
				
//		switch(value) {
//			case 100 : 
//			case 200 : 
//			case 300 : 
//			default  : System.out.println(value); break;	//어차피 case마다 동일한 문장이므로 fall through를 이용해 마지막 한 번 찍는다.
//		} //switch
		
		//-- (2) Switch Expression 문장을 써보자: 연습 #1
		switch(value) {
			//여러 개의 값과 일치하게 하려면, 쉼표(,)로 구분.
			case 100, 200, 300 -> {
				System.out.println(value);
				System.out.println(value);
				System.out.println(value);
			}
			
			//실행문장은 오른쪽 화살표 기호(->)를 우측에 기술한다.
			//실행문장이 0개 이상이라면, 중괄호({})로 블록을 구성하되,
			//가. 1개의 실행문장밖에 없다면, 중괄호 기호는 생략하라.***
			//나. 0개의 실행문장이라면, 중고라호 안에 Pass 키워드(;;)를 기술.
			case 400 -> System.out.println(value);	//실행문장 하나일 때 중괄호 기호 생략
			
			//생략가능(실행문장만 실행시키는 용도)
			default -> {
				;;		//Pass(비워 놓겠다/나중에 채우겠다)
			}
		} //switch expression
		
		//-- (3) Switch Expression 문장을 써보자: 연습 #2
		//		 값을 생성하는 표현식의 역할을 수행하자
		value = 100;
		boolean defaultValue = false;
	
		boolean result = switch(value) {
			case 100, 200 -> true;			//Literal OK
			case 300 	  -> false;			//Literal OK
			default 	  -> defaultValue;	//변수로 값을 생성해도 OK
		}; //switch expression
		
		System.out.println("result = " + result);
		
		//-- (3) Switch Expression 문장을 써보자: 연습 #3
		//		 값을 생성하는 표현식의 역할을 수행하자
		//       단, 생성할 값을 복잡한 연산식을 통해 생성하자.
		int intValue = 6;
		
		int result2 = switch(intValue) {
			case 4 -> {			//리터럴이 아닐 땐 중괄호
				//연산식을 통해, 값을 생성하려면, yield 키워드로 생성
				yield 4 * 4;	//4의 2승(지수승 계산)
			}
			
			//1개 밖에 없는, 값을 생성하는 실행문장 안에 yield 키워드가 있다면,
			//중괄호 기호를 생략할 때, yield 키워드까지 생략해야 한다.
			case 3 -> 3 * 3;
			
			case 5 -> 1000;
			
			case 6 -> intValue;
			//yield, 변수, 리터럴 혼용해서 사용 가능
			default -> {	//switch expression이 값을 생성하는 용도이기 때문에
							//생략 불가!
				yield intValue * intValue;
			}
		};	//switch expression
		
		System.out.println(result2);
		
		//(3) Switch Expression 문장을 써보자: 연습 #4
		//		 값을 생성하는 표현식의 역할을 수행하자
		//       단, Lvalue가 없는 경우
		String myName = "Pyramid";
		
		//switch expression이 값을 생성하는 용도로 사용되는데,
		//Lvalue의 변수가 준비되지 않으면(생략되면), Rvalue의
		//switch expression은 무조건 오류
		String s = switch(myName) {
//			case "Yes" 	   -> "Yes";		
			case "Trinity" -> { yield "1000";}//리터럴은 사실 yield가 생략된 것임. lvalue가 string이니까 string만 됨.
			//yield 키워드만이 값을 생성할 수 있음.
//			case "Trinity" -> "100";		//각 case의 값은 고유해야 한다.(Unique)
			case "Pyramid" -> {
				String firstName = "Yes";
				String lastName = "Kim";
				
				yield firstName + ", " + lastName;
			}
			default 	   -> { yield myName; }
		}; //switch expression
		
		System.out.println(s);
		
	} //main
} //end class













