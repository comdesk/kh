package temp35;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Board {	//게시판의 게시글 하나를 모델링해서 만든 클래스
	String subject;		//제목
	String content;		//내용
	String writer;		//작성자

} //end class
