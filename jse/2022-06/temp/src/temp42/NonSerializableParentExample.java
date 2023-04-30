package temp42;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NonSerializableParentExample {
	//핵심포인트: 부모/자식 상속 관계에 있는 자식 객체를 직렬화할 때,
	//			  과연 부모 객체도 함께 직렬화에 포함되는가?
	//(1) Non-Serializable한 부모 객체 단독으로 직렬화 수행 => 바로 예외 발생: NotSerializableException
	//(2) 하지만 Serializable한 자식 객체를 직렬화하면 부모객체도 자식객체를 따라서 직렬화에 포함
	//	  그럼에도 불구하고 Non-Serializable한 부모 객체가 직렬화될 때, 오류가 발생하지는 않는다.
	//	  단지 부모객체의 모든 필드는 직렬화 대상에서 제외될 뿐
	//(3) (2)의 문제가 왜 문제가 되는가?
	//	  보통 우리가 부모로 선택하는 타입은 주로 표준 라이브러리에 있는 클래스이거나 아니면
	//	  제 3자가 만든 클래스를 상속하는 경우가 주이다 보니 우리에게 소스가 없다.
	//	  소스가 없단 얘기는 Serializable하게 수정할 수도 없단 의미
	//	  그럼 소스가 없는 부모 클래스를 다시 Serializable하게 만들어줄 방법은 없는가? => 없다.
	//	  다행스러운 것은 "간접적인 방법"으로 Non-serializable한 부모 객체를 직렬화시킬 수는 있다.
	//	  => 이게 Child 클래스에 있는 메소드이다.
	public static void main(String[] args) throws Exception {
		//1. Base 스트림 생성
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		//2. 보조 스트림 생성
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		
		try(fos; oos;) {
			//3. 직렬화 대상 "자식" 객체 생성
			Child child = new Child();	
			child.field1 = "홍길동";	//부모 객체가 생속해준 필드
			child.field2 = "홍삼원";	//자식 객체 고유의 필드
			
			//4. 직렬화 수행
			oos.writeObject(child);		//과연 부모 객체도 함께 직렬화되는가?	여기서 콜백메소드 실행됨.
			oos.flush();
		} //try-with-resources
		
		//수행 결과 오류가 안 났다.
		
//		=================
		
		//1. Base 스트림 생성
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		
		//2. 보조 스트림 생성
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try(fis; ois;) {
			//3. 객체의 역직렬화 수행
			Child v = (Child) ois.readObject();
			
			//4. 검증
			log.info("1. field1: {}", v.field1);	//field1: 부모객체가 물려준 필드("홍길동") => null
			log.info("2. field2: {}", v.field2);	//filed2: 자식객체의 고유필드("홍삼원")	=> 홍삼원
		} //try-with-resources
	} //main
} //end class





