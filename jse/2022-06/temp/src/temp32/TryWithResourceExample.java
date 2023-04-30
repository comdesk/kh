package temp32;


public class TryWithResourceExample {
	
	//try-with-resources 구문에 대해서 배우자
	public static void main(String[] args) {
		//FileInputStream 타입의 객체 => 자원객체(왜? AutoCloseable하니까)
		//Syntax: try ( AutoCloseable한 자원객체를 생성 ) { ... }	@since JAVA 7
		try(FileInputStream fis = new FileInputStream("file.txt")) {	//이 부분 때문에 try-with-resources
			fis.read();
			
			throw new Exception();	//강제로 예외를 발생시킴 (예외가 발생하면 못 닫아줄까봐 실험하려고 만든 코드)
									//예외가 발생하면 바로 catch블록으로 가버리니까 닫는 중괄호 블록을 못 만나는지 실험
		} catch(Exception e) {
			e.printStackTrace();
		} //try-catch

	} //main

} //end class
