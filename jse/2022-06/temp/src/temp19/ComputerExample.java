package temp19;

public class ComputerExample {
	
	//OOP의 (1) 캡슐화(by 접근제한자) (2) 상속(by extends) (3) 다형성(by 다형성-1, 다형성-2)
	//의 3가지 성질에서 가장 중요한 (3) 다형성과 메소드 오버라이딩은 매우 밀접한 관계가 있다.
	public static void main(String[] args) {
		int r = 10;
		
//		============
		
		Calculator calculator = new Calculator();
		
		System.out.println("원 면적: " + calculator.areaCircle(r));
		System.out.println();
		
//		============
		
		Computer computer = new Computer();
		
		System.out.println("원 면적: " + computer.areaCircle(r));
		
	} //main
} //end class
