package com.jiaming.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author jmstart
 * @create 2020-02-06 11:16
 * 当.xml使用
 * 配置数据库连接池 Druid
 * - @Configuration：声明一个类作为配置类，代替xml文件
 * - @Bean：声明在方法上，将方法的返回值加入Bean容器，代替 bean 标签
 * - @value：属性注入
 * - @PropertySource：指定外部属性文件，
 */
@Configuration
//@PropertySource("classpath:application.properties")
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

    //Java配置方式
    /*@Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;*/

   /*
    //SpringBoot 属性注入方式一
    // 偏向于大家一起使用 哪里需要去哪里
    //1.@Autowired注入使用 2.还可以构造方法注入 3.@Bean注入使用
    @Autowired                          //1
    JdbcProperties jdbcProperties;

    public JdbcConfig(JdbcProperties jdbcProperties){        //2
        this.jdbcProperties = jdbcProperties;
    }*/

   /* @Bean                                     //3
    public DataSource dataSource(JdbcProperties prop){

        DruidDataSource dataSource = new DruidDataSource();

        //prop.getUrl()它们报红原因可能是Lombok没有起作用 下载了一个Lombok插件就好用了
        dataSource.setUrl(prop.getUrl());
        dataSource.setDriverClassName(prop.getDriverClassName());
        dataSource.setUsername(prop.getUsername());
        dataSource.setPassword(prop.getPassword());
        return dataSource;
    }*/


    //SpringBoot 属性注入方式二
    // 偏向于自己使用 更加方便快捷
    // 直接注入
    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){

        return new DruidDataSource();
    }
}
