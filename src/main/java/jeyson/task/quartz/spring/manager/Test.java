package jeyson.task.quartz.spring.manager;


import jeyson.task.quartz.spring.manager.model.ScheduleJob;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.ArrayList;

import java.util.List;


/**
 * Created by  liujishuai
 * Create Date: 2017/8/8 17:42
 * Description:
 */
public class Test {
    /**
     * 初始化任务
     */
    private static List< ScheduleJob> jobList = new ArrayList<>();
    static {
        for (int i = 0; i < 6; i++) {
            ScheduleJob job = new ScheduleJob();
            job.setJobId("10001" + i);
            job.setJobName("teemo:" + i);
            job.setJobGroup("dataWork");
            job.setJobStatus("1");
            switch (i){
                case 0:
                    job.setExpression("0,5 * * * * ?");
                    break;
                case 1:
                    job.setExpression("10,15 * * * * ?");
                    break;
                case 2:
                    job.setExpression("20,25 * * * * ?");
                    break;
                case 3:
                    job.setExpression("30,35 * * * * ?");
                    break;
                case 4:
                    job.setExpression("40,45 * * * * ?");
                    break;
                case 5:
                    job.setExpression("50,55 * * * * ?");
                    break;
            }

            job.setDescription("数据导入");
            jobList.add(job);
        }
    }

    public static void main(String []args) throws SchedulerException {
        //schedulerFactoryBean，可由spring注入
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
       //schedulerFactoryBean实际获取到的就是Scheduler，不用再从schedulerFactoryBean获取，否则会报错
        Scheduler scheduler=(Scheduler)ac.getBean("schedulerFactoryBean");

       for(ScheduleJob job:jobList){
           TriggerKey triggerKey=TriggerKey.triggerKey(job.getJobName(),job.getJobGroup());
           //获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
           CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
           if(null==trigger){
               JobDetail jobDetail=JobBuilder.newJob(QuartzJobFactory.class)
                       .withIdentity(job.getJobName(),job.getJobGroup()).build();

               jobDetail.getJobDataMap().put("scheduleJob",job);
              //表达式调度构建器
               CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule(job.getExpression());
               //按新的cronExpression表达式构建一个新的trigger
               trigger=TriggerBuilder.newTrigger().withIdentity(job.getJobName(),job.getJobGroup()).withSchedule(scheduleBuilder).build();
               scheduler.scheduleJob(jobDetail,trigger);
           }else {
               //更新表达式调度器
               CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule(job.getExpression());
               //按新的cronExpression表达式构建trigger
               trigger=TriggerBuilder.newTrigger().withIdentity(job.getJobName(),job.getJobGroup()).withSchedule(scheduleBuilder).build();
               //按新的trigger重新设置job执行
               scheduler.rescheduleJob(triggerKey, trigger);
           }
       }
    }
}
