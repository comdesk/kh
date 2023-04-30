package temp4;

import java.io.IOException;

public class te {
	public static void main(String[] args) throws IOException {
		int sayHelloCount = 0;
		
		while(true) {
			System.out.println("Hello");
			System.out.println(sayHelloCount);
			
			if(sayHelloCount++ == 2) {
				
				break;
			}
		}
		
		int keyCode = 0;
		
		
		
		/*while(true) {
			keyCode = System.in.read();
			System.out.println(keyCode);
		}*/
		
		while(true) {	//Infinite Loop
			if(sayHelloCount == 10) {	//탈출조건 => 보통 가장 먼저 판정하게, 
										//나중에 넣으면 탈출조건일 때 실행하지 말아야 하는데 
										//먼저 실행하고 탈출조건을 따지게 되면 일단 실행문장을 실행하게 되니까.
				break;
			} //if
			
			System.out.println("Hello!");
			
			sayHelloCount++;			//Hello를 출력시키고 카운터 변수를 증가시켜야하므로
										//조건식에 전위,후위연산자를 통해 증감하지 않고 맨 밑에 넣어줌.
			
		}	//while
		
		
	} //main
	
	
}






