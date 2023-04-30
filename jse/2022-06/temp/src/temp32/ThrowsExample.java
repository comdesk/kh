package temp32;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThrowsExample {

	public static void main(String[] args) {
		try {
			ThrowsExample.findClass();		//정적멤버는 정적멤버답게 사용하라
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} //try-catch

	} //main
	
	//이 메소드 수행 시 오류가 발생한다면, ClassNotFoundException 예외가 발생할 수 있음을
	//명시적으로 throws절을 통해서 메소드 호출자(호출 메소드)에게 알려줌.
	public static void findClass() throws ClassNotFoundException, NumberFormatException {
		Class.forName("java.lang.String");
		Integer.parseInt("100");
		
	} //findClass

} //end class





