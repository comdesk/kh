package org.zerock.myapp.service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.exception.BusinessException;
import org.zerock.myapp.persistence.BoardDAO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
public class BoardWriteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws BusinessException {
		
		log.trace("execute({}, {}) invoked.", req, res);
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String content = req.getParameter("content");
			
			BoardDAO dao = new BoardDAO();
			
			dao.write(title, author, content);
		} catch (Exception e) {
			throw new BusinessException(e);
		} //try-catch		
	} //execute	
} //end class
