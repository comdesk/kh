package temp40;

import java.util.Scanner;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ScannerExample {
	
	//핵심포인트: 표준 입력 처리를 대신해주는 Scanner 클래스
	public static void main(String[] args) {
		//1. 표준입력(System.in) 처리를 대신해줘야 하기 때문에 생성자의 매개변수에 표준입력 전달
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1. 문자열 입력> ");		//To show a prompt message
		
		//스캐너의 nextXXX 메소드는 실제 사용자가 콘솔에서 입력과 엔터키를 누르기까지
		//프로그램 실행 흐름 (스레드)를 중지시킨다.(blocking) => 무한정 기다림
		//콘솔의 사용자 입력을 문자열로 반환
		String inputString = scanner.nextLine();
		log.info("1. inputString: {}", inputString);
		
//		==================
		
		System.out.print("2. 정수 입력> ");
		int inputInt = scanner.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
//		===================
		
		System.out.println("3. 실수 입력> ");
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);
		System.out.println();

	} //main

} //end class
