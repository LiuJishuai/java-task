package jeyson.task.quartz.spring.RAM;

import jeyson.utils.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * Created by  liujishuai
 * Create Date: 2017/8/8 14:31
 * Description:
 */
public class RAMHelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("This is a job for Testing spring-quartz in RAM style." );
        System.out.println("RAM style time:"+ DateUtil.getFormatTime(LocalDateTime.now(),DateUtil.standFomtter));
    }
}
