package com.javaweb.netty.chatroom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 22:32
 * @Version 1.0
 **/
public class Utils {

    public static String encodeMsg(Message message) {
        return message.getUserName() + ":::" +
                (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getSentTime())) + ":::" + message.getMsg();
    }

    public static String formatDateTime(Date time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
    }

    public static Date parseDateTime(String time) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss").parse(time);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void printMsg(Message msg) {
        System.out.println("=================================================================================================");
        System.out.println("                      " + Utils.formatDateTime(msg.getSentTime()) + "                     ");
        System.out.println(msg.getUserName() + ": " + msg.getMsg());
        System.out.println("=================================================================================================");

    }
}
