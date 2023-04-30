package temp13;

public class Calculator2 {
	
//	this.areaRectangel(100);	//클래스 블록에는 실행문장 못 넣으므로.
								//클래스 블록에는 오직 필드, 생성자, 메소드만이.
	
	String color;
		
	//기본 생성자
	public Calculator2() {
		this.areaRectangle(100);	//메소드 호출 (생성자나 메소드블록에는 실행문장이 들어갈 수 있음.)
	
		Calculator2 newCalculator = new Calculator2();	//생성자 내 객체 생성 가능.
		newCalculator.areaRectangle(100);
	
		//가능하면 생성자 블록 내부에서는 우리가 알다시피 필드 초기화 하라.
		this.color = "하얀색";
	} //default constructor
	
	//정사각형의 넓이
	double areaRectangle(double width) {
		System.out.println("Calculator2::areaRectangle(double) invoked.");
		
//		return width * width;
		
		this.color = "파란색";	//해도 되지만 목적에 안 맞기 때문에 안 하는 것임.
		return 3.14159;	//pi
	} //areaRectangle
	
	//직사각형의 넓이
	
// 메소드 시그니처 구성요소:
// 리턴타입 메소드이름  |----- 매개변수 선언부 -----|
	double areaRectangle(double width, double height) {
		System.out.println("Calculator2::areaRectangle(double, double) invoked.");
		
		return width * height;
	} //areaRectangle
} //end class








