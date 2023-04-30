package org.zerock.myapp.service;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.Sample1Mapper;
import org.zerock.myapp.mapper.Sample2Mapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2

@Service
public class SampleXAServiceImpl 
	implements SampleXAService, InitializingBean {

	@Inject private Sample1Mapper mapper1;
	@Inject private Sample2Mapper mapper2;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.trace("afterPropertiesSet() invoked.");
		
		Objects.requireNonNull(this.mapper2);
		Objects.requireNonNull(this.mapper1);			
		
		log.info("\t+ this.mapper1: {}", mapper1.getClass().getName());
		log.info("\t+ this.mapper2: {}", mapper2.getClass().getName());
		
	} //afterPropertiesSet
	
	//2PC(2 phase commit, 2단계 커밋) 방법으로, 분산 트랜잭션 종료
	@Transactional
	@Override
	public boolean register(String data) throws ServiceException {
		log.trace("register({}) invoked.", data);
		
		try {
			//100바이트까지 입력 가능한 mapper2 (tbl_sample2)를 먼저 INSERT하고
			//50바이트까지만 입력 가능한 mapper1 (tbl_sample1)을 나중에 INSERT하도록 해야
			//정말 분산 트랜잭션 관리자가 XA rollback 해주는지 알 수 있음.
//			int affectedLines2 = this.mapper2.insert(data);
			int affectedLines1 = this.mapper1.insert(data);		
			int affectedLines2 = this.mapper1.insert(data);	
			
			log.info("Finished normally.");
			
			return (affectedLines1 == 1) && (affectedLines2 == 1);
		} catch(UncategorizedSQLException e) {	
			//(*주의사항*)
			//XA manager로 하여금, TX를 rollback시키게 만듦.
			//따라서, 이 예외는 있는 그대로 위로 던져야 한다.
			throw e;			
		} catch(Exception e) {
			log.info("Finished abnormally.");
			
			throw new ServiceException(e);
		} //try-catch

	} //register



} //end class









