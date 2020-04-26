package com.jiaming.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmstart
 * @create 2020-04-25 10:37
 */
@RestController
public class QuickController01 {

    @RequestMapping("/quick01")
    public String quick01() {

        return "Test SpringBoot Quick Build";
    }

}
