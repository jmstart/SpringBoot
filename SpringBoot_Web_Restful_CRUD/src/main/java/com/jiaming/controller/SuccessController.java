package com.jiaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * @author jmstart
 * @create 2020-05-01 18:19
 */
@Controller
public class SuccessController {

    /**
     * 1. 测试 Thymeleaf
     * 发送默认路径:
     *     classpath:/templates/success.html
     *
     * 2. 发送数据,在页面显示
     * @return
     */
    @RequestMapping("/suc")
    public String success(Map<String, Object> map) {

        //添加数据
        map.put("name", "<h1>小明<h1>");
        map.put("Hobby", Arrays.asList("台球", "小说", "旅游"));

        //发送
        return "success";
    }
}
