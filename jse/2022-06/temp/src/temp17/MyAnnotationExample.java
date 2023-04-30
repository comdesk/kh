package temp17;

import java.lang.reflect.Method;

public class MyAnnotationExample {
	
	//자바 리플렉션 API(Java Reflection API)를 이용하여
	//어노테이션의 메타데이터를 이용하여, 실행 시 특수한 기능을 구현해보자.
	public static void main(String[] args) {
		
//		=================================================================
		//Step1. Service 클래스의 "Clazz" 객체로부터 
		//클래스 안에 선언된 모든 메소드 정보를 배열로 얻음
//		=================================================================
		Class clazz = Service.class;
		Method[] declaredMethods = clazz.getDeclaredMethods();	//Declared가 들어가야 선언한 모든 메소드를 얻을 수 있음.
		//배열의 타입이 메소드. 메소드가 원소인 배열
		//Method는 메소드를 보고 객체 모델링한 클래스
		
//		=================================================================
		//Step2. 배열(Step1 배열)을 순회하면서, Service 클래스에 선언된 각 Method에
		//		 MyAnnotation이 적용되어 있는지 확인.
		//		 (참고: 배열 순회를 위해 Enhanced for문을 이용)
//		=================================================================
		for(Method method : declaredMethods) {
			
//			=================================================================
			//Step3. MyAnnotation이 현재 메소드에 적용되었는지 확인
//			=================================================================
			if(method.isAnnotationPresent(MyAnnotation.class)) {	//boolean getter
				//어노테이션이 있는지 알기 위해 그 어노테이션의 클래쯔 객체를 줌.
				//어노테이션이 있는지 불린 값으로 반환해줌.
//				=================================================================
				//Step4. 현재 메소드에 MyAnnotation이 적용되어 있다면,
				//		 해당 어노테이션을 얻어오기.
//				=================================================================
				MyAnnotation myAnnotation =
						method.getAnnotation(MyAnnotation.class);
								
//				=================================================================
				//Step5. 현재 메소드 이름을 콘솔에 출력
//				=================================================================
				System.out.println("[" + method.getName() + "]");
				
				//=================================================================
				//Step6. 현재 메소드에 적용된 MyAnnotation의 속성으로 제공되는
				//		 메타데이터를 이용하여, 메소드 호출로그를 자동으로 만들어 출력
				//		 (이것이 바로, MyAnnotation의 메타데이터를 이용하는 목적임)
				//=================================================================
				//Service에서 어노테이션 줄 때 값 안 줌 => 디폴트 적용
//				------------------------
				//Step6-1. 구분선 출력
//				------------------------
				for(int i = 0; i < myAnnotation.number(); i++) {	//어노테이션을 쓸 때 호출해서 쓰는것. => ()
					System.out.print(myAnnotation.value());
				} //for
				
				System.out.println();	//하나의 빈 행 출력
				
//				------------------------
				//Step6-2. 현재 순회하는 메소드를 직접 호출
//				------------------------
				try {
					method.invoke(new Service());
				} catch (Exception e) {;;}	//예외 처리
				
				System.out.println();
			} //if
		} //enhanced for
			
	} //main
} //end class
