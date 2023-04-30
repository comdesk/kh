package temp8;

import java.util.Arrays;

public class MainSTringArrayArgument {
	public static void main(String[] args) {	//main을 실행시키려면 String타입의 args 배열변수에 배열 객체를 만들어 초기값으로 넣어줘야 함.
		System.out.println(args.length);	//배열 객체가 들어오지 않았다면 NullPointerException. 0이라면 빈 배열
		System.out.println(Arrays.toString(new int[] {1,2,3}));
		
		System.exit(100);		//0: Normal Exit, Others: Abnormal Exit
		
		if(args.length != 2) {
			System.out.println("프로그램의 사용법");
			System.out.println("java MainStringArrayArgument num1 num2");
			
			//이 문장을 실행하면, 묻지도 따지지도 않고 그 즉시 프로그램 종료
			System.exit(0);	//이때, 숫자 0을 "Exit Code(종료코드)"라고 한다.
		} //if
		
		String strNum1 = args[0];	//"100"
		String strNum2 = args[1];	//"200"
		
		//"숫자형태"의 문자열 => 진짜 int 타입의 정수로 바꿔줌(=매핑, Mapping)
		int num1 = Integer.parseInt(strNum1);	//표준 라이브러리에 있는 실행 클래스
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	} //main
} //end class
