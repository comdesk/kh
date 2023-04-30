package org.zerock.myapp.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.domain.EmpDTO;
import org.zerock.myapp.domain.EmpVO;
import org.zerock.myapp.exception.BusinessException;
import org.zerock.myapp.persistence.EmpDAO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class SelectService implements Service {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) 
			throws BusinessException {
		log.trace("process(req, res) invoked.");
		
		try {
			//1. 필요한 요청(전송) 파라미터 획득해서 DTO로 수집
			String empno = req.getParameter("empno");
			log.info("\t1. empno: {}", empno);
			
			//2. DTO 패턴에 따라, 필요한 전송 파라미터를 저장하는 DTO 객체 생성
			EmpDTO dto = new EmpDTO();
			dto.setEmpno(Integer.valueOf(empno));
			log.info("\t2. dto: {}", dto);
			
			//3. 영속성 계층의 DAO의 메소드 호출 => 사원 정보 획득 (사원테이블 CRUD)
			EmpDAO dao = new EmpDAO();
			EmpVO vo = dao.select(dto);	//사번이 브라우저에서 전송파라미터로 넘어와야 함.
										//=> 전송파라미터를 갖고 있는 DTO를 전달
			
			//비즈니스 수행 결과물. => 모델			
			log.info("\t3. vo: {}", vo);
			
			//4. 획득한 사원정보가 유효한지 체크하여, MVC 패턴의 Model이
			//	 유효하면 공유영역(3가지: APP/SESS/REQ)에 속성바인딩
			if(vo != null) {	//유효
				req.setAttribute(Service.MODEL_KEY, vo);	//Request Scope에 EmpVO 바인딩
			} else {			//유효x
				req.setAttribute(Service.MODEL_KEY, "NO FOUND");	//NULL 대신 문자열로 올려 놓음.(비즈니스로직에 따라 예외를 발생시키는 경우도 있음)
			} //if-else
			
			//5. 마지막으로, 공유영역에 올려놓은 Model을 가지고 사용자에게 전송할 응답화면을 만들어낼 주체
			//	 (MVC 패턴에서 View(JSP)의 역할)에게 마지막 처리를 JSP에게 위임(Delegation)
			//	 (MVC 패턴에서, V(View)의 역할은 응답화면을 만들어내는 것)
			
			String target = "/WEB-INF/index.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(target);
			
			dispatcher.forward(req, res);
		} catch(Exception e) {
			throw new BusinessException(e);
		} //try-catch
	} //process

} //end class



