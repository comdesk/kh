package temp38;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class UsingLocalVariable {

	//클로저 현상은 람다식에서도 발생한다.
	void method(final int arg) {	//arg는 final 특성을 가짐
		final int localVar = 40;	//localVar는 final 특성을 가짐

		//arg = 31;			//final 특성 때문에 수정 불가
		//localVar = 41;	//final 특성 때문에 수정 불가
		
		MyFunctionalInterface4 fi = () -> {	//람다식
			//로컬변수 사용 => 익명구현객체의 생명주기와 지역변수의 생명주기에 차이가 있다
			log.info("arg: {}", arg);
			log.info("localVar: {}", localVar);
			
		}; //익명구현객체 생성/대입: 다형성-1
		
		fi.method();	//w재정의된 메소드 호출: 다형성-2
	} //method
} //end class



