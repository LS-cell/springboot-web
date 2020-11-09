package com.ls.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求的语言参数
        String l = httpServletRequest.getParameter("l");
        //如果没有就使用默认的
        Locale locale = Locale.getDefault();
        //如果请求的参数携带了国际化的参数
        if (!StringUtils.isEmpty(l)) {
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
