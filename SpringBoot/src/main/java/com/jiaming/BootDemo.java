package com.jiaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jmstart
 * @create 2020-02-06 10:36
 * 启动 SpringBoot
 * 这个类要放在二级包下为什么？
 *  因为没有写 @ComponentScan 扫描器
 *  所以它底层默认扫描子包
 */

@SpringBootApplication
public class BootDemo {

    public static void main(String[] args) {

        SpringApplication.run(BootDemo.class, args);
    }
}





