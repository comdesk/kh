package org.zerock.myapp.genson;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

import com.owlike.genson.Genson;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GensonTests {

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("단위테스트1: Java Object => JSON 변환(Serialization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSerilaize() {
		
		log.trace("testSerilaize() invoked.");
		
//		=============================================
//		자바객체 => JSON 문자열로 변환(Serialization)
//		=============================================
		Foo foo = new Foo();
		foo.setId(100);
		foo.setName("Yoseph");
				
		log.info("\t+ foo: {}", foo);
		
		Genson genson = new Genson();
		String json = genson.serialize(foo);
		
		Objects.requireNonNull(json);
		log.info("\t+ json: {}", json);
	} //testSerilaize
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("단위테스트2: JSON => Java Obeject 역변환(De-serilalization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testDeserilaize() {
		
		log.trace("testDeserilaize() invoked.");
		
//		=============================================
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
//		=============================================
		
//		String json = "{\"id\":100,\"name\":\"Yoseph\"}";	//OK
//		String json = "{'id': 100, 'name': 'Yoseph'}";	//XX
		String json = """							
				{"id": 100, "name": "Yoseph"}
				""";									//OK
		
		Genson genson = new Genson();
		Bar bar = genson.deserialize(json, Bar.class);
		
		assertNotNull(bar);
		log.info("\t+ bar: {}", bar);
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
				{ "response": { "header": [{ "resultCode": ["00"], "resultMsg": ["NORMAL SERVICE."] }] } }
				"""; 
//		String json = "{ \"response\": { \"header\": [{ \"resultCode\": [\"00\"], \"resultMsg\": [\"NORMAL SERVICE.\"] }] } }";
		
		log.info("\t+json: {}", json);

		Genson genson = new Genson();
		
		TTT obj = genson.deserialize(json, TTT.class);	//필드 이름, 타입이 같다면, 클래스명 상관 없다.
		assertNotNull(obj);		
		log.info("\t + obj: {}", obj);
	} //testDeserilaize2
} //end class

//@Data  빼도 상관 없음.
@ToString
class JJJ {
	public List<String> resultCode;
	public List<String> resultMsg;
} //JJJ

//@Data
@ToString
class KKK {
//	private List<JJJ> header;
//	private ArrayList<JJJ> header;
	public JJJ[] header;	//NEW: OK
} //KKK

//@Data
@ToString
class TTT {
	public KKK response;
} //TTT






