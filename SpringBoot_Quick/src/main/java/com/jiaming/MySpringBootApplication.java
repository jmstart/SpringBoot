package com.jiaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jmstart
 * @create 2020-04-25 8:58
 * SpringBoot 启动(引导)类
 * 该类建立在二级包目录下,它才可以去查找下面三级包里面的东西
 */
@SpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(MySpringBootApplication.class);
    }
}
