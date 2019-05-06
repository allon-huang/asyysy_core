package com.asyysy.core.service.impl;

import com.asyysy.core.dao.WxReplyModelDao;
import com.asyysy.core.model.WxReplyModel;
import com.asyysy.core.service.WxReplyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxReplyModelServiceImpl implements WxReplyModelService {

    @Autowired
    private WxReplyModelDao replyModelDao;


    @Override
    public List<WxReplyModel> selectWxReplyModelByKeyword(String keyword) {
        //模糊查询
        keyword = "%" + keyword + "%";
        return replyModelDao.selectWxReplyModelByKeyword(keyword);
    }

    @Override
    public List<WxReplyModel> selectWxReplyModelList(){
        return replyModelDao.selectWxReplyModelList();
    }

    @Override
    public int updateReplyModelSendTime(Long pkid) {
        return replyModelDao.updateReplyModelSendTime(pkid);
    }
}
