package temp23;

//인터페이스 간의 소위 다중 "상속" 예제

//이 인터페이스는 인터페이스 A와 B를 "상속(extends)"합니다.
public interface InterfaceC 
	extends InterfaceA, InterfaceB {
	
	public abstract void methodC();
} //end interface
