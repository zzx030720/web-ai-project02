package com.zzx.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")//拦截所有请求
@Slf4j
public class DemoFilter implements Filter {


    // 初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化方法");
    }

    // 拦截到请求时执行,执行多次
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("拦截到请求");
        //放行
        chain.doFilter(request, response);

    }

    // 销毁方法

    @Override
    public void destroy() {
        log.info("销毁方法");
    }
}
