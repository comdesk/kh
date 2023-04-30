package temp34;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ChildProductAndStorageExample {

	//제네릭 타입의 자식 클래스나 구현 클래스를 이용한 예제
	public static void main(String[] args) {
		//1. 제네릭 타입의 자식 클래스로부터 인스턴스 생성
		ChildProduct<Tv, String, String> product = new ChildProduct<>();
		
		product.setKind(new Tv());
		product.setModel("Smart TV");
		product.setCompany("Samsung");
		
		log.info(product);
		
//		----------------
		
		//2.제네릭 타입의 구현 클래스로부터 인스턴스 생성
		Storage<Tv> storage = new StorageImpl<>(100);	//다형성-1
		
		storage.add(new Tv(), 0);	//다형성-2
		Tv tv = storage.get(0);		//다형성-2
		
		log.info(storage);
	} //main

} //end class





