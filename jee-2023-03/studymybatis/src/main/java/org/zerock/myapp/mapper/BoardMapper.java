package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardVO;

public interface BoardMapper {
	
//	@Insert({})
//	@Delete({})
//	@Update({})
//	@Select({"""
//			SELECT
//		    /*+ index_desc(tbl_board) */
//		    * 
//			FROM 
//			    tbl_board2 
//			WHERE 
//			    bno > 0
//			"""})
	//Mapper XML 파일로 처리
	public abstract List<BoardVO> selectAllBoards();
	
	//특정 게시글 하나에 대한 상세 조회 내역 반환
	@Select("SELECT * FROM tbl_board2 WHERE bno = #{bno}")	
	public abstract BoardVO selectBoard(/*@Param("bno")*/ Integer bno);
	
	//지정된 범위의 게시글 목록 조회내역 반환
//	@Select(
//			"""
//			SELECT bno, title, content, writer
//			FROM tbl_board2
//			WHERE bno BETWEEN #{startBno} AND #{endBno}
//			"""
//	)
	//Mapper XML 파일로 처리
	public abstract List<BoardVO> selectBoardRange(Integer startBno, Integer endBno);
	
	//검색조건: 게시글번호
	public abstract List<BoardVO> findBoardByBno(Integer bno);
	
	//검색조건: 제목
	public abstract List<BoardVO> findBoardByTitle(String title);
	
	//검색조건: 게시글번호 또는 글번호
	public abstract List<BoardVO> findBoardsByBnoOrTitle(Integer bno, String title);
	
	public abstract int insertBoard(String title, String content, String writer);
} //end interface












