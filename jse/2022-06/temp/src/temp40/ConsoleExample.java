package temp40;

import java.io.Console;

public class ConsoleExample {

	public static void main(String[] args) {
		Console console = System.console();	//콘솔 객체 획득
		System.out.println("0. console: " + console);
		
		System.out.print("1. id: ");
		String id = console.readLine();	//콘솔에서 사용자 입력을 문자열로 반환
		
		System.out.print("2. password: ");
		//역시 콘솔에서 사용자 입력을 문자열로 반환하되,
		//마치 암호를 입력받는 듯한 효과를 준다. 즉 Unix/Linux 계열 운영체제에서
		//사용자 계정으로 로그인할 때, 암호를 입력하면 아무것도 화면에 표시하지 않는데
		//이와 같이 입력을 받도록 해준다.
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);
		
		System.out.println("------------------");
		System.out.println("1. id: " + id);
		System.out.println("2. password: " + strPassword);

	} //main

} //end class
