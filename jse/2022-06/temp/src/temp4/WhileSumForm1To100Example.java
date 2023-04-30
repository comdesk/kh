package temp4;

public class WhileSumForm1To100Example {
	
	//1~10의 총합
	public static void main(String[] args) {
		int sum = 0;		//중간/최종단계의 누적합을 보관할 변수
		int i = 1;			//(1) 초기식 - 카운터변수: 반복횟수를 제어
		
		while(i <= 10) {	//(2) 조건식
			sum += i;		//카운터 변수의 값을 sum에 누적시킴.
			
			i++;			//(3) 증감식
		} //while
		
		System.out.println("1~" + (i - 1) + "합: " + sum);
	} //main
	
	
} //end class
