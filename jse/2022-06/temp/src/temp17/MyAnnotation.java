package temp17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//새로이 선언한 어노테이션을, 자바 타입의 어느 부분에 적용(즉 붙일 수)할 수 있는지를 결정.
@Target(  {						
	ElementType.METHOD,				//클래스의 메소드에 적용
	ElementType.CONSTRUCTOR,		//클래스의 생성자에 적용
	ElementType.FIELD,				//클래스의 필드에 적용
	ElementType.PARAMETER,			//클래스의 메소드의 매개변수에 적용
	ElementType.LOCAL_VARIABLE,		//클래스의 지역변수에 적용
	ElementType.ANNOTATION_TYPE,	//어노테이션을 선언하는 선언부에 적용
	ElementType.TYPE,				//참조타입 선언부에 적용
	ElementType.PACKAGE,
}  )	//자바 표준 라이브러리 안에 있는 어노테이션. 
//우리가 설정한 어노테이션을 어디에 붙일 수 있을지를 결정하는 열거상수를 지정하는 어노테이션
//{}는 배열 타입의 리터럴 만든 것. 원소가 한 개인 배열. (Target의 value가 ElementType의 배열을 받으므로)
//일반 배열에서 원소가 하나라고 해서 중괄호 기호를 생략할 수 없지만 어노테이션에서는 생략 가능.
//일반 배열과 어노테이션 모두에서 원소 다음에 ',' 가능.


//적용된 어노테이션 정보가 언제까지 유지될 것인가를 결정.
//1. RetentionPolicy.SOURCE => 컴파일 끝나면 소스에는 남아있지만 .class파일에는 없다.
//	 => 어노테이션이 적용된 자바소스파일에는 유지되지만,
//		자바 컴파일이 종료되고, *.class 파일이 생성되면,
//		이 .class파일 안에는 어노테이션 정보가 모두 사라짐.
//2. RetentionPolicy.CLASS
//	 => 컴파일이 끝나고 난 후에 생성되는 *.class 파일 안에도
//		그대로 어노테이션 적용 정보가 남아 있게 하겠다 라는 의미
//	 => (***) *.class 파일 안에는 어노테이션 정보가 있긴 하지만, 한마디로 "사용 불가"
//	    그래서 의미가 별로 없어서 잘 안 쓰임.
//3. RetentionPolicy.RUNTIME
//   => 컴파일이 끝나고 난 후에 생성되는 *.class 파일 안에도
//	 그대로 어노테이션 적용 정보가 남아 있게 하겠다 라는 의미
//   => (***) *.class 파일 안에 어노테이션 정보가 있고, 
//		자바프로그램이 JVM에 의해 실행 중일 때에도 적용된 어노테이션 정보를 그래도 사용 가능.
//	 => 대부분의 어노테이션은 런타임으로. 추가적인 정보를 제공한다는 의미 때문에
@Retention(RetentionPolicy.RUNTIME)

//ANNOTATION_TYPE
//@MyAnnotation			//ok 	//완성하지 않은 어노테이션 자신에게 붙여도 된다.
//@MyAnnotation public  //ok	//접근제한자 왼쪽, 오른쪽 다 붙일 수 있음.
//public @MyAnnotation	//ok
public 
//@interface @MyAnnotation	//xx //클래스 선언부의 한 몸 깨뜨림.
@interface MyAnnotation {
	
	//(1) 어노테이션 속성이 아래와 같이, default 구문으로 기본값이 지정되어 있으면,
	//어노테이션 "적용 시" 속성에 값(데이터)을 설정하지 않아도 되고, 설정해도 된다.
	//(2) 하지만, default 구문이 없는 어노테이션 속성은 어노테이션 "적용 시"
	//반드시 값(데이터)을 설정해 줘야 한다. (***)
	//(3) 어노테이션 속성 중, 타입과 상관 없이, 그 속성의 이름이 "value"인 속성을
	//해당 어노테이션의 "기본" 속성이라고 한다.
	//(4) 만일 어노테이션이 기본속성인 "value"에만 값(데이터)을 설정하려고 한다면
	//어노테이션 "적용 시", 굳이 "속성의 이름 = 값" 형태로 해도 되고,
	//속성의 이름을 "생략"한 채로, 값(데이터)만 지정할 수도 있다.
	
	//아래 구문이 이 어노테이션이 적용된 곳에 제공하는 "메타데이터(MetaData)".
	String value() default "-";		//추가 정보, 메타데이터
	int number() default 15;		//속성 앞에는 접근 제한자x

} //end @interface




