package com.asyysy.core.model;

import lombok.Data;

import java.util.Date;

@Data
public class WxReplyModel {

    private Long pkid;
    private String type;
    private String keyword;
    private String replyText;
    private Integer sendSum;
    private Date createTime;
}
