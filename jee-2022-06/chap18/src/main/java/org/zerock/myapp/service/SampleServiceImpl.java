package org.zerock.myapp.service;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer plus(String number1, String number2) throws Exception {
		log.trace("plus({}, {}) invoked.", number1, number2);
		
//		Integer result = Integer.parseInt(number1) + Integer.parseInt(number2);	//기본타입
		Integer result = Integer.valueOf(number1) + Integer.valueOf(number2);	//래퍼타입
		
		return result;
	} //plus

} //end class
