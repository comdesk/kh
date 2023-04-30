package org.zerock.myapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

//무용지물: 예외처리용 컨트롤러는 웹브라우저로부터 요청을 받아 수행되는 것이 아니기 때문
@RequestMapping("/error")	//Base URI
@ControllerAdvice
public class CommonExceptionHandler { //POJO
	
	@ExceptionHandler(AException.class)
	public String handleAException(Exception e, Model model) {
		log.trace("handleNullPointerException({}, {})", e, model);
		
		log.error("1. Exception Type: {}", e.getClass().getName());
		log.error("2. Exception Message: {}", e.getMessage());
		
		model.addAttribute("__EXCEPTION__", e);
		
		return "error/errorPage";
	} //handleNullPointerException
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNoHandlerFoundException(Exception e) {
		log.trace("handleNoHandlerfoundException({})", e);
		
		return "error/errorPage";
	}
} //end class













