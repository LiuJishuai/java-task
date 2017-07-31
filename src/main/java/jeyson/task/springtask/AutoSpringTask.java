package jeyson.task.springtask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by  liujishuai
 * Create Date: 2017/7/28 16:43
 * Description:
 */
@Service
public class AutoSpringTask {
    @Scheduled(cron = "* * 9 * * ?")
    public void job(){
        System.out.println("注解式定时任务："+new Date());
    }
}
