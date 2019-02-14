package com.asyysy.asyysy_core.dao;

import com.asyysy.asyysy_core.model.WxReplyModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WxReplyModelDao {
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
