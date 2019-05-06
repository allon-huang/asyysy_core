package cn.asyysy.core.service.impl;

import cn.asyysy.core.model.WxMessage;
import cn.asyysy.core.service.WxMainService;
import cn.asyysy.core.dao.WxMainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxMainServiceImpl implements WxMainService {

    @Autowired
    private WxMainDao wxMainDao;

    @Override
    public boolean inserWxInCharge(WxMessage wx) {
        return wxMainDao.inserWxInCharge(wx);
    }
}
