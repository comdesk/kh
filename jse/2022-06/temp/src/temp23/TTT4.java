package temp23;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT4 {
	public static void main(String[] args ) {
		
		//InterfaceA 인터페이스에 대한 "익명구현객체"의 생성
		InterfaceA ia = new InterfaceA() {	//다형성-1
			//필드 선언
			public int age = 20;
			public String name = "홍길동";
			
			//생성자 선언
//			public ????() {	} 
			//XX: 익명클래스이기 때문에 컴파일러가 만든 클래스이름과 동일하게 선언해야 하는데 
			//	  이름을 알 수가 없다...
			
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
				
				this.instanceMethod();	//OK: 인스턴스 메소드 호출
				this.staticMethod();	//OK: 정적 메소드 호출(클래스이름 몰라서 정적멤버답게 못씀)
			} //methodA
			
		};	//익명구현객체생성
		
		ia.methodA(); //다형성-2: 재정의된 자식 익명구현객체의 메소드 호출됨
		log.info(ia);
		
		//1. 필드 사용
//		log.info("name: {}, age: {}", ia.age, ia.name);		//XX: 필드 사용 불가
		
		//2. 인스턴스 메소드 호출
//		ia.instanceMethod();								//XX: 메소드 호출 불가
		
		//3. 정적 메소드 호출
//		ia.staticMethod();									//XX: 메소드 호출 불가
		//그럼 정적멤버는 정적멤버답게 사용하자
		//어떻게?? => 타입명(클래스명)을 알아야 하는데...??
		
		//4. 생성자 호출
		
//		==============
		
		InterfaceA ia2 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()2 invoked.");
				
			} //methodA
			
		};
		
		ia2.methodA();
		log.info(ia2);
		
//		==============
		
		InterfaceA ia3 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()3 invoked.");
				
			} //methodA
			
		};
		
		ia3.methodA();
		log.info(ia3);
		
//		===============
		
		InterfaceA ia4 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()4 invoked.");
				
			} //methodA
			
		};
		
		ia4.methodA();
		log.info(ia4);
		
//		========
		
		InterfaceA ia5 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()5 invoked.");
				
			} //methodA
			
		};
		
		ia5.methodA();
		log.trace(ia5);
		
//		===========
		
		InterfaceA ia6 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()6 invoked.");
				
			}
			
		};
		
		ia6.methodA();
		log.info(ia6);
		
//		===========
		
		InterfaceA ia7 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()7 invoked.");
				
			}
			
		};
		
		ia7.methodA();
		log.info(ia7);
		
//		===========
		
		InterfaceA ia8 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()8 invoked.");
				
			} //methodA
			
		};
		
		ia8.methodA();
		log.info(ia8);
		
//		=============
		
		InterfaceA ia9 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()9 invoked.");
				
			} //methodA
			
		};
		
		ia9.methodA();
		log.info(ia9);
		
//		============
		
		InterfaceA ia10 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()10 invoked.");
				
			} //methodA
			
		};
		
		ia10.methodA();
		log.info(ia10);
		
//		============
		
		InterfaceA ia11 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()11 invoked.");
				
			} //methodA
			
		};
		
		ia11.methodA();
		log.info(ia11);
		
//		===========
		
		InterfaceA ia12 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()12 invoked.");
				
			} //methodA
			
		};
		
		ia12.methodA();
		log.info(ia12);
		
//		========
		
		InterfaceA ia13 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()13 invoked.");
				
			} //methodA
			
		};
		
		ia13.methodA();
		log.info(ia13);
		
//		===========
		
		InterfaceA ia14 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()14 invoked.");
				
			} //methodA
			
		};
		
//		===========
		
		InterfaceA ia15 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()15 invoked.");
				
			} //methodA
			
		};
		
		ia15.methodA();
		log.info(ia15);
		
//		===========
		
		InterfaceA ia16 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()16 invoked.");
				
			} //methodA
			
		};
		
		ia16.methodA();
		log.info(ia16);
		
//		==========
		
		InterfaceA ia17 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()17 invoked.");
				
			} //methodA
			
		};
		
		ia17.methodA();
		log.info(ia17);
		
//		=========
		
		InterfaceA ia18 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()18 invoked.");
				
			} //methodA
			
		};
		
		ia18.methodA();
		log.info(ia18);
		
//		===========
		
		InterfaceA ia19 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()19 invoked.");
				
			} //methodA
			
		};
		
		ia19.methodA();
		log.info(ia19);
		
//		=========
		
		InterfaceA ia20 = new InterfaceA() {

			@Override
			public void methodA() {
				log.trace("methodA()20 invoked.");
				
			} //methodA
			
		};
		
		ia20.methodA();
		log.info(ia20);
	} //main
} //end class












