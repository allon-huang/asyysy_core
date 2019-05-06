package cn.asyysy.core.mapper;

import cn.asyysy.core.model.WxReplyModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface WxReplyModelMapper extends BaseMapper<WxReplyModel> {
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
