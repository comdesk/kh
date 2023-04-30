package temp;

public class DenyLogicOperatorExample {
	//논리연산자(AND, OR, NOT) 중에, "부정"연산자(NOT) => 연산자 기호: !
	public static void main(String[] args) {
		boolean play = true;
		System.out.println(play);
		
//		=================
		
		play = !play;				//토글(Toggle) Like Switch
		System.out.println(play);	//false
		
//		=================
		
		play = !play;				//똑같은 코드를 수행하는데 값이 반전되는 코드: 토글(Toggle)
		System.out.println(play);	//true
	} //main
} //end class
