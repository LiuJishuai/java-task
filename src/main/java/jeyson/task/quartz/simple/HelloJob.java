package jeyson.task.quartz.simple;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by  liujishuai
 * Create Date: 2017/7/31 10:13
 * Description: HelloWorld quartz版本
 */
public class HelloJob implements Job {
    private SimpleDateFormat stand=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//非线程安全的时间格式处理
    private DateTimeFormatter standFomtter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//jdk1.8的DateTimeFormatter，线程安全

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz: now time is "+stand.format(new Date()));
        System.out.println("quartz:现在时间为："+standFomtter.format(LocalDateTime.now()));
    }
}
