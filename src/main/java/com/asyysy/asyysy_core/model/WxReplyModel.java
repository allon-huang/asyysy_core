package com.asyysy.asyysy_core.model;

import java.util.Date;

public class WxReplyModel {

    private Long pkid;
    private String type;
    private String keyword;
    private String replyText;
    private Integer sendSum;
    private Date createTime;

    @Override
    public String toString() {
        return "WxReplyModel{" +
                "pkid=" + pkid +
                ", type='" + type + '\'' +
                ", keyword='" + keyword + '\'' +
                ", replyText='" + replyText + '\'' +
                ", sendSum=" + sendSum +
                ", createTime=" + createTime +
                '}';
    }

    public WxReplyModel() {
        super();
    }

    public WxReplyModel(Long pkid, String type, String keyword, String replyText, Integer sendSum, Date createTime) {
        this.pkid = pkid;
        this.type = type;
        this.keyword = keyword;
        this.replyText = replyText;
        this.sendSum = sendSum;
        this.createTime = createTime;
    }

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public Integer getSendSum() {
        return sendSum;
    }

    public void setSendSum(Integer sendSum) {
        this.sendSum = sendSum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
