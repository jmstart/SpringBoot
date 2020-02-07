package com.jiaming.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jmstart
 * @create 2020-02-07 8:32
 */
//这个注解报红原因 1.是没有前缀 前缀是根据你 application.properties 过来的
// 2.是要在使用类上使用这个 @EnableConfigurationProperties(JdbcProperties.class)
//@ConfigurationProperties(prefix = "jdbc")
//Lombok注解
//@Data
public class JdbcProperties {

    String url;
    String driverClassName;
    String username;
    String password;

}
