package jeyson.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by  liujishuai
 * Create Date: 2017/7/31 19:51
 * Description:使用jdk1.8新增的DateTimeFormatter，线程安全
 */
public class DateUtil {

    public static final DateTimeFormatter standFomtter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 将当前时间转换为固定格式的字符串时间显示
     * @param date
     * @param formatter
     * @return
     */
    public static String getFormatTime(Date date,DateTimeFormatter formatter){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return formatter.format(localDateTime);
    }
    /**
     * 将当前时间(localDateTime)转换为固定格式的字符串时间显示
     * @param date
     * @param formatter
     * @return
     */
    public static String getFormatTime(LocalDateTime date,DateTimeFormatter formatter){
        return formatter.format(date);
    }
}
