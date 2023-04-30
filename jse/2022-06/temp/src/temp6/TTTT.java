package temp6;

public class TTTT {
	public static void main(String[] args) {
		double a = 3.968;
		double b = 7.785;
		
//		a = (a + b) - (b = a);
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	
}
