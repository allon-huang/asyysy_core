package com.asyysy.core;

import cn.org.zhixiang.annotation.EnableSyjMiniCode;
import cn.org.zhixiang.entity.IdField;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@MapperScan("com.asyysy.core.dao")
@EnableSyjMiniCode // syj-minicode 注册
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

    /*intellij下将springboot项目打成war包发布到远程tomcat服务器上   需  extends SpringBootServletInitializer implements WebApplicationInitializer start*/
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){

        return application.sources(Application.class);
    }
    /*intellij下将springboot项目打成war包发布到远程tomcat服务器上   需  extends SpringBootServletInitializer implements WebApplicationInitializer end*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


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

