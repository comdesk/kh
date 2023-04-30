package org.zerock.myapp.quartz2.job2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

//(*주의사항*) 매번 이 Job이 수행될 때 (스케줄링에 따라), 새로운 객체가 만들어짐.

@NoArgsConstructor
@Log4j2 
public class JobAImpl implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		log.trace("execute(ctx) invoked.");

		try {	//일정한 주기에 따라 수행되는 Task => Batch Job
			log.info("*       - Job A -        *");
//			log.info(this);
			
		} catch(Throwable t) {
			throw new JobExecutionException(t);
		} //try-catch
	} //execute

} //end class
