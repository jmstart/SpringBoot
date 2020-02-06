package com.jiaming.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author jmstart
 * @create 2020-02-06 10:45
 */
@RestController
public class HelloSpringBoot {

    @Autowired
    private DataSource dataSource;

    @GetMapping("hello")
    public String hello(){

        return "Hello SpringBoot...";
    }
}
