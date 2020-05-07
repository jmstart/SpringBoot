package com.jiaming.exception;

/**
 * @author jmstart
 * @create 2020-05-04 17:25
 *
 * 定义异常类
 * 要想实现效果要先关闭拦截器
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
