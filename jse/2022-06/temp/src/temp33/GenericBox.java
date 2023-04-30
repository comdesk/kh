package temp33;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@ToString
@Log4j2
//@Setter		//롬복은 T로 게터, 세터를 만들 수 있다.
//@Getter		//이 당시엔 무슨 타입일지 모른다. 미래 시점에 지정해도 잘 작동한다.
public class GenericBox<T> {	//Type Parameter T를 하나 가지는 제네릭 타입의 클래스
								//이 클래스 참조타입을 "사용 시" "구체타입을 지정"
	private T t;
	
	
	public T get() {
		log.trace("get() invoked.");
		
		return t;
	} //get
	
	public void set(T t) {
		log.trace("set({}) invoked.", t);
		
		this.t = t;
	} //set
} //end class







