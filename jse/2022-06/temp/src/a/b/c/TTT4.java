package a.b.c;

import lombok.extern.log4j.Log4j2;

@Log4j2	
public class TTT4 {

	public static void main(String[] args) {
		InterfaceA ia = new InterfaceA() {
			public int age = 20;
			public String name = "홍길동";
			
//			public TTT4$1() {
//				
//			}
			
			public void instanceMethod() {
				log.trace("instanceMethod() invoked.");
			} //instanceMethod
			
			public static void staticMethod() {
				log.trace("staticMethod() invoked.");
			} //staticMethod
			
			@Override
			public void methodA() {
				log.trace("methodA() invoked.");
				log.info("\t + name: {}, age: {}", this.name, this.age);
				
				this.instanceMethod();
				this.staticMethod();
				
			} //methodA
			
		}; //익명구현객체 
		
		ia.methodA();
		log.info(ia);
		
//		log.info("\t + name: {}, age: {}", ia.name, ia.age);
//		ia.instanceMethod();
//		ia.staticMethod();
		ia.methodA();
	} //main

} //end class






