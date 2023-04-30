package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;

public interface BoardService {
	
	//1. 게시물 전체목록 조회(LIST)
	public abstract List<BoardVO> getList(Criteria cri) throws ServiceException;
	
	//2. 특정 게시물 상세 조회(READ)
	public abstract BoardVO get(Integer bno) throws ServiceException; //bno대신 dto를 줄 수도 있음.
	
	//3. 특정 게시물 삭제(DELETE)
	public abstract boolean remove(Integer bno) throws ServiceException;
	
	//4. 새로운 게시물 등록(CREATE)
	public abstract boolean register(BoardDTO dto) throws ServiceException; //전송파라미터 수집하는 DTO를 매개변수로 줌.

	//5. 기존 게시물 수정(UPDATE)
	public abstract boolean modify(BoardDTO dto) throws ServiceException;
	
	//6. 총 게시물 개수 반환
	public abstract Integer getTotalAmount() throws ServiceException;
	
} //end interface
