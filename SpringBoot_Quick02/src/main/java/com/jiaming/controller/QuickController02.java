package com.jiaming.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmstart
 * @create 2020-04-25 10:37
 */
@RestController
public class QuickController02 {


    //获得配置文件的信息
    @Value("${name}")
    private String name;

    @Value(("${person1.age}"))
    private String age;

    @Value(("${person1.addr}"))
    private String addr;

    @RequestMapping("/quick02")
    public String quick02() {
        //打印获得的配置文件信息
        //System.out.println("name: " + name);
        return "name: " + name + " age: " + age + " addr: " + addr;
    }

}
