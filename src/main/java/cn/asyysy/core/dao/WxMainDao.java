package cn.asyysy.core.dao;

import cn.asyysy.core.model.WxMessage;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

public interface WxMainDao extends BaseMapper<WxMessage> {
    boolean inserWxInCharge(WxMessage wx);
}
