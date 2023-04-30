package temp12;

public class TTT3 {
	
	//자바 언어가 얼마나 빠른지 성능측정(vm의 실행속도)
	public static void main(String[] args) {
		//For 반복문(for loop)를 20만번 수행시키고, 소요시간 측정
		
		//System이란 자반표준라이브러리에 이미 있는 클래스에는
		//currentTimeMillis()란 실행가능한 "메소드"가 있다. 물론, 매개변수는 없다.
		//대신, 이 메소드는 현재시간을 long(정수)타입으로 반환한다.
		
		long start = System.currentTimeMillis();	//시작 전 시간 측정:밀리초(1/1000초)
			//아래와 같이, 성능측정대상 코드는 한 번 더 "들여쓰기" 해주거나
			//사용자 정의 블록({})을 이용하기도 한다.
			for(int i = 1; i <= 2000000000; i++);		//반복시킬 실행문장은 없다.
			
//		{
//			for(int i = 1; i <= 200000; i++);
//		}	//사용자 정의 블록(User-Defined Block)
		
		long end = System.currentTimeMillis();		//종료 후 시간 측정: 밀리초
		
		System.out.println("* Elapsed time: " + ((end - start) / 1000) + " seconds.");
	} //main
} //end class
