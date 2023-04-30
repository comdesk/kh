package temp21;

public class InstanceOfExample {
	
	//지금 예제는 다형성-1에 의해서 부모 타입의 참조변수로부터
	//자식 객체를 강제로 끄집어 낼 때 이전 예제와 같이 "강제형변환"이 필요한데
	//이 때 먼저 해야할 일이 있다 => 부모 타입의 참조 변수에 정말 내가 알고 있는 자식 객체가
	//들어가 있는가? => 이걸 개발자가 어떻게 아는가? => 직접 부모타입의 참조변수를 출력해보지
	//않는한 어떻게 아는가? => 프로그램적으로 부모타입의 참조변수에 어떤 자식 타입의 객체가
	//실제 들어가 있는지(다형성-1)를 알아야 한다. (안전한 강제형변환을 위해)
	//이를 위해 나온 연산자가 바로 "패턴매칭 연산자"라고 불리는 "instanceof 연산자"
	//(1) 어디에 사용? => 조건식을 만들 때 사용
	//(2) 연산자의 결과는? => boolean (true/false)
	//(3) 용법(이항연산자): 참조변수 instanceof <참조타입>
	
	public static void main(String[] args) {
		Parent1 parentA = new Child1();			//다형성-1
		InstanceOfExample.method1(parentA);		//정적메소드 호출
		InstanceOfExample.method2(parentA);		//정적메소드 호출
		
		Parent1 parentB = new Parent1();	//다형성-1x
		InstanceOfExample.method1(parentB);
		InstanceOfExample.method2(parentB);	//예외 발생(ClassCastException)
		
		
	} //main
	
	//정적메소드: 왜? => 대전제: 정적멤버는 오로지 정적 멤버만 사용가능하다. (메인이 정적) (객체 생성 없을시 인스턴스멤버는 호출못함.)
		public static void method1(Parent1 parent) {
			//instanceof 연산자를 통해서 부모타입의 참조변수에 어떤 타입의 자식객체가
			//대입되어 있는지를 판별 => 필요한게, "패턴매칭연산자, instanceof"
			
//			   참조타입변수  패턴매칭    판별할 참조타입명
			if(   parent     instanceof      Child1) {	//Child1 타입의 객체가 들어 있다면
				Child1 child = (Child1) parent;	//안전한 강제 형변환을 통해 강제로 자식객체를 끄집어냄.
				System.out.println("method1 - Child로 변환 성공");
			} else {
				System.out.println("method1 - Child로 변환되지 않음.");
			}
		} //method1
		
		public static void method2(Parent1 parent) {
			//instanceof 연산자를 통해서 부모타입의 참조변수에 어떤 타입의 자식객체가
			//대입되어 잇는지를 판별 => 필요한게, "패턴매칭연산자, instanceof"
			
				Child1 child = (Child1) parent;	//안전하지 않은 강제 형변환. Child1가 아닌 객체가 들어있으면 오류
				System.out.println("method2 - Child로 변환 성공");
			} //method2
} //end class







