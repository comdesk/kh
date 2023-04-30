package org.zerock.myapp.quartz2;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.zerock.myapp.quartz2.job2.JobAImpl;
import org.zerock.myapp.quartz2.job2.JobBImpl;
import org.zerock.myapp.quartz2.job2.SimpleJobImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class QuartzExample {

	public static void main(String[] args) throws SchedulerException{
		
		//Step.1 Job 생성 -> 별도의 패키지에서 구현 완료 (모두 Job 인터페이스의 구현 클래스로 구현)
		
		//Step.2 Quartz Scheduler 객체 생성
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();	//1st.method
		log.info("1. scheduler: {}", scheduler);
				
//		SchedulerFactory factory = new StdSchedulerFactory();	//2nd method
//		factory.getDefaultScheduler();
		
		//Step.3 (연관된 Trigger를 가진) JobDetail 객체 생성 => SimpleJob의 상세 정보
		JobDetail jobA = JobBuilder.newJob(JobAImpl.class).build();
		log.info("2. jobA: {}", jobA);
//		JobDetail jobA = 
//			JobBuilder.
//				newJob(JobAImpl.class).
//				withDescription("description for JobA").
//				withIdentity("JobA", "GROUP_1").
//				withIdentity(JobKey.jobKey("JobA", "GROUP_1")).
//				build();
		
		JobDetail jobB = JobBuilder.newJob(JobBImpl.class).build();
		JobDetail simpleJob = JobBuilder.newJob(SimpleJobImpl.class).build();
		
		//Step.4 Trigger 객체 생성 (각 JobDeatil에 대해서)
		
		//jobA에 대한 스케줄링(Trigger 인터페이스)
		Trigger jobATrigger = 
				TriggerBuilder.
				newTrigger().
				withSchedule(
					SimpleScheduleBuilder.
//						simpleSchedule().
//						withIntervalInSeconds(1).
//						repeatForever()	
						repeatSecondlyForTotalCount(10)
				).
				build();
		log.info("3. jobATrigger: {}", jobATrigger);
		
		//Step.5 JobA와 JobATrigger를 Scheduler에 등록
		scheduler.scheduleJob(jobA, jobATrigger);	//지정된 JobDetail, Trigger 등록
		log.info("4. Scheduling for jobA complete.");
		
		//Step.6 Scheduler 서버 수행
		scheduler.start();
//		scheduler.startDelayed(10);  //10초 후에 수행 (초단위)
		log.info("5. Scheduler Server Started.");
	} //main
} //end class






















