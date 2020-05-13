package com.jiaming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//代替了 Mapper注解
@MapperScan(value = "com.jiaming.mapper")
@SpringBootApplication
public class SpringbootDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataJdbcApplication.class, args);
    }

}
