
public class ByteExample {
	
	//byte 타입의 도메인: -128 ~ +127
	//만일 이 타입별 도메인의 범위를 벗어나는 값을 입력하면 컴파일 오류
	public static void main(String[] args) {
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
//		byte var6 = 128;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		
//		==================================
		
		//byte 타입의 도메인: -128 ~ +127
		byte vari1 = 125;	//1바이트
		
		for(int i = 0; i < 5; i++) {	//총 5번 block 안의 실행문장들을 반복 수행
			vari1++;				//overflow 발생시 -> 도메인의 하한선으로 back
			
			System.out.println("vari1: " + vari1);
		} //for
	} //main
} //end class

















		
		