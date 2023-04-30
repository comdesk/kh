package temp3;

public class ForPrintFrom1To10Example {
	
	//for문 예제: 총 10번 반복 counter 변수의 값을 출력하는 예제
	public static void main(String[] args) {
		
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.println(i);
		} //for
		
//		System.out.println(i);
		
		
//		===================
		
		int sum = 0;
		int i = 0;
		
		
		for(i = 1; i <= 5; i++) {
//			sum +=i;					//sum = sum + i;
			int newSum = sum + i;	   //newSum은 반복에서 블록의 끝을 만나면 사라지고 다시 반복하면 생기고
		} //for							
		
//		System.out.println("1~" + (i - 1) + " 합: " + sum);
	} //main
} //end class











