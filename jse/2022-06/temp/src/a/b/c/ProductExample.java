package a.b.c;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductExample {

	public static void main(String[] args) {
//		Product<TV, String> product1 = new Product<TV, String>();
		Product<TV, String> product1 = new Product<TV, String>();
		log.info("1. Setter 메소드 호출 전: {}", product1);
		
		product1.setKind(new TV());
		product1.setModel("스마트 TV");
		log.info("2. Setter 메소드 호출 후: {}", product1);
		
		TV tv = product1.getKind();
		String model = product1.getModel();
		log.info("3. Model: {}", model);

	} //main

} //end class
