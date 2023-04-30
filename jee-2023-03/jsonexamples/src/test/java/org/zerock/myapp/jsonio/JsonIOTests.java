package org.zerock.myapp.jsonio;

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

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JsonIOTests {

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("단위테스트1: Java Object => JSON 변환(Serialization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testSerilaize() {
		
		log.trace("testSerilaize() invoked.");
		
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
		Foo foo = new Foo();
		foo.setId(333);
		foo.setName("Trinity");
		log.info("\t+ foo: {}", foo);
		
//		---
		
		String json = JsonWriter.objectToJson(foo);
		
		assertNotNull(json);
		log.info("\t+ json: {}", json);
	} //testSerilaize
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("단위테스트2: JSON => Java Obeject 역변환(De-serilalization)")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	void testDeserilaize() {
		
		log.trace("testDeserilaize() invoked.");
		
//		JSON 문자열 => 자바객체로 변환(De-Serialization)
		String json = """
				{"@type":"org.zerock.myapp.domain.Bar","id":333,"name":"Trinity"}
				""";
		
		Bar obj = (Bar) JsonReader.jsonToJava(json);
		
		assertNotNull(obj);
		log.info("\t+ obj: {}", obj);
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
				{ "@type":"org.zerock.myapp.jsonio.TTT",
				"response": { "header": [{ "resultCode": ["00"], "resultMsg": ["NORMAL SERVICE."] }] } }
				"""; 
		
		TTT obj = (TTT)JsonReader.jsonToJava(json);
		Objects.requireNonNull(obj);
		log.info("\t+ obj: {}", obj);
	} //testDeserilaize2
} //end class

//JSON-IO 변환 라이브러리도, 역직렬화 시에 바이트 코드 조작을 통해,
//접근 권한이 없는 필드에 값을 바로 넣어버린다.(Like Lombok)

//@Data
//@Setter
@ToString
class JJJ {
	private List<String> resultCode;
	private String[] resultMsg;
} //JJJ

//@Data
//@Setter
@ToString
class KKK {
	private JJJ[] header;
} //KKK

//@Data
//@Setter
@ToString
class TTT {
	private KKK response;
} //TTT




