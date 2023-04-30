package org.zerock.myapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.domain.EmpVO;
import org.zerock.myapp.persistence.EmpDAO;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/DAOTest")
public class TTTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");

		try {
			EmpDAO dao = new EmpDAO();
			log.info("dao: {}", dao);
			
			@Cleanup("clear")
			List<EmpVO> list = dao.selectAll();
			list.forEach(log::info);
		} catch (Exception e) {
			throw new ServletException(e);
		} //try-catch

	} //service

} //end class




