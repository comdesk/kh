package org.zerock.myapp.di;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;


@Log4j2
@ToString
@NoArgsConstructor	//필드가 없어서 게터, 세터 필요 없으니까 이 어노테이션만 붙임.

@Component("Chef") 
public class Chef implements InitializingBean, DisposableBean {
	
	//==================== InitializingBean, DisposableBean ======================
	
	@Override
	public void destroy() throws Exception {
		log.trace("destroy() invoked.");
	} //destroy

	@Override
	public void afterPropertiesSet() throws Exception {
		log.trace("afterPropertiesSet() invoked.");
		
	} //afterPropertiesSet
} //end class
