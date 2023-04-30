package temp42;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableExample {
	
	//핵심포인트: 우리가 선언한 클래스의 필드가 여러 유형일 때, 각 필드는 객체의 직렬화 시에 어떻게 될까
	public static void main(String[] args) throws Exception {
		//1. Base 스트림 생성
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		//2. 객체의 직렬화 수행하는 보조스트림 생성
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		try(fos; oos;) { 
			//3.ClassA, ClassB를 이용한 객체의 직렬화 수행
			ClassA classA = new ClassA();	//객체 생성
			
			//필드 초기화
			//정작 객체 직렬화 시 더 궁금한 것은 2번, 3번 필드임.
			classA.field1 = 1;				//평범한 인스턴스 필드
			classA.field2.field1 = 2;		//부품(집합) 관계 필드(ClassB) ***
			classA.field3 = 3;				//정적 필드 ***
			classA.field4 = 4;				//transient 키워드가 붙은 필드(직렬화에서 제외)
			
			//4. 객체의 직렬화 수행(to 파일)
			oos.writeObject(classA);
			
			oos.flush();	//강제 flush
		} //try-with-resources
		
//		=================
		
		//핵심포인트: (1) 정적필드는 과연 직렬화 대상이 될 수 있는가?
		//			  (2) transient 필드도 직렬화에서 제외가 정말 되었는지?
		//			  (3) 또 다른 클래스 타입의 필드(부품) 같이 직렬화되는가?
		//				  => 부품필드 역시 다른 클래스 타입일지라도 함께 직렬화됨.
		
		//객체의 역직렬화 과정을 통해서 우리가 위에서 궁금해 하던 부분을 확인해야 한다.
		
		//1. Base 스트림 생성
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		
		//2. 객체 역직렬화 보조 스트림 생성
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//3. 원래 객체로 환원
		ClassA v = (ClassA) ois.readObject();
		
		//4. 환원된(역직렬화된) 객체의 필드를 통해서 우리가 궁금해하는 부분을 확인
		System.out.println("field1: " + v.field1);	
		System.out.println("field2.field1: " + v.field2.field1);
		System.out.println("field3: " + v.field3);
		System.out.println("field4: " + v.field4);
		
		ois.close(); fis.close();
	} //main
} //end class




