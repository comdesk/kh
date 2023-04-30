package temp33;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor(access=lombok.AccessLevel.PUBLIC)
@Getter(lombok.AccessLevel.PUBLIC)
@Setter(lombok.AccessLevel.PUBLIC)
//멀티-타입 파라미터의 사용법: 즉, 타입 파라미터가 1개 이상인 경우
//							   용법은 타입 파라미터가 1개일 때와 동일하다.
//							   그저 타입 파라미터 개수/순서/의미에 맞게 "구체타입"을 지정해주면 된다.
//							   (언제? 제너릭 타입을 "사용할 때")
public class Product<T, M> {
	private T kind;
	private M model;	//필드 이름이 모델이니까 M
						//멀티 타입 파라미터일 때는 필드 이름에 맞게 타입 파라미터 이름을 지정
	
} //end class




