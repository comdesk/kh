package temp8;

public class ArrayReferenceObjectExample {
	public static void main(String[] args) {
		String[] strArray = new String[3];	//크기가 3인 1-D배열, null이 3개
		
		//첫 번째와 두 번째 원소는 "Java"라는 동일한 문자열 객체의 주소를 공유
		strArray[0] = "Java";	//첫 번째 원소값 설정
		strArray[1] = "Java";	//두 번째 원소값 설정
		//세 번째 원소는 객체생성연산자인 new로 객체를 생성/저장했기 때문에,
		//다른 객체의 주소를 저장
		strArray[2] = new String("Java");	//세 번째 원소값 설정
		
		//2개의 참조타입 변수에 대한, 동등비교연산자의 의미는
		//2개의 참조타입 변수에 저장된 객체의 주소가 같은지/다른지?
		System.out.println(strArray[0] == strArray[1]);	//true
		System.out.println(strArray[0] == strArray[2]);	//false
		
		//기준문자열.equals(비교문자열): 구성문자열 비교
		//기준문자열.equalsIgnoreCase(비교문자열): 대소 상관없이 비교
		System.out.println(strArray[0].equals(strArray[2]));	//true
	} //main
} //end class
