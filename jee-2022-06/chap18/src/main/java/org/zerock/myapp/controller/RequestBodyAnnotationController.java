package org.zerock.myapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.Ticket;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@RequestMapping("/request")
@RestController
public class RequestBodyAnnotationController {

	//@RequestBody 어노테이션의 용법을 배우자
	//HTTP request 메시지의 Body(Payload)에 들어있는 JSON 문자열을
	//끄집어 내어, 이 어노테이션이 붙어있는 매개변수 타입의 객체로 역변환
	//(JSON de-serialization) 해서, 인자값으로 넣어주는 어노테이션
	
	@PostMapping(path="/ticket", produces= {"application/json"})
	public Ticket convertToTicket(@RequestBody Ticket ticket) {
		log.trace("convertToTicket({}) invoked.", ticket);
		
		return ticket;
	} //convertToTicket
} //end class
