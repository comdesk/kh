package temp19;

public class ChildExample {
	
	//상속 관계인 두 클래스(Parent, Child)를 이용한 다형성의 구현
	public static void main(String[] args) {
		Child child = new Child();		//1. 자식 객체 생성
		
		Parent parent = child;			//2. 다형성-1: 부모타입 참조 변수에 자식 객체 대입
		
		System.out.println(">>> parent: " + parent);
//		>>> parent: temp19.Child@4517d9a3	//프로모션에 의해 차일드가 패런트로 바뀌는 게 아니다. 여전히 차일드 타입의 객체
		
		parent.method1();				//3. 다형성-2: 재정의된 메소드만 실행
		
		parent.method2();				//3. 다형성-2: 재정의된 메소드만 실행
		
//		parent.method3();	(호출 불가능)
	} //main
} //end class
