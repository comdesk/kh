package temp4;

import java.io.IOException;

public class WhileKeyExample {
	public static void main(String[] args) throws IOException {
		boolean run = true;	//플래그변수
		int speed = 0;
		int keyCode = 0;	//사용자가 키보드에서 입력한 특정 자판의 키코드값 저장
		
		while(run) {
			
			//키보드에서 누른 자판이 <enter>가 아니라면
			if(keyCode != 13 && keyCode != 10) {
				System.out.println("---------------------------");	//출력 후 엔터키
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");	//처음으로 keyCode = 0이므로 13,10아니니까 메뉴 보여줌.
				System.out.println("---------------------------");
				System.out.print("선택: ");	//print(출력 후 엔터키x)/ 입력하고 엔터키를 치기 전까지 기다림.
			} //if
			
			//키보드로부터 1개의 자판의 코드값을 읽어내는 문장
			keyCode = System.in.read();		
//			System.out.println("*** keyCode: " + keyCode);
											//read는 하나밖에 못 읽음. 입력한 키코드 값만 읽고 다시 루프 돌 때 엔터키값 읽음.
//			if(keyCode == 13 || keyCode == 10) {
//				continue;
//			}	//쓸데없이 밑으로 내려가지 말고 스킵시킨다.
			
//			if(keyCode != 49 && keyCode != 50 && keyCode != 51) {
//				continue;
//			} //if //1,2,3 입력한 게 아니라면 아래에 내려가도 할 게 없으므로 조건식으로 올림.
			
			if(keyCode == 49) {	//키보드에서 누른 키가 1이면
				speed++;
				
				System.out.println("현재 속도 = " + speed);
			} else if (keyCode == 50) {	//키보드에서 누른 키가 2이면
				speed--;
				
				System.out.println("현재 속도 = " + speed);
			} else if (keyCode == 51) {	//키보드에서 누른 키가 3이면
				run = false;			//탈출 조건
			} //if-else if
			
		}//while
			
		System.out.println("프로그램 종료");
				
	} //main
} //end class
