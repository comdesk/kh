package temp34;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2
//타입 파라미터를 1개 가지는 제네릭 타입 클래스
//목적: 수강 신청 가능한 과정을 모델링한 클래스
public class Course<T> {
	@Getter private String name;	//과정명
	@Getter private T[] students;			//수강신청한 모든 학생들을 저장하는 배열
	
	@SuppressWarnings("unchecked")	//체크할 수 없는 경고를 표시하지 말라.
	public Course(String name, int capacity) {
		log.trace("constructor({}, {}) invoked.", name, capacity);
		
		//인스턴스 필드의 초기화
		this.name = name;
		
//		this.students = new T[capacity];	//XX: 배열 객체 생성 시 원소의 타입은 제네릭의 타입 파라미터로 지정 불가
		
		//그럼 어떻게 T타입을 원소로 가지는 배열 객체를 생성할 수가 있을까?
		//1. Object[] 배열 우선 생성
		//2. Object[] 배열 => T[] 배열로 강제 형변환
		students = (T[]) (new Object[capacity]);	//***주의*** 선언이 분리된 배열 new로 생성
		//정해지지 않은 타입인 T로 형변환하다보니 옳은지 체크할 수 없어 경고가 뜸.
	} //constructor
	
//	public T[] getStudent() { return students; }
	
	//과정에 수강신청한 학생을 배열의 원소로 넣어주는 메소드
	//대전제: 자바의 배열은 한 번 생성하면 그 크기(길이)와 원소의 타입을 변경 불가
	public void add(T t) {
		log.trace("add({}) invoked.", t);
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {	//null을 값으로 가지는 배열의 원소에 학생을 추가
				students[i] = t;
				
				break;					//추가 됐으면 바로 for문을 빠져나옴.
			} //if
		} //for
	} //add

} //end class






