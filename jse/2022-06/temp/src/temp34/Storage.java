package temp34;


//제네릭 타입의 인터페이스
public interface Storage<T> {
	
	//자식 구현 클래스가 반드시 구현(오버라이딩)해야 할 "강제 규격"
	public abstract void add(T item, int index);
	public abstract T get(int index);
} //end class
