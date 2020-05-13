package com.jiaming.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jmstart
 * @create 2020-05-11 11:05
 *
 * 配置加载 Druid属性
 */
@Configuration
public class DruidConfig {

    //导入Druid资源
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {

        return new DruidDataSource();
    }

    //配置Druid监控
    //1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {

        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //配置初始化参数
        Map<String, String> initPatams = new HashMap<>();
        //用户名
        initPatams.put("loginUsername", "admin");
        //密码
        initPatams.put("loginPassword", "123456");
        //允许谁访问,如果为空,默认所有
        initPatams.put("allow", "");
        //拒绝谁访问
        initPatams.put("deny", "192.186.43.175");

        bean.setInitParameters(initPatams);

        return bean;
    }

    //配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {

        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        //配置初始化参数
        Map<String, String> initPatams = new HashMap<>();
        //放行静态资源
        initPatams.put("exclusions", "*.js, *.css, /druid/*");

        bean.setInitParameters(initPatams);
        //拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
