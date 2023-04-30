package org.zerock.myapp.controller;

import java.util.Objects;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.SampleDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2

@RequestMapping("/reqentity")
@RestController
public class ResponseEntityController implements InitializingBean{

//	핵심: 스프링이 제공하는 제네릭 클래스인 ResponseEntity<T>의
//		  용법에 대해서 배우자
	
	@Inject
	private DataSource dataSource;

	@Override
	public void afterPropertiesSet() throws Exception {	//데이터소스 주입 여부 확인. 사전처리로 사용
		log.trace("afterPropertiesSet() invoked.");
		
		Objects.requireNonNull(this.dataSource);
		log.info("\t+ this.dataSource: {}", this.dataSource);
		
	} //afterPropertiesSet
	
	@GetMapping(
			path="/check",
			
			//아래 2개 이름의 전송파라미터는 반드시 들어와야 된다는 제약조건표시
			params= {"height", "weight"},
			produces= {MediaType.APPLICATION_JSON_VALUE}
//			produces="application/xml"
			)
	public ResponseEntity<SampleDTO> check(Double height, Double weight) {	//그냥 전송파라미터 달라
		log.trace("check({}, {}) invoked.", height, weight);
		
		//ResponseEntity 객체의 속을 채운다.
		SampleDTO dto = new SampleDTO();
		dto.setMno(100);
		dto.setFirstName("대한");
		dto.setLastName("민국");
		
		ResponseEntity<SampleDTO> response = null;
		BodyBuilder bodyBuilder = null;
		
		//Step.1 HTTP response의 응답코드(HTTP Status Code) 설정
		if(height < 100) { //키가 요청을 처리하는 데에 적합하지 않다면...
			bodyBuilder = ResponseEntity.status(HttpStatus.BAD_REQUEST);
		} else {		   //키가 요청을 처리하는 데에 적합하다면...
			bodyBuilder = ResponseEntity.status(HttpStatus.OK);
		} //if-else
		
		log.info("\t+ bodyBilder: {}", bodyBuilder);
		
		//Step.2 HTTP response의 Header 설정
		HttpHeaders headers = new HttpHeaders();
//		headers.add(newHeaderName, newHeaderValue);
//		headers.add("Content-Type", "application/json; charset=utf8");	//아직 헤더 만들기만 하고, 바디에 안 넣음.
//		headers.add("Content-Type", "application/xml; charset=utf8");
		
		log.info("\t+ headers: {}", headers);
		
		bodyBuilder.headers(headers);		
		
		//Step.3 HTTP response의 Body 설정
		response = bodyBuilder.<SampleDTO>body(dto);
		log.info("\t+ response: {}", response);
		
		return response;
	} //check
	
} //end class











