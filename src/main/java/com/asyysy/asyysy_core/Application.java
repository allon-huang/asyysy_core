package com.asyysy.asyysy_core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@MapperScan("com.asyysy.asyysy_core.dao")
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
}

