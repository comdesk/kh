package temp24;


//두 번째 Runtime Exception 예로, 배열 조작 시 발생하는 실행 예외:
//ArrayIndexOutOfBoundsException
public class ArrayIndexOutOfBoundsExceptionExample {
	
	//배열타입의 참조변수를 빈 배열로 초기화
	public static void main(String[] args) {
		args = new String[] {};					//빈 배열(Empty Array, 즉 원소가 없는 배열)로 초기화
		
		String data1 = args[0];					//원소가 없기 때문에 사용 가능한 인덱스 번호도 없음.
		String data2 = args[1];					//원소가 없기 때문에 사용 가능한 인덱스 번호도 없음.
		
		System.out.println("args[0]: " + data1);
		System.out.println("args[1]: " + data2);
	} //main
} //end class
