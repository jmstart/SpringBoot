package com.jiaming.mapper;

import com.jiaming.domian.User;
import org.apache.ibatis.annotations.*;

/**
 * @author jmstart
 * @create 2020-05-11 16:05
 */
//@Mapper //被 MapperScan代替
public interface UserMapper {

    //@Select("select * from user where id=#{id}")
    public User findById(Integer id);

    @Delete("delete from user where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name) values(#{name})")
    public int insertUser(User user);

    @Update("update user set username=#{username} where id=#{id}")
    public int updateDept(User user);

}
