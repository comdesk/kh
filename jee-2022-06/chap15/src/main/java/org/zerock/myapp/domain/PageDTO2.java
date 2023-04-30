package org.zerock.myapp.domain;


//Criteria DTO (페이징처리 기준 정보) + 총 게시물 건수(totalAount) =>
//나머지 게시판 목록 하단에 표시할 "Pagination" 정보를 모두 계산해주는 클래스
public class PageDTO2 {
	
	private Criteria cri;		//페이징 처리를 위한 기준정보 객체. 기준정보는 기본으로 주어짐.
	private int totalAmount;	//총 레코드 건수 (input타입이 이미 있다고 가정하고 "계산"하는 클래스라서)

	//자동 계산할 숫자들...
	//Pagination을 자동으로 계산.
	//** 아래에서, "Pagination"이란 => 현재 페이지 기준으로 표시할, 페이지번호목록
	private int startPage;		//현재 currPage 기준으로, Pagination의 시작 페이지 번호
	private int endPage;		//현재 currPage 기준으로, Pagination의 끝 페이지 번호
	private int realEndPage;	//현재 currPage 기준으로, Pagination의 실제 끝 페이지 번호
	private int offset;			//현재 currPage 기준으로, OFFSET 절에 지정할 레코드 번호
	private boolean prev;		//현재 currPage 기준으로, 이전 Pagination으로 이동가능한가?
	private boolean next;		//현재 currPage 기준으로, 이후 Pagination으로 이동가능한가?

	public PageDTO2(Criteria cri, int totalAmount) {
		this.cri = cri;
		this.totalAmount = totalAmount;
		
		//----------------------------------------------------------//
		//--Step.0 : 페이징 처리를 위한 공통변수 생성하기
		//----------------------------------------------------------//
		int currPage = cri.getCurrPage();
		int amount = cri.getAmount();
		int pagesPerPage = cri.getPagesPerPage();

		//----------------------------------------------------------//
		//--Step.1 : 현재 페이지에서 보여줄 페이지목록의 끝페이지번호 구하기
		//----------------------------------------------------------//
		// (공식) 끝페이지번호 = (int) Math.ceil( (double) 현재페이지번호 / 페이지목록길이 ) x 페이지목록길이
		//----------------------------------------------------------//
		this.endPage = (int) Math.ceil( (currPage * 1.0) / pagesPerPage ) * pagesPerPage;

		//----------------------------------------------------------//
		//--Step.3 : 현재 페이지의 페이지번호목록의 시작번호 구하기
		//----------------------------------------------------------//
		// (공식) 시작페이지번호 = 끝페이지번호 - ( 페이지목록길이 - 1 )
		//----------------------------------------------------------//
		this.startPage = this.endPage - ( pagesPerPage - 1 );

		//----------------------------------------------------------//
		//--Step.4 : 총페이지수 구하기
		//----------------------------------------------------------//
		// (공식) 총페이지수 = (int) Math.ceil( (double) 모든행의개수 / 한페이지당행의수 )
		//----------------------------------------------------------//
		this.realEndPage = (int) Math.ceil( (totalAmount * 1.0) / amount );
		
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		} // if

		//----------------------------------------------------------//
		//--Step.5 : 이전 페이지번호목록으로 이동가능여부(prev) 구하기
		//----------------------------------------------------------//
		// (공식) 이전페이지목록이동가능여부 = 시작페이지번호 > 1
		//----------------------------------------------------------//
		this.prev = this.startPage > 1;

		//----------------------------------------------------------//
		//--Step.6 : 다음 페이지번호목록으로 이동가능여부(next) 구하기
		//----------------------------------------------------------//
		// (공식) 다음페이지목록이동가능여부 = 끝페이지번호 < 총페이지수
		//----------------------------------------------------------//
		this.next = this.endPage < realEndPage;

		//----------------------------------------------------------//
		//--Step.7 : 현재 페이지에 표시할 목록의 시작 offset 구하기
		//----------------------------------------------------------//
		// (공식) 시작 offset = (현재페이지번호 - 1) x 한페이지당행의수
		//----------------------------------------------------------//
		this.offset = ( currPage - 1 ) * amount;
		
	} //Constructor
} //end class
