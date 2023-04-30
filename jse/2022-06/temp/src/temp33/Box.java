package temp33;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Setter
@Getter
@ToString	//이 객체를 출력하면 필드의 이름과 값을 보여줌.
@NoArgsConstructor
//Generic 문법을 사용하기 전에 종이 박스를 모델링한 클래스 선언
public class Box {
	private Object object;	//상자에 넣을 모든 종류(=참조타입)의 객체를 저장할 필드(하나의 물건만 저장)
							//여러 개 저장하려면 배열로

	
//	=====================================
	
	
	
//	public void setObject(Object object) {			//매개변수의 다형성-1	//Setter
//		log.trace("setObject({}) invoked.", object);
//		
//		this.object = object;	//형변환x, Rvalue도 Object 타입
//	} //set
//	
//	public Object getObject() {						//Getter
//		log.trace("getObject() invoked.");
//		
//		return object;
//	} //get
} //end class




