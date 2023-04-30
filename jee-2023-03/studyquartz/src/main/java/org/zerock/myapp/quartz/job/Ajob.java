package org.zerock.myapp.quartz.job;

import java.sql.Connection;
import java.sql.SQLException;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.zerock.myapp.quartz.dao.CommonDataSource;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2
public class Ajob implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		log.trace("executre(ctx) invoked.");

		try {
		JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
		String name = dataMap.getString("name");
		int age = dataMap.getInt("age");
		
		log.info("\t+ name: {}, age: {}", name, age);
		
		
		@Cleanup
		Connection conn = CommonDataSource.getInstance().getConnection();
		log.info("\t+ conn: {}", conn);
		} catch(SQLException e) {
			throw new JobExecutionException(e);
		} //try-catch
		
	} //execute

} //end class
