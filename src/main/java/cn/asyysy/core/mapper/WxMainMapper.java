package cn.asyysy.core.mapper;

import cn.asyysy.core.model.WxMessage;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface WxMainMapper extends BaseMapper<WxMessage> {
    boolean inserWxInCharge(WxMessage wx);
}
