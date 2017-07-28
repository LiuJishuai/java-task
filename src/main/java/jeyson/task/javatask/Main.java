package jeyson.task.javatask;

import java.util.Date;

/**
 * Created by  liujishuai
 * Create Date: 2017/7/28 19:11
 * Description:
 */
public class Main {
    public static void main(String []args) throws InterruptedException {
        Date date=new Date();
        int time=1000;
        MyTimerTask.job(date,time);

        Thread.sleep(10000);
    }
}
