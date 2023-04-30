package temp34;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Product<T, M> {	//부모 역할을 하는 제네릭 타입 클래스
	private T kind;
	private M model;

} //end class

//==========================================

@ToString
@NoArgsConstructor
class Tv {
	;;
} //end class