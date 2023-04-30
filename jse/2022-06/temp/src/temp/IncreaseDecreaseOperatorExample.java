package temp;

public class IncreaseDecreaseOperatorExample {
	
	//증감연산자: 단항, 변수의 값을 1 증가(++)시키거나, 1 감소(--)시킴.
	//증감연산자의 구분: (1) 전위 (2) 후위
	//(주의): (1) 전위와 (2) 후위에 따라, 증감연산자의 연산이 달라짐.
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("----------------------");
		
		x++;	//증가 연산자 => '후위'
//		x = x + 1;	//연산방향이 오른쪽 -> 왼쪽
		
		++x;	//증가 연산자 => '전위'
		
		System.out.println("x = " + x);
		
//		=============================
		
		System.out.println("----------------------");
		
		y--;	//감소 연산자 => '후위'
		y = y - 1;
		
		--y;	//감소 연산자 => '전위'
		
		System.out.println("y = " + y);
		
//		=============================
		//전위와 후위의 차이점에 대해 잘 이해하기!!
		
		System.out.println("----------------------");
		
		//(1) '전위' 증감연산자: 증감연산부터 수행 => 수행결과를 연산식에 적용
		//(2) '후위' 증감연산자: 연산식부터 수행 => 증감연산자를 수행
		//대입 연산자가 우선순위가 가장 낮음에도 불구하고 후위증감연산자는 연산식부터 수행함.
		z = x++;
		
		//'후위'연산일 경우: 자신을 증가시키는 행위를 나중에 하겠다.
//		z = x;
//		x = x + 1;
		
		System.out.println("z = " + z);
		System.out.println("x = " + x);
		
//		=============================
		
		System.out.println("----------------------");
		
		z = ++x;	//'전위' 증가 연산자
		
//		x = x + 1;
//		z = x;
		
		System.out.println("z = " + z);
		System.out.println("x = " + x);
		
//		=============================
		
		System.out.println("----------------------");
		
		z = ++x + y++;
		
		x = x + 1;
		z = x + y;
		y = y + 1;
		
		System.out.println("z = " + z);
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	} //main
} //end class


















