package temp3;

public class TTT {
	public static void main(String[] args) {
		
		int counter = 1; 
		
		//1. 변형1: 초기식은 생략가능하다
		//			Counter 변수는 꼭 초기식에서 정의할 필요는 없다.
		//2. 변형2: 조건식은 생략가능하다
		//			이를 위해서 조건식을 for 블록 안으로 넣는다.
		//3. 변형3: 증감식은 생략가능하다
		//			이를 위해서 증감식을 for 블록 안으로 넣는다.
		//4. 변형4: for문의 3개 식 모두 한꺼번에 생략가능하다
		//			카운터 변수를 정의하지 않고, 조건식을 만들지 않고, 증감식도 만들지 않으면서
		//			3개 식을 모두 생략하는 경우
		//			이렇게 되면 소위 "무한루프(무한반복)"가 생성된다.
		/*for(   ;   ;  ) {	//무한루프
//			if(counter <= 10) {
//				System.out.println(counter);
//			} else {
//				break;		//거짓일 때 for문을 깨뜨리고 나가야 하므로 => break는 사실 반복문을 깨뜨리고 빠져나오는 역할.(switch문에서 나오기 위해 허용되는 것뿐)
//			} //if-else
//			counter++;		//소괄호 안에 있을 때 중괄호 안이 어떻든, 증가시키려고 하므로 영향 받지 않게 if밖에 씀.
			
			
		} *///for: Infinite Loop
		
		for( ; ; ); // 무한루프 자체의 속도를 측정할 때, 컴퓨터가 반복을 얼마나 빨리 하나 측정. 
		
		/*for( ; ; ) {
			;;		//;;(Pass) : 뭐 넣어야 하는데 아직 못했을 때 다른 동료한테 알려주기 위해서
		}*/ //for: Infinite Loop
		
		//메인블록에 카운터 변수를 정의했기 때문에 for블록 밖인데도 살아있음.
//		System.out.println("* counter: " + counter); //11이 되어야 빠져나올 수 있으므로 값이 11
	} //main
} //end class




