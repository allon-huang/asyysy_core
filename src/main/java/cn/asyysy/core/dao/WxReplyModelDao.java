package cn.asyysy.core.dao;

import cn.asyysy.core.model.WxReplyModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface WxReplyModelDao extends BaseMapper<WxReplyModel> {
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
