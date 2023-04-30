package temp15;

public class TelevisionExample {
	
	//대전제: 
	//가. 정적초기자(static initializer)는 무조건 생성자(Constructor)보다 먼저 수행된다.
	//나. 정적초기자(static initializer)는 오로지 단 한 번만 수행.
	//	   - 정적 멤버는 그 소속이 객체가 아니라 메소드 영역의 Clazz객체 소속
	//	   - Clazz 객체를 생성하는 주체가 개발자가 아니라 JVM의 ClassLoader가 생성주체
	//	   - Clazz 객체를 메소드 영역에 꽂아 넣기 직전에, 단 한 번 호출하는 게 바로
	//		 static initializer기 때문에, 오로지 단 한 번만 호출될 수밖에 없음. (호출 주체는 class loader)
	public static void main(String[] args) {
		Television tv = new Television();
		
		System.out.println(Television.info);	//정적 필드의 사용
						
	} //main
} //end class
