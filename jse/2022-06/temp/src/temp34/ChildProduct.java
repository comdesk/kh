package temp34;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
//제네릭 타입의 클래스를 상속하는 자식 제네릭 타입의 클래스 선언
public class ChildProduct<T, M, C> extends Product<T, M> {	//<T,M,C>가 타입 파라미터 선언부
	@Getter @Setter private C company;						//<T,M>은 타입 파라미터 선언부x
} //end class
