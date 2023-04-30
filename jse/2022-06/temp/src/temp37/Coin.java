package temp37;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
//동전을 모델링해서 만든 클래스
public class Coin {
	@Getter(lombok.AccessLevel.PUBLIC) //롬복은 기본적으로 public이므로 AccessLevel로 접근제한자 바꿀 수 있음. 
	private int value;
	
} //end class
