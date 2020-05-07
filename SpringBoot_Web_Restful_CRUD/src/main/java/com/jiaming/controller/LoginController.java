package com.jiaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author jmstart
 * @create 2020-05-03 8:28
 *
 * 登录
 */
@Controller
public class LoginController {

    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {

        //判断登录信息
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功,就会在Session域里面存在一个用户名,就利于拦截器验证其他用户是否登录
            session.setAttribute("loginUser", username);
            //防止重复提交,使用重定向
            return "redirect:/main.html";
        } else {
            //登录失败
            map.put("msg", "用户名密码错误！");
            return "login";
        }

    }
}
