package cn.asyysy.core.common.config;

import cn.asyysy.core.intercepter.ApiSignatureInterceptor;
import cn.asyysy.core.intercepter.JwtInterceptor;
import cn.asyysy.core.intercepter.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginIntercepter loginIntercepter;

    // 再拦截器中使用了RedisUtil bean类，但是拦截器执行实在spring容器bean初始化之前的
    // RedisUtil 将无法注入，为了解决该问题，将JwtInterceptor拦截器先配置为一个bean
    // 在注册拦截器时，直接使用配置的bean
    /*@Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }*/

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 需要拦截的路径/** 为全部    excludePathPatterns 拦截路径下排除的路径
        registry.addInterceptor(loginIntercepter).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/user/login", "/index"));
        // 注册Token拦截器
        //registry.addInterceptor(new ApiSignatureInterceptor());
        //registry.addInterceptor(new JwtInterceptor()) .addPathPatterns("/tp_store/logout");
    }
}
