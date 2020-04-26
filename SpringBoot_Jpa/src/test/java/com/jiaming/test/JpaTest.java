package com.jiaming.test;

import com.jiaming.SpringbootJpaApplication;
import com.jiaming.domain.User;
import com.jiaming.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jmstart
 * @create 2020-04-26 15:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testJpa() {
        //测试
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
