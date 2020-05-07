package com.jiaming.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author jmstart
 * @create 2020-05-02 19:15
 *
 * 配置区域信息解析器
 * 把区域信息放到链接上传递回来
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取参数信息
        String parameter = httpServletRequest.getParameter("l");
        //当没有参数信息时,使用系统默认的Locale
        Locale locale = Locale.getDefault();
        //当参数不为空时
        if (!StringUtils.isEmpty(parameter)) {
            //切割参数信息
            String[] strings = parameter.split("_");
            //第一个参数是语言信息,第二个参数是国家信息
            locale = new Locale(strings[0], strings[1]);
        }
        //返回结果
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
