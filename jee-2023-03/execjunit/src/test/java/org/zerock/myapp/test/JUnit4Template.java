package org.zerock.myapp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

//테스트 클래스를 선언시 지켜야 할 규칙:
//(1) 반드시 매개변수 없는 기본 생성자를 가져야 함. (프레임워크가 객체생성하기 위해)(***)
//(2) 사용가능한 JUnit v4 Annotations:
//		a. @Before : 단위 테스트 수행 전, 전처리
//		b. @After  : 단위 테스트 수행 후, 후처리
//		c. @Test   : 단위 테스트
//(3) 단위테스트의 메소드 이름은 반드시 접두사로 'test~'를 붙여야 함.(***)
//(4) JUnit v4.x와 v5.x를 pom.xml 파일에 동시에 설정해서는 안 된다.(***)
//	  만일 이렇게 양랍시키면, Run configuration ... 메뉴에서 기본 JUnit 버전이
// 	  높은 버전으로 됨 .이를 수정해가면서 수행해야 함.
//(5) 테스트 클래스는 POJO로 개발돼야 한다.(***)
//(6) 위(2)에서 언급된 3개의 어노테이션이 붙은 메소드는 모두 public이어야 함.(***)
//(7) 여러 개의 단위 테스트 메소드의 수행 순서는 문자열 정렬순으로 된다. (사전 순서) (***)
//(8) 위의 3개의 메소드에서 로직 수행 시 발생하는 예외는 절대 예외처리하지 말고,
//	  JUnit Test Framework로 throw 하도록 해야 한다.(***)

@NoArgsConstructor
@Log4j2
public class JUnit4Template {	//POJO: Plain Old Java Object.
	
	private int caseNumber;
	
	@Before
	public void before() {	//전처리 (반복 수행 / 단위 테스트마다)
		
		log.trace("before() invoked.");
		//모든 단위테스트 앞서서 미리 수행되기 때문에 케이스별로 수행x
		//=> 테스트 자원을 확보하는 코드가 주로 옴(예: 데이터소스 얻기 등)
	} //before
	
	@After
	public void after() { //후처리 (반복 수행 / 단위 테스트마다)
		
		log.trace("after() invoked.");
		
		//테스트 자원을 해제하는 코드가 주로 옴.
		
		switch(caseNumber) {	//후처리를 단위테스트 케이스별로 수행
			case 1: break;
			case 2: break;
			case 4: break;
			default: ;;
		} //switch
	} //after
	
	@Test
	public void testCase1() {	//단위 테스트
		
		log.trace("testCase1() invoked.");
		this.caseNumber = 1;
	} //testCase1
	
	@Test(timeout=1000) //milliseconds: 시간 제약 두어서 테스트 되어야 하는 경우에 적용
	public void testCase4() {	//단위 테스트
		
		log.trace("testCase4() invoked.");
		this.caseNumber = 4;
	} //testCase3
	
	@Test
	public void testCase2() {	//단위 테스트
		
		log.trace("testCase2() invoked.");
		this.caseNumber = 2;
	} //testCase2
} //end class






