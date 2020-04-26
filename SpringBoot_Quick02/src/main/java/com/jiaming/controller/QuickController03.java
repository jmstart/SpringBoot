package com.jiaming.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmstart
 * @create 2020-04-25 10:37
 */
@RestController
@ConfigurationProperties(prefix = "person1")
@Getter
@Setter
public class QuickController03 {

    private String name;
    private String addr;

    @RequestMapping("/quick03")
    public String quick03() {

        return name + " " + addr;
    }

}
