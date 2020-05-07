package com.jiaming.config;

import com.jiaming.component.LoginHandlerInterceptor;
import com.jiaming.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author jmstart
 * @create 2020-05-02 13:46
 *
 * 使用 WebMvcConfigurerAdapter 来扩展SpringMVC的功能
 */
//@EnableWebMvc //代表全面接管SpringMVC配置,不需要SpringBoot默认自动配置,不推荐开启
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送 /action 请求, 去 templates下面找 success.html
        registry.addViewController("/action").setViewName("success");
    }

    //添加首页映射路径
    @Bean
    public WebMvcConfigurerAdapter myLoginPath() {

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //实现视图控制器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //配置: 发送下面的路径,都去 templates下面找login.html页面
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index","/login","/index.html","/login.html","/user/login","/asserts/**","/webjars/**");
            }
        };

        return adapter;
    }

    //添加区域解析器到容器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
