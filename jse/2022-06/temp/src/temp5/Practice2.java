package temp5;

//알고리즘
//1. 정수의 범위를 지정한다. (2 ~ 100)
//2. 무작위의 정수를 1개 추출한다. (복원 추출)
//3. 정수의 값을 출력한다.
//4. 추출한 정수가 소수인지 확인한다.
//5. 소수 여부를 출력한다. 
//6. 값이 소수라면 2,3,4번의 과정을 반복한다.
//7. 값이 소수가 아니라면 프로그램을 종료한다.
//8. 20개의 소수가 출력되었다면 프로그램을 종료한다.
public class Practice2 {
	public static void main(String[] args) {
		int num = 0;
		int result = 0;		//추출한 정수와 소수 여부 비교를 위한 변수를 정의한다.
		int i = 0;			//바깥쪽 반복문의 카운터 변수를 정의한다.
		
		
		label:
		for(i = 1; i <= 20; i++) {
//			num = (int)(Math.random() * 99) + 2;					//1. 정수의 범위를 지정하고, 2. 무작위의 정수를 1개 추출한다.
			num = 2;
			System.out.println("정수: " + num);						//3. 정수의 값을 출력한다.
			for(int mod = 2; mod < num; mod++) {					//4. 추출한 정수가 소수인지 확인한다.
				result = num % mod;
				
				if(result == 0) {						
					System.out.println(num + "은(는) 소수가 아닙니다.");	//5. 소수 여부를 출력한다. 
					System.out.println("프로그램을 종료합니다.");
					break label;									//7. 값이 소수가 아니라면 프로그램을 종료한다.
				} //if
			} //inner for								
			
			System.out.println(num + "은(는) 소수입니다.");				//6. 값이 소수라면 2,3,4번의 과정을 반복한다. 
			
			if(i == 20) {											//8. 20개의 소수가 출력되었다면 프로그램을 종료한다.
				System.out.println("20개의 소수가 모두 출력되었습니다. 프로그램을 종료합니다.");
				break label;
			}
		} //outer for									
							
	} //main
} //end class
