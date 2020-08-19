package com.lemon.michstabe.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对于时间操作的工具类
 */
public class DateUtil {

    // 返回当前时间，字符串类型　yyyy-MM-dd 格式
    public static String getNowDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    // 返回当前时间，字符串类型　yyyy-MM-dd HH:mm:ss 格式
    public static String getNowDatetime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

}
