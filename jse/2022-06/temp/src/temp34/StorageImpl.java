package temp34;

import lombok.ToString;

@ToString
//제네릭 인터페이스를 구현(implements)하는 자식 제네릭 타입의 구현 클래스 선언
public class StorageImpl<T> implements Storage<T> {  //StrageImple<T>가 구체타입을 받으면 Storage<T>도 바뀌고
	private T[] array;								//안의 T도 바뀐다. Storage<T>는 두 번째 타입 파라미터가 아니다.
	
	@SuppressWarnings("unchecked")
	public StorageImpl(int capacity) {
		this.array = (T[]) (new Object[capacity]);
	} //constructor
	
	@Override
	public void add(T item, int index) {
		array[index] = item;
	} //add

	@Override
	public T get(int index) {
		return array[index];
	} //get

} //end class



