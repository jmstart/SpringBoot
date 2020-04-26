package com.jiaming.test;

import com.jiaming.SpringbootMybatisApplication;
import com.jiaming.domain.User;
import com.jiaming.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jmstart
 * @create 2020-04-26 14:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class) //启动类
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSpringBootTest() {
        //测试
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
