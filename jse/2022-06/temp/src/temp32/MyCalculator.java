package temp32;

public class MyCalculator<T> {
	public int add(int number1, int number2) {
		return number1 + number2;
	} //add
	
	public byte add(byte number1, byte number2) {
		return (byte) (number1 + number2);
	} //add
	
	public short add(short number1, short number2) {
		return (short) (number1 + number2);
	} //add
	
	public long add(long number1, long number2) {
		return number1 + number2;
	} //add
	
	public float add(float number1, float number2) {
		return number1 + number2;
	} //add
	
	public double add(double number1, double number2) {
		return number1 + number2;
	} //add
	
//	public type add(type number1, type number2) {	//타입명만 바뀌니까 위의 많은 메소드들을 하나로 만든다면?
//		return number1 + number2;					//타입만 바꿔버릴 수 있다면..
//	} //add 
	
	//매개변수가 아니라 매개변수의 타입이 바뀌는 것.
	//T: Type Parameter(실제 구체적인 타입을 받는 매개변수 역할)
//	public T add(T number1, T number2) {	//T대신에 사용자가 원하는 구체적인 타입(=구체 타입)을 집어넣을 수 있다면.
//		return (T) (number1 + number2);		//T는 진짜 타입이 아니라 상징적인 타입
//											//T 대신에 타입명을 넣는 거니까 T를 타입 파라미터라고 하자.
//		//제네릭은 기본타입과 관련없으므로 '+' 오류나는 것.
//		//String타입이어도 안 됨. 제네릭은 모든 참조타입에 대해 일반화하는 것이므로.
//	} //add
	
	public boolean add(T obj1, T obj2) {
		return obj1 == obj2;	//참조타입 동등비교는 가능하므로
	} //add
} //end class







