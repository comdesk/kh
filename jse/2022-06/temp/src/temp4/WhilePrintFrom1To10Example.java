package temp4;

public class WhilePrintFrom1To10Example {
	
	//1~10까지의 숫자를 차례로 출력하는 예제
	public static void main(String[] args) {
		int i = 1;	//(1) 루프제어변수(=카운터변수) 정의
		
		
//		while (i <= 10) {	//(2) 조건식: 반복할지 말지 결정
		
		//아래와 같이, 명시적으로 "무한루프"를 만드는 경우에는,
		//반드시 "탈출조건"을 준비하고 코딩해야 한다.
		
		int sayHelloCount = 0;
		
		boolean isExit = false;	//무한루프를 종료시킬지 말지 결정하는 소위 "플래그(flag)" 변수
		
//		while(true) {		//Infinite Loop
		while(!isExit) {	
			if(sayHelloCount == 10) {	//탈출조건 => 보통 가장 먼저 판정하게, 
										//나중에 넣으면 탈출조건일 때 실행하지 말아야 하는데 먼저 실행하고 
										//탈출조건을 따지게 되면 일단 실행하게 되니까.
//				break;					//이 문장으로도 탈출할 수 있지만
				isExit = true;			//실전에서는, 매끄러운 탈출이 되도록
										//플래그 변수를 많이 사용한다.
										//isExit가 true가 되어도 바로 while조건식으로 가서 빠져나가는 게 아니라 밑으로 내려가서 실행문장을 실행시키고 조건식으로 가게 됨.
				continue;				//밑으로 못내려가고 while에선 조건식으로 보내고 for에선 증감식으로 보낸다.
										//Skip 처리
			} //if
			
			System.out.println("Hello!");
			System.out.println(++sayHelloCount);
			
//			sayHelloCount++;	//헬로를 출력시켜야 증가시킬 수 있으므로 전위.후위가 아니라 밑에서 증가시켜줌.
			
										//(3) 증감식: 카운터변수의 값을 증감시킴. =>증감식이 없으면 항상 참이므로 무한루프(버그)에 빠짐.
		}	//while
		
	} //main
} //end class





