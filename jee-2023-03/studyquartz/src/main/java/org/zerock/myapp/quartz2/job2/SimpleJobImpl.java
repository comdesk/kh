package org.zerock.myapp.quartz2.job2;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2
public class SimpleJobImpl implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		log.trace("execute({}) invoked.", ctx);
		
		try {	//일정한 주기에 따라 수행되는 Task => Batch Job
			log.info("**** SimpleJob, this: {} ***", this);
			
			
			JobDataMap jobDataMap = ctx.getJobDetail().getJobDataMap();
			log.info("\t1. jobDataMap: {}", jobDataMap);
			
			//미리 약속된 데이터를 Map객체에서 획득
			//(1) key: jobSays (2) key: myFloatValue
			String jobSays = jobDataMap.getString("jobSays");
			float myFloatValue = jobDataMap.getFloat("myFloatValue");
			
			log.info("\t2. jobSays: {}, myFlatValue: {}", jobSays,myFloatValue );
			
		} catch(Throwable t) {
			throw new JobExecutionException(t);
		} //try-catch

	} //execute

} //end class
