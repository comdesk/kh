package temp7;

import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		System.out.print("입력: ");
		
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		char[] charArr = name.toCharArray();
		
/*		int i = 0;
		int j = 0;
		
		label:
		for(i = 0; i < charArr.length; i++) {
			
			
			for(j = charArr.length - 1; j >= 0; j--) {
				
				if(i + j == charArr.length - 1) {
					if(charArr[i] != charArr[j]) {
						break label;
					} else {
						System.out.println("애너그램입니다.");
					}
				}
			} //inner for
			
		} //outer for
		System.out.println("애너그램이 아닙니다.");*/
		
		String str = "";
		String str2 = "";
		for(int i = 0; i < charArr.length; i++) {
			str += charArr[i];
		}
		System.out.println(str);
		for(int j = charArr.length - 1; j >= 0; j--) {
			str2 += charArr[j];
		}
		System.out.println(str2);
		
		if(str.equals(str2)) {
			System.out.println("애너그램");
		} else {
			System.out.println("애너그램 아님");
		}
 	} //main
} //end class







