package temp42;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectInputOutputStreamExample {
	//핵심포인트: 객체의 직렬화와 역직렬화를 위한 ObjectInputStream/OutputStream
	public static void main(String[] args) throws Exception {
		//1. Base 스트림(FileOutputStream) 생성
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		//2. 객체의 직렬화 수행하는 보조 스트림 생성
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		
		//3. 여러 타입의 참조 객체를 한 파일에 저장(객체의 직렬화)
		try (fos; oos) {
			oos.writeObject(10);						//Integer 객체 저장
			oos.writeObject(3.14);						//Double 객체 저장
			oos.writeObject(new int[] { 1, 2, 3 });		//배열 객체 저장
			oos.writeObject(new String("홍길동"));		//문자열 객체 저장
			
			//4. 출력스트림이니 자원 해제하기 전에 강제 flush 수행
			oos.flush();	
		} //try-with-resources
		
		//5. 자원 해제
//		oos.close();	//(1) 보조스트림부터 먼저 닫고 
//		fos.close();	//(2) Base 스트림을 닫음
//		==============
		//1. 파일에 대한 바이트 기반의 Base 입력스트림 생성
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		
		//2. 객체 역직렬화 과정을 수행하는 보조 스트림 생성
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//3. 파일에 저장된 직렬화된 바이트열 => 다시 개별 객체로 환원시킴(역직렬화)
		try(fis; ois;) {
			Integer obj1 = (Integer) ois.readObject();	//리턴타입이 Object이기 때문에 강제 형변환 필요
			Double obj2 = (Double) ois.readObject();
			int[] obj3 = (int[]) ois.readObject();
			String obj4 = (String) ois.readObject();
		
		
			System.out.println(obj1);
			System.out.println(obj2);
			System.out.println(Arrays.toString(obj3));
			System.out.println(obj4);
		} //try-with-resources
	} //main
} //end class
