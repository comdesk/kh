package temp20;

public class FrontTire {	//규격 생성
//	private Bicycle bicycle;	//부품간의 상호작용이 필요할 때 부품이 몇 번째 찍어낸 자전거 객체의 부품인지 알아야 함.
								//근데 부모 타입은 규격만 만들지 어느 객체의 소속인지 관심 없음.
								//여기가 아니라 실제 생성될 부품 객체인 자식 객체에 넣어야 함.
//	public FrontTire(Bicycle bicycle) {
//		this.bicycle = bicycle;
//	} //constructor
	
	public void roll(Direction direction) {;;}	//규격 정의
	//오버라이딩하기로 약속해서 중괄호 안을 비어놓음 => 근데 강제가 아님.
	//강제할 수 있는 수단이 추상 클래스, 인터페이스
} //end class
