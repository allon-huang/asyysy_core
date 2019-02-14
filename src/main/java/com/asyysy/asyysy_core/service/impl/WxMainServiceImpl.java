package com.asyysy.asyysy_core.service.impl;

import com.asyysy.asyysy_core.dao.WxMainDao;
import com.asyysy.asyysy_core.model.WxMessage;
import com.asyysy.asyysy_core.service.WxMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxMainServiceImpl implements WxMainService {

    @Autowired
    private WxMainDao wxMainDao;

    @Override
    public boolean inserWxInCharge(WxMessage wx) {
        System.out.println(wx.toString());
        return wxMainDao.inserWxInCharge(wx);
    }
}
