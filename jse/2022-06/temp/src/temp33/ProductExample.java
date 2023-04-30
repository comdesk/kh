package temp33;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductExample {
	
	//멀티-타입 파라미터를 가지는 제네릭타입 클래스의 예제
	public static void main(String[] args) {
		//1. 제네리타입의 객체를 생성 시, "구체타입" 지정(한 개든, 두 개든 같음)
//		Product<TV, String> product1 = new Product<TV, String>();	//@till 7
		Product<TV, String> product1 = new Product<>();				//@since 8
		log.info("1. Setter 메소드 호출 전: {}", product1);
		
		//2. Setter 메소드 호출
		product1.setKind(new TV());				//제품의 종류 설정
		product1.setModel("스마트 TV");			//제품의 모델 설정
		log.info("2. Setter 메소드 호출 후: {}", product1);
		
		//3. Getter 메소드 호출
		TV tv = product1.getKind();				//제품의 종류 획득
		String tvModel = product1.getModel();	//제품의 모델 획득
		log.info("3. tvModel: {}", tvModel);
		
	} //main

} //end class
