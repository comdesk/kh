package temp3;

public class ForFloatCounterExample {
	
	//카운터 변수의 타입으로는, 실수타입(float, double)은 절대!! 사용하지 말라
	public static void main(String[] args) {
		
		//  (1) 초기식          조건식    증감식
		for(float x = 0.1f ; x <= 1.0f ; x += 0.1f) {
//			System.out.println(x);	//반복할 실행문장
		} //for
		
		System.out.println();
		
//		===================
		
		//중첩된 for문을 이용해서 구구단을 구현
		for(int 단수 = 2 ; 단수 <= 9 ; 단수++) {		//구구단에서, 단수를 증가시키는 역할
			System.out.println("*** " + 단수 + "단 ***");
			
			for(int 곱하는수 = 1; 곱하는수 <= 9 ; 곱하는수++) {
				System.out.println(단수 + " x " + 곱하는수 + " = " + (단수 * 곱하는수));
			} //for: 중첩된 안쪽 반복문
		} //for: 바깥쪽 반복문
		
	} //main
	
} //end class















