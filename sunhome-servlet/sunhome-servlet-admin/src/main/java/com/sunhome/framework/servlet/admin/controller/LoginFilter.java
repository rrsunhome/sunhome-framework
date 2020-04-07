package com.sunhome.framework.servlet.admin.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : qijia.wang
 * create at:  2020/4/2  下午7:59
 * @description:
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String a = filterConfig.getInitParameter("a");
        System.out.println(a);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


    }

    @Override
    public void destroy() {

    }
}
