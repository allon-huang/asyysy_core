package com.asyysy.asyysy_core.model;

import java.util.Date;

public class WxMessage {
    /**
     * 主键
     */
    private Integer pkid;
    /**
     * openId
     */
    private  String openId;
    /**
     * 消息内容
     */
    private  String message;
    /**
     * 整体报文
     */
    private  String allMessage;
    /**
     * 消息类型
     */
    private  String type;
    /**
     * 消息创建时间
     */
    private Date date;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAllMessage() {
        return allMessage;
    }

    public void setAllMessage(String allMessage) {
        this.allMessage = allMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WxMessage(Integer pkid, String openId, String message, String allMessage, String type, Date date) {
        this.pkid = pkid;
        this.openId = openId;
        this.message = message;
        this.allMessage = allMessage;
        this.type = type;
        this.date = date;
    }

    public WxMessage() {
        super();
    }

    @Override
    public String toString() {
        return "WxMessage{" +
                "pkid=" + pkid +
                ", openId='" + openId + '\'' +
                ", message='" + message + '\'' +
                ", allMessage='" + allMessage + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }

    public WxMessage(String openId, String message, String allMessage, String type, Date date) {
        this.openId = openId;
        this.message = message;
        this.allMessage = allMessage;
        this.type = type;
        this.date = date;
    }
}
