package com.jiaming.test;

import com.jiaming.domian.User;
import com.jiaming.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author jmstart
 * @create 2020-05-11 9:40
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConn {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() throws SQLException {

        //测试数据源
        System.out.println(dataSource.getClass());

        //测试连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //关闭连接
        connection.close();
    }

    //简单的批量插入,没有使用动态sql
    @Test
    public void insertAll() {

        User user = new User();

        for (int i = 1; i < 10; i++) {

            user.setName(i+"明");

            userMapper.insertUser(user);
        }

    }

    //简单的批量删除
    @Test
    public void deleteAll() {

        for (int i = 12; i <= 30; i++) {

            userMapper.deleteDeptById(i);
        }

    }

}
