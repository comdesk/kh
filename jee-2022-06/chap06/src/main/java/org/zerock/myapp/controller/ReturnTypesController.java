package org.zerock.myapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.SampleDTO;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@RequestMapping("/return")		//Base URI
@Controller
public class ReturnTypesController {
	
	//1. No return type, No parameters => 목적: 단순 화면전환
	@GetMapping("/void")	//프론트로부터 요청을 위임받아 처리할 핸들러 메소드가 됨.
	void returnVoidNoParameters(
			//전송파라미터 필요없음
			//모델상자도 필요없음
			//rttrs 상자도 필요없음
		 ) {
		log.trace("returnVoidNoParameters() invoked.");
		
		//No return type => 더 이상 뷰의 이름을 전달하지 않는다.
		//					대신, Request URI(== Base URI + 상세 URI)가
		//					자동으로 뷰의 이름으로 결정된다.
	} //returnVoidNoParameters
	
	//2. Return type, No Parameters => 단순화면 전환용이되, 전환될 화면을 명시적으로 직접 지정
	@GetMapping("/ViewName")
	//접근제한자는 default 여도(즉, public 생략해도) 괜찮다.
	private String returnString() {
		log.trace("returnString() invoked.");
		
		//반환하는 문자열이 바로, View의 이름으로 사용된다.
		return "return/void";
	} //returnString
	
	//2-1. String return type : "redirect:" keyword
	@PostMapping("/redirect")
	public String reutrnRedirect() {
		log.trace("returnRedirect() invoked.");
		
		//내게 보낸 요청은 잘못 보냈으니, 다시 지정한대로 보내십시오.
		//in serlvet: reponse.sendReirect(target);
		//(주의사항): redirect:target 사이에는 공백이 있어서는 안 된다.
//		return "redirect:void";				//ok: /return/void, GET
		return "redirect:/return/void";		//ok
//		return "redirect:http://naver.com";	//OK: URL
	} //returnRedirect
	
//	2-2. String return type: "forward:" keyword
	@GetMapping("/forward")
	public String returnForward() {
		log.trace("returnForward() invoked.");
		
		//In servlet:
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/return/void");
		//dispatcher.forward(request, respones);
		return "forward:voidReturn";				//OK: Base URI가 있다면, 자동으로 붙음.
//		return "forward:/return/void";		//OK: BaseURI를 직접 붙여도 됨.
//		return "forward:http://naver.com";	//XX: URL로 지정하면 오류
//		return "forward:/WEB-INF/views/return/void.jsp";	//OK: 그러나 Spring MVC 패턴을 깨고, 직접 View 호출
	} //returnForward
	
	//3. Object retrun type using @ResponseBody
	//To return JSON format document
	@PostMapping("/ResponseBody")
	public @ResponseBody SampleDTO returnResponseBody(
				@NonNull @RequestParam("name") String NAME,
				@NonNull @RequestParam("age") Integer AGE
			) {
		log.trace("returnResponseBody({}, {}) invoked.", NAME, AGE);
		
		SampleDTO dto = new SampleDTO();
		dto.setName(NAME);
		dto.setAge(AGE);
		
		log.info("\t+ dto: " + dto);
		
		return dto;
	} //returnResponseBody
	
	//4. Object return type using ResponseEntity<T>
	//To return JSON format document including User-defined HEADERS and BODY, HTTP status
	@PostMapping("/ResponseEntity")
	public ResponseEntity<String> retunrResponseEntity() {
		log.trace("returnResponseEntity() invoked.");
		
		//HTTP response body(payload)에 넣을 JSON 문서
		String json = "{'name': 'Yoseph', 'age': 23}";
		
		//HTTP response의 헤더를 추가		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf8");
		
		//HTTP response의 (1) BODY (2) HEADER (3) HTTP status code
		return new ResponseEntity<>(json, headers, HttpStatus.OK);
	} //retunrResponseEntity
} //end class
















