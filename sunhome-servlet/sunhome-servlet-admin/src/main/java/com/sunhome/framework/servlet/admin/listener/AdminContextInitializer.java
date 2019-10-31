package com.sunhome.framework.servlet.admin.listener;

import com.sunhome.framework.servlet.context.WebApplicationInitializer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;

public class AdminContextInitializer implements WebApplicationInitializer {

    private static DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("begin add filter");

        // 添加线程执行时间过滤器
        // 拦截普通请求/异步请求
        FilterRegistration.Dynamic threadFilter = servletContext.addFilter("threadExecutionTime", new ThreadExecutionTimeFilter());
        threadFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC), false, "/*");
        threadFilter.setAsyncSupported(true);


    }


    static class ThreadExecutionTimeFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            String url = req.getRequestURL().toString();
            System.out.println(Thread.currentThread().getName() + "_URL:" + url + "-开始执行时间_" + LocalDateTime.now().format(dft));
            // 责任链模式，执行下一个过滤器
            chain.doFilter(request, response);
            System.out.println(Thread.currentThread().getName() + "_URL:" + url + "-结束执行时间_" + LocalDateTime.now().format(dft));

        }

        @Override
        public void destroy() {

        }
    }
}
