package org.zerock.myapp.service;

import org.zerock.myapp.exception.ServiceException;

public interface SampleXAService {
	
	public abstract boolean register(String data) throws ServiceException;
} //end interface
