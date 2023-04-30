package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;

public interface BoardMapper {
	
	@Select("SELECT /*+ index_desc(tbl_board2) */ * FROM tbl_board2")
	public abstract List<BoardVO> selectAll();		//1. 전체목록조회
	
	//XML Mapper 방식으로 SQL 처리
	public abstract BoardVO select(Integer bno);	//2. 게시물상세조회
	
	public abstract Integer delete(Integer bno);	//3. 게시물 삭제

	public abstract Integer insert(BoardDTO dto);	//4. 신규 게시물 등록
	
	public abstract Integer update(BoardDTO dto);	// 5. 기존 게시물 수정
} //end interface

