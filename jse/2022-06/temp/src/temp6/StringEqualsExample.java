package temp6;

public class StringEqualsExample {
	public static void main(String[] args) {
		//(대전제): 동일한 문자로 구성된 "문자열 리터럴"은, 힙 영역에 오로지 "단 한번만"생성 되고,
		//		  이 문자열 객체의 주소가 "공유"된다!
		//기본타입은 동일한 값이어도 각자 들고 있음.
		String strVar1 = "신민철";	//문자열("신민철", String) 타입의 객체의 주소를 보관
		String strVar2 = "신민철";	//문자열("신민철", String) 타입의 객체의 주소를 보관
		
		if(strVar1 == strVar2) {	//동등비교연산자(같냐!?)로 비교 => 같으면...
			System.out.println("strVar1과 strVar2는 참조(=객체의 주소)가 같음");
		} else {					//다르면...
			System.out.println("strVar1과 strVar2는 참조(=객체의 주소)가 다름");
		} //if-else
		
//		===================
		
		//String.equals(String): 두 문자열의 구성문자가 동일한가를 비교.
		//주소를 보는 게 아니라 구성문자가 같은가를 보는 것임. (주소가 달라도 됨.)
		if(strVar1.equals("Yoseph") ) {	//두 개의 문자열이 같은가? 참이면...
										//"Yoseph" -> 변수에 선언하지 않고 문자열 리터럴을 생성만 해도 힙 영역에 객체가 생성되고 참조를 공유함.
			System.out.println("strVar1과 strVar2는 문자열이 같음");
		} //if
		
//		===================
		
		//new로 새로운 문자열 객체를 만들었기 때문에 값이 같아도 주소를 공유하지 않음.
		String strVar3 = new String("신민철");	//새로운 "신민철" 문자열 객체 "생성"
		String strVar4 = new String("신민철");	//새로운 "신민철" 문자열 객체 "생성"
		
		//strVar3, strVar4
		//String은 찍으면 객체의 주소를 보지 못하게 바꿔놓았음.
		System.out.println("1. strVar3: " + strVar3);
		System.out.println("2. strVar4: " + strVar4);
		
		if(strVar3 == strVar4) {	//두 문자열 객체의 주소가 같은가?
			System.out.println("strVar3과 strVar4는 참조가 같음");
		} else {
			System.out.println("strVar3과 strVar4는 참조가 다름");
		} //if
		//문자열을 만드는 방법은 리터럴만 있는 게 아니므로 값이 같아도 주소가 다를 수 있음.
		
		if(strVar3.equals(strVar4)) {
			System.out.println("strVar3과 strVar4는 문자열이 같음");
		}
		
//		==================
		
		Object obj = new Object();	//Object 타입의 객체를 생성해서, 참조변수에 참조(주소) 저장
		
		//소위 참조변수에 저장되어 있는 객체의 주소(=참조)를 직접 눈으로 보자.
		System.out.println();
		System.out.println("*** obj: " + obj);
	} //main
} //end class
















