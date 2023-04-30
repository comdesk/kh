package temp8;

public class TTT {
	public static void main(String[] args) {
		int[][][] arr = 		//2차원 배열 shape(모양): 3 x 3
			{       
				{
					{1, 2},
					{3}
				}, 
                {
					{4, 5, 6}
				}, 
                {
					{7, 8, 9}, 
					{10, 11, 12}
				}     
			};
		
		int value = arr[2][1][2];
		System.out.println(value);
	} //main
} //end class
