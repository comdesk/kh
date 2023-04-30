package temp23;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyInterfaceExample {

	public static void main(String[] args) {
		//1. 인터페이스 타입의 참조변수를 얼마든지 선언할 수 있다.
		//	 왜? 참조타입 4가지 중에 하나니까.
		IMyInterface myInterface;
		
		//2. 인터페이스에 선언된 public static final 상수를 이용해보자
		//	 사용방법: 대전제 - 정적멤버는 정적멤버답게 사용하라
		//	 불변의 진리값(=상수)이기 때문에 정적멤버답게만 사용하면 어디서든 사용 가능
		log.info("1. IMyInterface.PI: {}", IMyInterface.PI);
		
		//3. 인터페이스에 선언된 public abstract 메소드를 재정의한 구현클래스로부터
		//	 "구현객체"를 생성하고, 이를 통해서 재정의된 메소드를 사용해보자
		myInterface = new IMyInterfaceImpl();	//다형성-1
		//---------   ----------------------
		// 부모타입       구현(자식)객체
		
		//구현 객체는 물려받은 추상메소드(강제 규격)을 "재정의"하였기 때문에
		//다형성-2에 의해 무조건 구현 객체의 재정의된 메소드가 호출된다.
		myInterface.abstractMethod();			//다형성-2로 호출됨.
		
		//4. 인터페이스에 선언된 "정적" 메소드를 사용해보자
		//	 대전제는 변함이 없다
		//	 즉 정적 멤버(필드, 메소드)는 정적멤버답게(정적멤버가 선언된 타입명.멤버명) 사용하면 된다
		IMyInterface.staticMethod();	//인터페이스에 선언된 정적 메소드를 정적 멤버답게 호출
		
		//5. 인터페이스에 선언된 public default 인스턴스 메소드를 상속받은 "구현클래스"에서 생성한
		//	 "구현객체"를 통해 public default 메소드를 호출해보자.
		
		//호출된 defaultMethod는 구현 클래스에 처음부터 선언된 인스턴스 메소드가 아니다.
		//그럼에도 호출 가능한 것은 인터페이스를 구현한 구현 클래스로부터 생성된 "구현 객체"라면
		//마치 처음부터 구현 클래스에 선언된 인스턴스 메소드와 같이 호출 가능하게 JVM이 처리해준다.
		myInterface = new IMyInterfaceImpl();	//다형성-1
		myInterface.defaultMethod();	//ok: 그렇다고 구현객체에 이 메소드가 진짜 있을까요? 진짜론 없다.
										//	  그래도 처음부터 갖고 있었던 것처럼 사용할 수 있다.
		
//		myInterface = null;
//		myInterface.defaultMethod();	//XX
		
		
	} //main	

} //end class










