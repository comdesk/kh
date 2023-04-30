package org.zerock.myapp.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT current_date FROM dual")
	public abstract Date getNow();	//mybatis한테 Date 타입으로 바꾸라고 요청

	public abstract Date getNow2();
} //end interface
