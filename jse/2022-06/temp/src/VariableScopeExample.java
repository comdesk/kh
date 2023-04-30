
public class VariableScopeExample {
	public static void main(String[] args) {
		int var1;
		
		if(true) {		//if블록
			int var2;
			
			var1 = 10;
			var2 = 20;
		} //if
		
		System.out.println("1. var1: " + var1);	//산술연산 +이 아니라 문자열 연결 연산자 +임. 변수 안의 값을 끄집어내서 더하는 것임. var1이 살아있고, if블록 안에서 정의됨. 참조타입+기본타입. 둘 중에 큰 타입에 맞춤.
//		System.out.println("2. var2: " + var2); //var2는 if블록이 끝나면서 깨져서 없어짐.
	}
}
