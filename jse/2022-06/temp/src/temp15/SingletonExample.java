package temp15;

import java.util.Arrays;

public class SingletonExample {
	
	//Singleton 객체를 얻어서 사용해보자
	//더불어 실험으로 Singleton객체를 여러 번 얻었을 때 객체의 참조(레퍼런스)가 무조건
	//같은지 확인
	public static void main(String[] args) {
//		Singleton obj1 = Singleton.getInstance();
//		Singleton obj2 = Singleton.getInstance();
//		
//		System.out.println(">>> 1. obj1: " + obj1);
//		System.out.println(">>> 2. obj2: " + obj2);
		
		Singleton ref = Singleton.getInstance();
		System.out.println(Arrays.toString(ref.passwords));
		ref.passwords = new int[] {1,3,5,7,9};
	
	} //main
} //end class
