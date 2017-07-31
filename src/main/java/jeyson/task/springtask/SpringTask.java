package jeyson.task.springtask;
import jeyson.utils.DateUtil;
import java.time.LocalDateTime;


/**
 * Created by  liujishuai
 * Create Date: 2017/7/28 17:36
 * Description: 配置式实现springtask，普通java类
 */
public class SpringTask {
    public void job(){
        System.out.println("xml配置定时任务：当前时间："+ DateUtil.getFormatTime(LocalDateTime.now(),DateUtil.standFomtter));
    }
}
