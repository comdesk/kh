package temp9;

import java.util.Arrays;

public class Practice6 {
	public static void main(String[] args) {
		
		int[] arr = new int[30];
		for(int i = 0; i < arr.length; i++) {
			int num = (int)(Math.random() * 101);
			arr[i] = num;
		}
		System.out.println(Arrays.toString(arr));
	} //main
}
