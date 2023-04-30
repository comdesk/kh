package temp19;

public class Calculator {
	
	//원의 면적을 계산해주는 메소드를 가지고 있음.
	double areaCircle(double r) {
		System.out.println("Calculator::areaCircle(r) invoked.");
		
		//원의 면적 = 원주율(파이) * 원의 반지름의 제곱
		return 3.14159 * r * r;
	} //areaCircle
	
} //end class
