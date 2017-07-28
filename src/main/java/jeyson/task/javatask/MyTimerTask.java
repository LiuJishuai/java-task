package jeyson.task.javatask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by  liujishuai
 * Create Date: 2017/7/28 19:05
 * Description:
 */
public class MyTimerTask extends TimerTask {
    /**
     * timer实现定时任务
     * @param date 开始日期
     * @param rateTime 频率 ms
     */
    public static void job(Date date,int rateTime){
        TimerTask task=new MyTimerTask();
        //Timer，也是一种线程
        Timer timer=new Timer("teemo", true);
        //将任务交给时间调度，在日期date开始执行第一次，每rateTime毫秒执行一次
        timer.scheduleAtFixedRate(task, date, rateTime);
    }
    @Override
    public void run() {
        System.out.println("定时任务执行："+new Date());
    }
}
