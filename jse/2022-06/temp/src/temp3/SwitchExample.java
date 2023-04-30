package temp3;

public class SwitchExample {
	public static void main(String[] args) {
//		int num = (int)((Math.random() * 6) + 1);		//무작위 정수를 구하고(범위: [1,6)
		int num = 6;
		
		switch(num) {
		default:	//순서가 바뀌어도 default의 의미가 바뀌는 것은 아님.
			System.out.println("6번이 나왔습니다.");
//			break;
		case 1: 
			System.out.println("1번이 나왔습니다.");
			break;
		case 2: 
			System.out.println("2번이 나왔습니다.");
			break;
		case 3: 
			System.out.println("3번이 나왔습니다.");
			break;
		case 4: 
			System.out.println("4번이 나왔습니다.");
			break;
		case 5: 
			System.out.println("5번이 나왔습니다.");
			break;
		
		} //switch
		
		
//		========================
		
		char grade = 'b';
		
		switch(grade) {
		case 'A':				//fall through 발생(일부러 발생시키기 위해 break문 생략)
		case 'a':
			System.out.println("우수 회원입니다.");
			break;
		case 'B':				//fall through 발생
		case 'b':
			System.out.println("일반 회원입니다.");
			break;
		default:
			System.out.println("손님입니다.");
		} //switch
		
		
//		========================
		
		//break문을 생략하여, fall through 발생 예제
		
		//8<=...<12(8+4) 사이의 정수 얻기
		int time = (int)(Math.random() * 4 ) + 8;
		
		System.out.println("[현재시간: " + time + "시]");
		
		time = 11;
		
		switch(time) {
		default:
			System.out.println("외근을 나갑니다.");
//			break;
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
			break;
		
		} //switch
		
		
//		========================
		
		//switch문에 비교타입으로, int / char / String 가능한가.
		String position = """
				과장님!
				안녕하세요
				""";		//Text Block (OK)
		
		switch(position) {
			case """
				부장님!
				안녕하세요
				""":
				System.out.println("700만원");
				break;
			case """
				과장님!
				안녕하세요
				""":
				System.out.println("500만원");
				break;
			default:
				System.out.println("300만원");
		} //switch
	} //main
} //end class













