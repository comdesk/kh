package org.zerock.myapp.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.zerock.myapp.quartz.job.Ajob;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JobSchedulerServer {

	public static void main(String[] args) throws SchedulerException{
		log.trace("main(args) invoked.");
		
		//Step.1 Ajob에 대한 상세정보를 생성
		
		//JobDetail 객체를 생성해주는 JobBuilder 클래스를 이용
		JobDetail detailAJob = 
				JobBuilder.newJob(Ajob.class).
				withDescription("A잡에 대한 설명을 넣습니다").
//				withIdentity("A", "GROUP").					//비정석
				withIdentity(JobKey.jobKey("A", "GROUP")).	//정석
				usingJobData("name", "JY").
				usingJobData("age", 23).
				
				build();
		
		//Step.2 AJob에 대한 스케줄링 정보 생성
		
		//TriggerBuilder를 이용해서, 스케줄링 정보를 가진 Trigger 객체 생성
		
		//--------------------------------------------------//
		//	   초	   분	   시	   일	   월	  요일
		//		* 		* 		* 		* 		* 		*
		//
		//	일(1~31)과 요일(월~일요일)은 함께 동시에 사용 불가
		//--------------------------------------------------//
//		String cronExpression = "0-10 * * * * ?";	//매분, 0초 ~ 10초까지만 수행
//		String cronExpression = "* 59 * * * ?";		//매시간 51분에 60초동안만 수행
		String cronExpression = "* * * * * ?";		//매초마다 수행
//		String cronExpression = "0 * * * * ?";		//매분마다 수행
		
		
		Trigger triggerAJob = 
				TriggerBuilder.
					newTrigger().
					withSchedule(
						//1st. scheduling method
//						SimpleScheduleBuilder.simpleSchedule().
//							withIntervalInSeconds(3).	//지정된 주기
//							
////							repeatForever()				//무한반복
//							withRepeatCount(10)			//유한반복
						
						//2nd. scheduling method = Crond daemon 방식
						CronScheduleBuilder.cronSchedule(cronExpression)
						
					).
					build();
		
		//3. Scheduler 서버에 두 가지 객체를 등록:
		//	 (1) JobDetail (detailAjob)
		//	 (2) Trigger (triggerAJob)
		Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		sched.scheduleJob(detailAJob, triggerAJob);	//3초마다 무한히 AJob 반복 수행
		
		//4. Scheduler 서버 수행
		sched.start();
	} //main

} //end class















