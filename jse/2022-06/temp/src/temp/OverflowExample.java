package temp;

public class OverflowExample {
	
	//Overflow 예제
	public static void main(String[] args) {
		//코딩시, 변수 선언문을 맨 위에 기술하고,
		//연산식이 포함된 실행문장을 한 행 띄워서 기재합니다. (관례)
		long x = 1000000;
		long y = 1000000;
		
		long z = x * y;
//		long z =(long) x * y;	//int z일 때, 컴파일러는 결과값까진 알 수 없기 때문에 오류 x
		//(long) 없을 때, 이미 Rvalue의 연산의 결과가 정수 연산의 결과로 넘쳐버렸음.
		//강제형변환은 단항으로 이항연산자인 *보다 우선순위가 높다.
		//처음부터 x와 y를 long타입으로 만드는게 더 좋음.
		
		System.out.println(z);
	} //main
} //end class
