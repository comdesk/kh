package org.zerock.myapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2

@Aspect
@Component
public class LogAdvice {
	
	//(1) Before Advice
	//(2) PointCut 설정은, 비즈니스 계층의 서비스 객체를 대상으로 수행되도록
	//	  PointCut Expression으로 설정.(aspectj가 제공)
	@Before("execution(* org.zerock.myapp.service.*Service.*(..))")
	public void beforeAdvice() {
		log.trace("=======================================");
		log.trace("beforeAdvice() invoked.");
		log.trace("=======================================");
	} //beforeAdvice
} //end class
