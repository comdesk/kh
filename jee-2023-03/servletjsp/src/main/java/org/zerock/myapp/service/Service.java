package org.zerock.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.exception.BusinessException;

public interface Service {
	
	public static final String MODEL_KEY = "__MODEL__";
	
	//1. 모든 종류의 비즈니스 예외는 BusinessException을 상속받아서 정의하도록 하고
	//2. 비즈니스 수행결과 발생하는 데이터(== 모델, Model)는, Shared Scope에 속성 바인딩 수행
	//3. 만일 BusinessException이 발생하면, 이 요청을 위임한, Presentation 계층의 FrontController에게
	//	 전달됨. 그렇기 때문에 모델(Model)과 같이, 비즈니스 예외객체도 공유영역에 속성 바인딩 시켜야 함.
	public abstract void process(HttpServletRequest req, HttpServletResponse res)
		throws BusinessException; 	//위임을 받으려면 req, res 객체를 받아야 함.
	
} //end class
