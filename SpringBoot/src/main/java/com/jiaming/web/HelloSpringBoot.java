package com.jiaming.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author jmstart
 * @create 2020-02-06 10:45
 * 测试浏览器
 */
@Slf4j
@RestController
public class HelloSpringBoot {

    //@Autowired
    //private DataSource dataSource;

    @GetMapping("hello.do")
    public String hello() {

        log.debug("hello method is running");
        return "Hello SpringBoot...";
    }
}
