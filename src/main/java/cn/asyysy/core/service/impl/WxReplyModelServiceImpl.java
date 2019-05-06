package cn.asyysy.core.service.impl;

import cn.asyysy.core.model.WxReplyModel;
import cn.asyysy.core.mapper.WxReplyModelMapper;
import cn.asyysy.core.service.WxReplyModelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxReplyModelServiceImpl extends ServiceImpl<WxReplyModelMapper,WxReplyModel> implements WxReplyModelService {

    @Autowired
    private WxReplyModelMapper replyModelMapper;


    @Override
    public List<WxReplyModel> selectWxReplyModelByKeyword(String keyword) {
        //模糊查询
        keyword = "%" + keyword + "%";
        return replyModelMapper.selectWxReplyModelByKeyword(keyword);
    }

    @Override
    public List<WxReplyModel> selectWxReplyModelList(){
        return replyModelMapper.selectWxReplyModelList();
    }

    @Override
    public int updateReplyModelSendTime(Long pkid) {
        return replyModelMapper.updateReplyModelSendTime(pkid);
    }
}
