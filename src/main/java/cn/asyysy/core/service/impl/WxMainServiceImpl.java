package cn.asyysy.core.service.impl;

import cn.asyysy.core.model.WxMessage;
import cn.asyysy.core.service.WxMainService;
import cn.asyysy.core.mapper.WxMainMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxMainServiceImpl extends ServiceImpl<WxMainMapper,WxMessage> implements WxMainService {

    @Autowired
    private WxMainMapper wxMainMapper;

    @Override
    public boolean inserWxInCharge(WxMessage wx) {
        return wxMainMapper.inserWxInCharge(wx);
    }
}
