package temp4;

import java.util.Scanner;

public class DoWhile {
	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");	//프롬프트 메시지(사용자의 입력을 유도하는 메시지)
		//이전 예제에서, 우리는 사용자의 키보드 입력을 받기 위해서,
		//System.in.read();라는 실행문장을 이용하였습니다.
		//그런데, 이 방식은 직접 개발자가 자판의 key code 값을 처리하기에
		//불편함이 있어서 자주 사용하기가 곤란하다.
		//이러한 개발자의 불편함(즉, 사용자의 키보드 입력을 쉽게 처리할 수 있도록)
		//해소할 수 있게 나온 게 바로 ====> 'Scanner'
		
		//이 Scanner는 사용자가 입력을 1개 문자가 아니라, 문자열로도 쉽게 입력
		//받을 수가 있도록, 실제 정수/실수 등의 기본타입 값으로도 입력받을 수 있게
		//해준다. 즉, 결국은 Scanner 안에서는 System.in.read()가 사용됩니다만,
		//개발자의 키코드 처리를 아주 깔끔하게 처리해 주는 것이다.
		Scanner scanner = new Scanner(System.in);
		
		String inputString;					//문자열 변수 '선언'
		
		do {	//do-while block
			System.out.print(">");			//Prompt (?) 메시지 출력
			
			//스캐너를 통해, 사용자가 키보드로 입력한 한 행(one line)을
			//문자열로 입력받을 수가 있다.
			//그게 바로 아래의 scanner.nextLine(); 실행문.
			//이 실행문장은 사용자가 입력한 값을 문자열(String타입)로 만들어 돌려준다.
			inputString = scanner.nextLine();	//사용자가 입력한 한 행을 문자열로 읽음.
			System.out.println(inputString);
		} while( ! inputString.equals("q"));	//';'(세미콜론)을 붙여야 한다.
		//q를 입력하면 끝내버린다. => q를 입력하면 조건식이 거짓이 되게 하면 된다.
		
		scanner.close();	//닫지 않으면 메모리 누수 발생
		
		System.out.println();
		System.out.println("프로그램 종료");
		
	} //main
} //end class















