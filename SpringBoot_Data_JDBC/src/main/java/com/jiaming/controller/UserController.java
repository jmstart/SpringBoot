package com.jiaming.controller;

import com.jiaming.domian.User;
import com.jiaming.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmstart
 * @create 2020-05-11 16:10
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userMapper.findById(id);
    }

    @GetMapping("/delUser/{id}")
    public int deleteUser(@PathVariable("id") Integer id) {
        int num = userMapper.deleteDeptById(id);
        return id;
    }

    //插入name
    @GetMapping("/user")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    //修改username
    @GetMapping("/upUser")
    public User update(User user) {
        userMapper.updateDept(user);
        return user;
    }

}
