package jeyson.task.quartz.simple;

import jeyson.utils.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by  liujishuai
 * Create Date: 2017/7/31 10:20
 * Description: HelloWorld quartz版本
 */
public class HelloQuartzTest {

    public static  void main(String []args) throws SchedulerException {
        //创建Scheduler工厂
        SchedulerFactory sf= new StdSchedulerFactory();
        //从工厂中获取调度器
        Scheduler scheduler=sf.getScheduler();
        //创建jobDeatil
        JobDetail jobDetail= JobBuilder.newJob(HelloJob.class)
                .withDescription("这是我的第一个job示例")//job描述
                .withIdentity("helloJob","ramGroup")//job名称和组定义
                .build();
        //定义任务开始运行时间
        long time=System.currentTimeMillis()+5000;
        Date startTime=new Date(time);
        //创建Trigger
        Trigger trigger=TriggerBuilder.newTrigger()
                .withDescription("jeyson trigger")
                .withIdentity("helloTrigger","ramTriggerGroup")
                .startAt(startTime)  //开始时间
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))//执行频率
                .build();
      //注册任务和定时器
        scheduler.scheduleJob(jobDetail,trigger);
        //启动调度器
        scheduler.start();
        System.out.println("开始："+ DateUtil.getFormatTime(LocalDateTime.now(),DateUtil.standFomtter));
    }
}
