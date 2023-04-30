package org.zerock.myapp.service;

import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;

public interface UserService {
	public abstract UserVO login(LoginDTO dto) throws ServiceException;
} //end interface
