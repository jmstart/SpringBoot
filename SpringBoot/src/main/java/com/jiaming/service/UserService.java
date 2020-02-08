package com.jiaming.service;

import com.jiaming.mapper.UserMapper;
import com.jiaming.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jmstart
 * @create 2020-02-08 11:01
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional //开启事务 jdbc 已经把事务配好了 只有用就好了
    public void insertUser(User user){
        userMapper.insert(user);
    }
}
