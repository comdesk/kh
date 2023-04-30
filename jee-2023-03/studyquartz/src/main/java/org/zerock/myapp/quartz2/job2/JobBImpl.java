package org.zerock.myapp.quartz2.job2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2
@ToString
public class JobBImpl implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		log.trace("execute(ctx) invoked.");

		try {	//일정한 주기에 따라 수행되는 Task => Batch Job
			log.info("*       - Job B -        *");;
			
		} catch(Throwable t) {
			throw new JobExecutionException(t);
		} //try-catch
	} //execute

} //end class
