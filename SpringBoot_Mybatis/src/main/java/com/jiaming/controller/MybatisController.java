package com.jiaming.controller;

import com.jiaming.domain.User;
import com.jiaming.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jmstart
 * @create 2020-04-26 14:15
 */
@RestController
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/find")
    public List<User> findAll() {

        List<User> users = userMapper.queryUserList();

        return users;
    }
}
