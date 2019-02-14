package com.asyysy.asyysy_core.dao;

import com.asyysy.asyysy_core.model.WxMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxMainDao {

    public boolean inserWxInCharge(WxMessage wx);
}
