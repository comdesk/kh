package temp33.next;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

//제네릭 타입 클래스 선언
public class Box<T> {
	private T obj;

} //end class
