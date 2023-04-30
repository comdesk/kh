package org.zerock.myapp.jackson;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JacksonTests {

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("단위테스트1: Java Object => JSON 변환(Serialization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSerilaize() throws JsonProcessingException {
		
		log.trace("testSerilaize() invoked.");
		
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
		Foo foo = new Foo();
		foo.setId(700);
		foo.setName("Pyramide");
		log.info("\t+ foo: {}", foo);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(foo);
		
		Objects.requireNonNull(json);
		log.info("\t+ json: {}", json);
	} //testSerilaize
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("단위테스트2: JSON => Java Obeject 역변환(De-serilalization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testDeserilaize() throws JsonMappingException, JsonProcessingException {
		
		log.trace("testDeserilaize() invoked.");
		
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
//		String json = "{'id':700,'name':'Pyramide'}";	//xx: 단일인용부호는 절대 허용하지 않는다.
		String json = "{\"id\":700,\"name\":\"Pyramide\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		Bar bar = mapper.readValue(json, Bar.class);
		
		assertNotNull(bar);
		log.info("\t+ bar: {}", bar);
		
	} //testDeserilaize
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("단위테스트3: JSON => Java Obeject 역변환(De-serilalization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testDeserilaize2() throws JsonMappingException, JsonProcessingException {
		
		log.trace("testDeserilaize2() invoked.");
		
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
		String json = """
				{ "response": { "header": [{ "resultCode": ["00"], "resultMsg": ["NORMAL SERVICE."] }] } }
				"""; 
//		String json = "{ \"response\": { \"header\": [{ \"resultCode\": [\"00\"], \"resultMsg\": [\"NORMAL SERVICE.\"] }] } }";
		
		log.info("\t+json: {}", json);

		ObjectMapper mapper = new ObjectMapper();
		TTT obj = mapper.readValue(json, TTT.class);

		if(obj != null) {		
			log.info("\t + obj: {}", obj);
		}
	} //testDeserilaize2
} //end class


//@Data
@Setter
class JJJ {
	private String[] resultCode;
	private String[] resultMsg;
} //JJJ

//@Data
@Setter
class KKK {
	private List<JJJ> header;
} //KKK

//@Data
@Setter
class TTT {
	private KKK response;
} //TTT





