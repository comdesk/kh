package temp8;

import java.util.Arrays;

public class ArrayInArrayExample {
	
	//다차원배열: 지금까지 우리가 다루었던 배열은 "1차원" 배열
	//			  그런데, 배열은 N-차원의 배열이 가능하다
	public static void main(String[] args) {
		
		int[][] mathScores = new int[2][3];
//		int[][][][] mathScores = {  {{{1}}}, {{{2}}}, {{{3}}}  };
		
		//카운터 변수 i는 1차원 배열의 인덱스 번호로 활용
		for(int i = 0; i < mathScores.length; i++) {	//mathScores.length = 2
			//카운터 변수 k는 1차원 배열의 원소의 인덱스 번호로 활용
			for(int k = 0; k < mathScores[i].length; k++) {	//mathScores[i].length = 3
				System.out.println("mathScores[" + i + "][" + k + "] = "
						+mathScores[i][k]);
			} //inner for
		} //outer for
		
		System.out.println(Arrays.toString(mathScores));	//배열 안의 원소가 배열이라 참조를 보여줌.
		System.out.println(Arrays.toString(mathScores[0]));	//[0,0,0]
		System.out.println(Arrays.toString(mathScores[1]));

		
	} //main
} //end class
