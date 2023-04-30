package temp13;

public class Calculator2Example {
	public static void main(String[] args) {
		//1. 전자계산기 객체 생성
		Calculator2 myCalcu = new Calculator2();
		
		//2. 정사각형의 넓이 구하기
		double result1 = myCalcu.areaRectangle(10);
//		double result1 = myCalcu.areaRectangle(10, 10);
		
		//3. 직사각형의 넓이 구하기
		double result2 = myCalcu.areaRectangle(10, 20);
		
		//4. 결과 출력
		System.out.println("정사각형 넓이 = " + result1);
		System.out.println("직사각형 넓이 = " + result2);
	} //main
} //end class
