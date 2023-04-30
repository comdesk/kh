package org.zerock.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.exception.BusinessException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
public class InsertService implements Service {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) 
			throws BusinessException {
		log.trace("process(req, res) invoked.");
		
		try {
			
		} catch(Exception e) {
			throw new BusinessException(e);
		} //try-catch
	} //process

} //end class
