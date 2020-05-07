package com.jiaming.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jmstart
 * @create 2020-05-03 9:05
 *
 * 主页拦截器:
 *      进行登录检查,没有登录就不能访问主页
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取参数
        Object loginUser = request.getSession().getAttribute("loginUser");
       //判断
        if (loginUser == null) {
            //未登录,拦截返回到登录页面
            request.setAttribute("msg", "没有权限,请先登录！");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            //已登录,放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}


