package temp14;

//대전제: "정적멤버는 정적멤버답게 사용하라!"
//		  = 클래스명.정적필드, 클래스명.정적메소드 형태로 사용하라.
//심화: 그런데, 모든 것을 객체기반으로 프로그램하는 OOP 언어에서는 객체없이
//		필드와 메소드를 위와 같이 사용한다는 거 자체가 "모순"이 된다.
//		왜? 모든 것을 객체 기반으로 하는데 갑자기 객체 없이도 사용 가능하다 하니,
//		말이 안 된다... 그래서 실제는 위와 같이 "클래스명.필드/메소드" 방식으로
//		정적 멤버를 사용하는 문법이지만, 실제로는 "메소드영역"에 만들어 넣어진
//		각 클래스별, "Clazz" 객체의 멤버가 바로 "정적 멤버"이다.
//		결국은 이 "Clazz객체.정적멤버" 형태로 사용해야 하는데, 이 "Clazz"객체를
//		접근하는 방법이 바로 위 대전제의 "클래스명.정적멤버"의 "클래스명"으로
//		"Clazz 객체"를 사용하는 것이다.
public class CalculatorExample {
	public static void main(String[] args) throws ClassNotFoundException {
		double result1 = 10 * 10 * Calculator.pi;	//정적필드(pi) 사용
		int result2 = Calculator.plus(10, 5);		//정적메소드(plus) 호출
		int result3 = Calculator.minus(10, 5);		//정적메소드(minus) 호출
		
		
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
		
//		=========================================		
		
		Calculator calc3 = new Calculator();
		System.out.println(calc3.pi);
		calc3.minus(100, 200);
		
//		=========================================
		
		//우리가 만든 "Calculator" 클래스의 "Clazz객체"를 직접 얻어서 출력해보자
		//특정 클래스에 대한 "Clazz" 객체를 얻는(즉 주소를 얻는) 3가지 방법:
		
		Class clazz;
//		Class class;	//xxx: Compile Error (class는 키워드), 클래스 타입의 변수 클래스(??? 혼선)
						
		//(1) 클래스명.class
		System.out.println( ">>>>>>> 1. " +  Calculator.class         );
		//class temp14.Calculator (타입 + 클래쯔객체가 생성된 클래스의 완전한 이름)
		
		clazz = Calculator.class;		//클래스로부터 얻은 메소드 영역의 객체의 타입이 Class
		//왼쪽 클래스와 오른쪽 클래스가 구분 안 가므로 참조변수 이름을 관례상 clazz라 짓는다.
		System.out.println( ">>>>>>> 1. " +  clazz    );
		
		//(2) 참조변수명.getClass() 메소드 호출의 반환값
		Calculator calc = new Calculator();
		clazz = calc.getClass();	//자바컴파일러가 만드는 것. 참조변수로부터 해당 변수가 들고 있는 객체의 클래쯔객체를 들고 오는 것.
		System.out.println(">>>>>>> 2. " + clazz);
		Calculator calc2 = new Calculator();
		clazz = calc2.getClass();
		System.out.println(">>>>>>> 2. " + clazz);
		
		//(3) Class.forName(FQCN) 메소드 호출의 반환값	//forName(): 정적메소드
		//클래스의 이름을 문자열로 전달하면 그 문자열에 해당하는 클래스의 클래쯔객체를 반환해준다.
		String FQCN = "temp14.Calculator";
		
		clazz = Class.forName(FQCN);
		System.out.println(">>>>>>> 3. " + clazz);
	
	} //main
} //end class















