package org.zerock.myapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


//이 DTO는 페이징 처리와 관련된 전송파라미터만
//수집하는 용도
@Data
public class Criteria {
	private Integer currPage = 1;
	private Integer amount = 10;
} //end class
