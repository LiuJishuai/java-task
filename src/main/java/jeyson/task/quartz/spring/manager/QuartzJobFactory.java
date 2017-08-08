package jeyson.task.quartz.spring.manager;

import jeyson.task.quartz.spring.manager.model.ScheduleJob;
import jeyson.utils.DateUtil;
import org.quartz.*;

import java.time.LocalDateTime;

/**
 * Created by  liujishuai
 * Create Date: 2017/8/8 17:43
 * Description:
 */
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz job factory start at:"+ DateUtil.getFormatTime(LocalDateTime.now(),DateUtil.standFomtter));
        ScheduleJob job= (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
        System.out.println("当前任务名称："+job.getJobName());
    }
}
