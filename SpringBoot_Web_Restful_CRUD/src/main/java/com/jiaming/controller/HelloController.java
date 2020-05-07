package com.jiaming.controller;

import com.jiaming.exception.UserNotExistException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmstart
 * @create 2020-05-01 14:57
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(@RequestParam("user") String user) {
        //测试自己定义的异常,要想实现效果要先关闭拦截器
        if (user.equals("jiaming")) {
            throw new UserNotExistException();
        }
        return "Hello World";
    }


}
