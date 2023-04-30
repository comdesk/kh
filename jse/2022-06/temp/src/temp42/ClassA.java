package temp42;

import java.io.Serializable;

import lombok.NoArgsConstructor;

//java.io.Serializable Tag interface를 상속(implements)하고 있는
//클래스에서 생성한 객체만이 객체의 직렬화/역직렬화의 대상이 됨
@NoArgsConstructor
public class ClassA implements Serializable {
	//인스턴스 필드
	int field1;
	transient int field4;	//***: 객체의 직렬화에서 제외됨(by transient)
	
	ClassB field2 = new ClassB();	//(1)다른 참조타입을 필드로 가지는 부품 필드(집합관계): 객체의 직렬화 대상인가?(***)
	
	//정적필드
	//정적필드는 애시당초 객체의 직렬화 대상 자체가 될 수 없다
	//왜? 직렬화할 객체의 소속이 아니라 메소드 영역의 Clazz 객체의 소속이기 때문에
	//transient 키워드는 붙일 수는 있지만, 아무런 효과가 없다.
	static transient int field3;	//(2)Clazz 소속인 정적필드도 객체의 직렬화 대상인가?(***)
	
} //end class
