package a.b.c;

import java.util.Arrays;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
public class Closure {
	private static MyInterface anonymousObj;
	
	public static void main(String[] args) {
		log.trace("main({}) invoked.", Arrays.toString(args));
		Closure obj = new Closure();
		obj.run("dog");
		anonymousObj.instanceMethod();
		anonymousObj.instanceMethod();

	} //main
	
	public void run(String name) {
		log.trace("run({}) invoked.", name);
		
		int age = 23;
//		age = 18;
//		name = "ghd";
		double weight = 58.9;
		weight = 50;
		anonymousObj = new MyInterface() {

			@Override
			public void instanceMethod() {
				log.trace("instanceMethod() invoked.");
				
				log.info("\t + this: {}", this);
				
				log.info("\t + name: {}, age: {}", name, age);
				
			} //instanceMethod
			
		}; //익명구현객체
		
		log.info("+anonymousObj: {}", anonymousObj);
		anonymousObj.instanceMethod();
	} //run
	
	
} //end class










