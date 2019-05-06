package cn.asyysy.core.dao;

import cn.asyysy.core.model.WxMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxMainDao {
    boolean inserWxInCharge(WxMessage wx);
}
