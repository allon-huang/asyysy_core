package com.asyysy.core.service;

import com.asyysy.core.model.WxReplyModel;

import java.util.List;

public interface WxReplyModelService {
    /**
     * 查询回复模板
     * @param keyword
     * @return
     */
    public List<WxReplyModel> selectWxReplyModelByKeyword(String keyword);
    /**
     * 查询全部回复模板
     * @return
     */
    public List<WxReplyModel> selectWxReplyModelList();
    /**
     * 更新发送次数
     * @param pkid
     * @return
     */
    public int updateReplyModelSendTime(Long pkid);
}
