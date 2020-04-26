package com.jiaming.mapper;

import com.jiaming.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jmstart
 * @create 2020-04-26 13:54
 */
@Mapper
public interface UserMapper {

    public List<User> queryUserList();

}
