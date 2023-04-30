package temp42;

import java.io.Serializable;

import lombok.NoArgsConstructor;

//이 클래스 역시 Serializable함 => 객체의 직렬화 대상이 됨
@NoArgsConstructor
public class ClassB implements Serializable {
	int field1;
} //end class

