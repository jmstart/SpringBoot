package com.jiaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author jmstart
 * @create 2020-05-11 10:45
 *
 * 测试查询数据库
 */
@Controller
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    @ResponseBody
    public Map<String, Object> map() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        return list.get(0);
    }
}
