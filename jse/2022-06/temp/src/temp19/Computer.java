package temp19;

public class Computer 		//자식 클래스
	extends 				//전자계산기 클래스 상속
	Calculator {			//부모 클래스
	
	@Override		//컴파일러에게 오버라이딩을 엄격하게 체크 요청
					//사실 메소드 선언부에 아무것도 안 바꿨기 때문에 @Override 안 붙여도 되지만
					//그래도 @Override 붙이는 게 거의 규칙화
	double areaCircle(double r) {	//메소드 오버라이딩 (Overriding)
		System.out.println("Computer::areaCircle(r) invoked.");
		
		return Math.PI * r * r;		//원의 면적의 정확도를 위해 PI값을 바꾸려고 메소드 오버라이딩
	} //areaCircle
	

} //end class
