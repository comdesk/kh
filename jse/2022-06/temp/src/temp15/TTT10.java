package temp15;

public class TTT10 {
	
	static {
		System.out.println(">>> static initializer #1");
	} //static initializer #1
	
	{
		System.out.println("&&& User-defined block #1");
	} //User-defined block #1
	
	public static void main(String ... args) {
		String earthArea;
		//주의사항: 사용자 정의블록은 어느 블록에서건 선언 가능
		//			벗, 실행 가능한 블록 안에서만 실행 가능.(=> 생성자 블록, 메소드 블록 내에서 사용)
		//			그래서 실행가능하지 않은 클래스블록 안에서는 실행되지 않음.
		{	//지구의 면적을 계산하여, earthArea 변수에 대입
			earthArea = "지구의 면적계산(지구면적 = 4 * 원주율 * 지구반지름의 제곱)";
			int age = 23;
			
			System.out.println("&&& User-defined block #4");
		} //User-defined block #4
		
//		//주의사항: static initializer는 메소드 블록 안에서는 선언 불가
		//필드를 초기화해줘야 하는데 메인 메소드 안에서 선언되는 건 말이 안 됨.
		//			오로지 Class 블록 안에서만 선언 가능
//		static {
//			System.out.println(">>> static initializer #4");
//		} //static initializer #4

	} //main
	
	static {
		System.out.println(">>> static initializer #2");
	} //static initializer #2
	
	{
		System.out.println("&&& User-defined block #2");
	} //User-defined block #2
	
	static {
		System.out.println(">>> static initializer #3");
		
		{
			System.out.println("&&& User-defined block #5");
		} //User-defined block #5
	} //static initializer #3
	
	{
		System.out.println("&&& User-defined block #3");
	} //User-defined block #3
	
} //end class








