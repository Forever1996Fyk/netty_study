package com.javaweb.netty.chatroom;

import java.util.Date;

/**
 * @ClassName Message
 * @Description TODO
 * @Author YuKai Fan
 * @Date 2019/8/20 22:31
 * @Version 1.0
 **/
public class Message {
    private String userName;
    private Date sentTime;
    private String msg;

    public Message(String userName, Date sentTIme, String msg) {
        this.userName = userName;
        this.sentTime = sentTIme;
        this.msg = msg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
