package com.asyysy.core.dao;

import com.asyysy.core.model.WxMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxMainDao {
    boolean inserWxInCharge(WxMessage wx);
}
