package com.jiaming.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiaming.SpringbootRedisApplication;
import com.jiaming.domain.User;
import com.jiaming.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jmstart
 * @create 2020-04-26 15:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class RedisTest {

    //注入Redis模板
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //注入 Jpa
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRedis() throws JsonProcessingException {
        //1.从redis缓存中取数据,数据类型为json
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();

        //2.redis中是否存在数据
        if (userListJson == null) {
            //3.不存在,从数据库查询
            List<User> users = userRepository.findAll();

            //4.将查询出的数据存储到Redis缓存中
            //4.1 将list集合转换成json格式的字符串,使用jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(users);
            //4.2 放到缓存中
            redisTemplate.boundValueOps("user.findAll").set(userListJson);

            //提示一下,是否是从数据库中查询的数据
            System.out.println("============从数据库中查询数据==============");
        } else {
            //提示一下,是否是从Redis中查询数据
            System.out.println("============从Redis中查询数据==============");
        }

        //5.打印结果
        System.out.println(userListJson);

    }

}
