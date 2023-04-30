package temp35;

import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT {
	public static void main(String... args) {
		TTT.staticMethod();			//전달인자 개수 = 0 (OK) *** 아무것도 안 줌
		TTT.staticMethod(1);		//전달인자 개수 = 1 (OK)
		TTT.staticMethod(1, 2);		//전달인자 개수 = 2 (OK) => 쉼표 구분자 ***
		TTT.staticMethod(1, 2, 3);	//전달인자 개수 = 3 (OK)
		
		int[] intArr = {1, 2, 3, 4, 5};
		TTT.staticMethod(intArr);	//전달인자로 배열객체를 넘겨줘도 OK ***
		
//		TTT.staticMethod({1, 2, 3, 4, 5});	//xx
		TTT.staticMethod(new int[] {1, 2, 3, 4, 5}); //ok
		
	} //main
	
	//"가변 인자" 연산자: 매개변수가 받을 전달이자의 개수가 정해져 있지 않도록 해주어서,
	//					  0개 이상의 전달인자를 받을 수 있도록 해줌.
	//					  (x >= 0, 여기서 x는 전달인자의 개수)
	private static void staticMethod(int... numbers) {	//...은 독립적(타입과 별개)
		log.info(Arrays.toString(numbers));
	} //staticMethod
} //end class




