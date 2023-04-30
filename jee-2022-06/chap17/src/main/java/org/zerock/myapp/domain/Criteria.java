package org.zerock.myapp.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.extern.log4j.Log4j2;


//이 DTO는 페이징 처리와 관련된 전송파라미터만
//수집하는 용도
@Log4j2
@Data
public class Criteria {
	private Integer currPage = 1;	//현재 페이지번호
	private Integer amount = 10;	//한 페이지당 보여줄 게시물 개수(크기)
	
	//페이징 처리를 위한 공통 전송파라미터인데.. 이를 고정시킬지, 받을지는 구현에 따라 달라짐.
	private Integer pagesPerPage = 10;	//한 Pagination(페이지번호목록)의 크기(길이)
	
	//검색조건이 기준 정보로 역시 추가
//	private String type;
//	private String keyword;
	
	//위의 모든 기준 정보를 기반으로, Query String을 만들어주는 메소드 추가
	public String getPagingUri() {
		log.trace("getPagingUri() invoked.");
		
		//Spring Framework이 제공하는 Utilities 를 이용해서, Query String 생성
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
		builder.queryParam("currPage", this.currPage);
		builder.queryParam("amount", this.amount);
		builder.queryParam("pagesPerPage", this.pagesPerPage);
//		builder.queryParam("type", this.type);
//		builder.queryParam("keyword", this.keyword);
		
		String queryString = builder.toUriString();
		log.info("\t+ queryString: {}", queryString);	
		
		return queryString;
	} //getPagingUri
} //end class






