package com.jiaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jmstart
 * @create 2020-04-25 9:42
 */
@Controller
public class QuickController {

    @RequestMapping("/quick")
    @ResponseBody
    public String quick() {

        return "Hello SpringBoot";
    }

}
