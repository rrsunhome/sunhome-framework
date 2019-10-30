package com.sunhome.framework.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        long t1 = System.currentTimeMillis();

        // 创建 AsyncContext，开始异步调用
        AsyncContext actx = request.startAsync();
        // 设置异步调用的超时时长
        actx.setTimeout(60 * 1000);
        // 启动异步调用的线程
        actx.start(() -> {
            try {
                //模拟耗时操作
                TimeUnit.SECONDS.sleep(5);

                actx.getResponse().getWriter().write("Hello World!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            actx.complete();
        });
        System.out.println("async use:" + (System.currentTimeMillis() - t1));
    }
}
