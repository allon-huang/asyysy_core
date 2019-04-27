package com.asyysy.asyysy_core.common.syj_mini_code;

import cn.org.zhixiang.entity.IdField;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TablePkidField {

    /**
     * 因为默认情况下单个对象查询、修改、删除所依据的主键的字段名使用的都是"id",
     * 但是很可能有的项目使用的是userId、orderId、roleId等主键，如果你的项目符合这个条件注入下方这个bean。
     * @return
     */
    @Bean
    public IdField idField() {
        Map<String,String> map=new ConcurrentHashMap<>();
        map.put("WxMessage","pkid");
        map.put("WxReplyModel","pkid");
        map.put("wx_reply_model","pkid");
        IdField idField=new IdField();
        idField.setMap(map);
        return idField;
    }
}
