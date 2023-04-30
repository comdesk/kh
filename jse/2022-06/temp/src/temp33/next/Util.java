package temp33.next;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
//UtilityClass
//아래와 같이 특정 기능들을 수행하는 "정적"메소드들로 구성된 클래스를
//보통 "유틸리티 클래스"라고 부른다.
//모델링이 아닌 기능들을 모아놓은 클래스
public class Util {
	
	//제네릭 메소드 선언 (제네릭 x타입x 메소드)
	public static <T> Box<T> boxing(T t) {	//제네릭 타입의 클래스 Box<T>의 T도 구체타입으로 바뀜.
				//<T>: 타입 파라미터 선언부 / T: 타입 파라미터
		Box<T> box = new Box<T>();
		
		box.setObj(t);
		
		return box;
	} //boxing
	
//	========================
	public static <T extends Number> int compare(T t1, T t2) {
		log.trace("compare({}, {}) invoked.", t1, t2);
		
		double v1 = t1.doubleValue();	//구체 타입에 doubleValue 메소드가 없으면 오류. => 타입 제약 필요
		System.out.println(t1.getClass().getName());
		
		double v2 = t2.doubleValue();	//Number에서 상속되는 메소드
		System.out.println(t2.getClass().getName());
		
		//자바 표준 라이브러리에서는 두 개의 기본타입의 값을 비교할 때
		//비교 결과를 아래와 같이 통일성 있게 구현하고 있다.:
		//1. 만일 v1 < v2라면,	=> 마이너스 값 반환(보통 -1로 반환)
		//2. 만일 v1 == v2라면,	=> 0 반환
		//3. 만일 v1 > v2라면,	=> 플러스 값 반환(보통 +1로 반환)
		return Double.compare(v1, v2);	//크기 비교
	} //compare
	
} //end class





















