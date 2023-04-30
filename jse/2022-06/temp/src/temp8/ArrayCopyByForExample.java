package temp8;

import java.util.Arrays;

public class ArrayCopyByForExample {
	
	//핵심: 기존 배열을 새로운 배열로 복제(copy)
	//복제방법 2가지: (1) Deep Copy (완전히 새로운 객체로 만들어 복제)
	//				  (2) Thin(=Shallow) Copy (주소만 복제)
	public static void main(String[] args) {
		int[] oldIntArray = {1, 2, 3};		//1-D Array
		int[] newIntArray = new int[5];		//1-D Array without values.
		
		for(int i = 0; i < oldIntArray.length; i++) {	//기존 배열의 순회
			newIntArray[i] = oldIntArray[i];			//새로운 배열의 원소로 복사(copy)
		} //Classical For
		
//		---------------------
		//아래 배열 순회 및 원소 출력 코드는 쓸 데 없음
//		for(int i = 0; i < newIntArray.length; i++) {	//새로운 배열의 순회
//			System.out.println(newIntArray[i] + ", ");	//배열 원소의 출력
//		} //Classical For
		
		//위 출력 코드는 아래의 1문장으로 더 좋은 출력 결과 생성
		System.out.println(Arrays.toString(newIntArray));		//[1,2,3,0,0]
	
//		====================
		
		//System.arraycopy() 메소드를 이용한, 배열의 복제
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray = new String[5];
		
		//System.arraycopy(
		//			복제할 배열 객체, 
		//			int offset1(복제를 시작할 인덱스 번호), 
		//			Object 복제대상객체, 
		//			int offset2(복제대상 객체의 시작 인덱스 번호),
		//			int length(offset2 인덱스를 포함하여, 총 몇 개의 원소를 복제할까)
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		System.out.println("1. oldStrArray: " + Arrays.toString(oldStrArray));
		System.out.println("2. newStrArray: " + Arrays.toString(newStrArray));
			
		
	} //main
} //end class









