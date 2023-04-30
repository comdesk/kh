import java.util.Scanner;

public class App6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();

		for(int i=0; i<num; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			for(int j = 0; j < n; j++) {
				a += b;

				if(j > 0 ) {
					System.out.print(" ");				//한줄띄우지 말라고 했기 때문에 print
				}
				System.out.print(a);
				b= b*2;
			} //for

			System.out.println();

		} // for
		in.close(); 	//scanner 종료

	} //main
} //end class
