package org.zerock.myapp.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Aspect
//모든 Advice 구현 객체도 Beans Container에 Bean으로 등록돼야 합니다.
@Component
public class LogAdvice {
	
	//Target 객체의 JoinPoint 수행 직전에 적용되는 Advice
	@Before("execution(* org.zerock.myapp.service.*Service.*(..))")	//OK
	public void beforeAdvice() {										//OK
//	@Before("execution(* org.zerock.myapp.service.*Service.plus(String, String)) && args(num1, num2)")	//OK
//	public void logBefore(String num1, String num2) {													//OK
		log.trace("=========================");
		log.trace("1. beforeAdvice() invoked.");
		log.trace("=========================");
	} //logBefore
	
	//Target 객체의 JoinPoint 수행이 성공적으로 끝난 직후에 적용되는 Advice
	@AfterReturning(
			pointcut="execution( * org.zerock.myapp.service.*Service.*(..))",
			returning="result"
			)		//조인포인트가 정상 수행 된 후에 수행됨.
	public void afterReturningAdivce(Object result) {
		log.trace("=========================");
		log.trace("2. afterReturningAdivce({}) invoked.", result);
		log.trace("=========================");
	} //afterReturningAdivce
	
	//3. Target 객체의 JoinPoint 수행 중, 오류(예외) 발생 직후에 적용되는 Adivce
	@AfterThrowing(
			pointcut="execution( * org.zerock.myapp.service.*Service.*(..))",
			throwing="e"
			)
	public void afterThrowingAdvice(Exception e) {
		log.trace("=========================");
		log.trace("3. afterThrowingAdvice({}) invoked.", e);
		log.trace("=========================");
	} //afterThrowingAdvice
	
	//4. Target 객체의 JoinPoint에서 예외가 발생하든/안하든 상관없이 무조건 적용되는 Advice
	@After("execution( * org.zerock.myapp.service.*Service.*(..))")
	public void afterAdvice() {
		log.trace("=========================");
		log.trace("4. afterAdvice() invoked.");
		log.trace("=========================");
	} //afterAdvice
	
	//5. Target 객체의 JoinPoint 수행 직전 그리고 수행 직후 모두에 적용되는 Advice
	//	 이렇게 Adivce를 적용하려면 ,한 가지 조건이 필요. 다시 말해서, Target 객체의
	//	 해당 JoinPoint를 직접 제어(= 직접 수행과 동일한 말)
	@Around("execution( * org.zerock.myapp.service.*Service.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		log.trace("=========================");
		log.trace("5. aroundAdvice({}) invoked.", pjp);
		log.trace("=========================");
		
	
		Object target = pjp.getTarget();
		Signature signature = pjp.getSignature();
		Object[] args = pjp.getArgs();
		SourceLocation sourceLocation = pjp.getSourceLocation();
		StaticPart sataticPart = pjp.getStaticPart();
		Object thisObj = pjp.getThis();
		
		log.info("\t+ 1. target: {}", target);
		log.info("\t+ 2. signature: {}", signature);
		log.info("\t+ 3. args: {}", Arrays.deepToString(args));
		log.info("\t+ 4. sourceLocation: {}", sourceLocation);
		log.info("\t+ 5. sataticPart: {}", sataticPart);
		log.info("\t+ 6. thisObj: {}", thisObj);
		
		long start = System.nanoTime();	//JoinPoint 실행 전 시간 측정
		
		Object result = pjp.proceed(); //Target 객체의 JoinPoint 실행시킴
		
		long end = System.nanoTime();	//JoinPoint 실행 후 시간 측정
		
		log.info("\t>>>>>>>>+ Elapsed time(ns): {}", (end - start), "ns.");
		log.info("\t>>>>>>>>+ Elapsed time(secs): {}", (end - start) / Math.pow(10.0, 9.0), "secs.");
		
		return result;
	} //aroundAdvice
} //end class



























