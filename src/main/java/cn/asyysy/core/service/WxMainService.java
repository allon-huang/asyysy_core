package cn.asyysy.core.service;

import cn.asyysy.core.model.WxMessage;
import com.baomidou.mybatisplus.service.IService;

public interface WxMainService extends IService<WxMessage> {
    boolean inserWxInCharge(WxMessage wx);
}
