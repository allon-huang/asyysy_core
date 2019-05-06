package com.asyysy.core.service.impl;

import com.asyysy.core.dao.WxMainDao;
import com.asyysy.core.model.WxMessage;
import com.asyysy.core.service.WxMainService;
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
