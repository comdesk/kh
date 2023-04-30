package org.zerock.myapp.gson;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.zerock.myapp.domain.Bar;
import org.zerock.myapp.domain.Foo;

import com.google.gson.Gson;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GsonTests {

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("단위테스트1: Java Object => JSON 변환(Serialization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSerilaize() {
		
		log.trace("testSerilaize() invoked.");
		
//		자바객체 => JSON 문자열로 변환(Serialization)
		
		Foo foo = new Foo();
		foo.setId(300);
		foo.setName("Yoseph");
		
		log.info("\t1. foo: {}", foo);
		
//		-----------
		
		Gson gson = new Gson();
		String json = gson.toJson(foo);
		
		log.info("\t2. json: {}", json);
		
	} //testSerilaize
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("단위테스트2: JSON => Java Obeject 역변환(De-serilalization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testDeserilaize() {
		
		log.trace("testDeserilaize() invoked.");
		
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
		String json = "{'id':300,'name':'Yoseph'}";	//json에서는 ''로 바꿔줘도 됨.
		
//		----
		Gson gson = new Gson();
		
		Bar obj = gson.fromJson(json, Bar.class);	//필드 이름, 타입이 같기 떄문에 클래스명 상관 없다.
		log.info(obj);
	} //testDeserilaize
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("단위테스트3: JSON => Java Obeject 역변환(De-serilalization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testDeserilaize2() {
		
		log.trace("testDeserilaize2() invoked.");
		
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
		String json = """
				{ 'response': { 'header': [{ 'resultCode': ['00'], 'resultMsg': ['NORMAL SERVICE.'] }] } }
				"""; 
		//""" 든 "든 상관없이 잘 된다. 포맷팅 하든 한 줄이든 잘 바뀜.
		
		log.info("\t+json: {}", json);

		Gson gson = new Gson();
		
		TTT obj = gson.<TTT>fromJson(json, TTT.class);	//필드 이름, 타입이 같다면, 클래스명 상관 없다.
		log.info(obj);
	} //testDeserilaize2
} //end class

//Gson 변환 라이브러리는, 역직렬화 시에 바이트 코드 조작을 통해,
//접근 권한이 없는 필드에 값을 바로 넣어버린다.(Like Lombok)

//@Data  빼도 상관 없음.
@ToString
class JJJ {
	private String[] resultCode;
	private String[] resultMsg;
} //JJJ

//@Data
@ToString
class KKK {
	private List<JJJ> header;
} //KKK

//@Data
@ToString
class TTT {
	private KKK response;
} //TTT



