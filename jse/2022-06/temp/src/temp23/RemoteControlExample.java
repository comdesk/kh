package temp23;

public class RemoteControlExample {
	public static void main(String[] args) {
		//Lvalue, Rvalue가 모두 동일한 구현클래스 타입의 구현 객체 생성
		SmartTelevision tv = new SmartTelevision();
		
		//다형성-1: 부모타입(여기서는, "인터페이스")의 참조변수에
		//			모든 자식객체(여기서는, "구현객체")가 대입 가능하다
		RemoteControl rc = tv;			//Lvalue(interface type) = Rvalue(구현객체)
		Searchable searchable = tv;		//Lvalue(interface type) = Rvalue(구현객체)
	} //main
} //end class
