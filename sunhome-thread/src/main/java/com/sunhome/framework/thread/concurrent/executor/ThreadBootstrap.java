package com.sunhome.framework.thread.concurrent.executor;

import java.util.concurrent.TimeUnit;

/**
 * @author : wangqijia
 * create at:  2020/4/22  下午2:54
 */
public class ThreadBootstrap {


    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> CURRENT_RESOURCE = new InheritableThreadLocal<String>();

        CURRENT_RESOURCE.set("a");

        new Thread(() -> {
            System.out.println("test1");
            System.out.println(CURRENT_RESOURCE.get());
        }).start();


    }
}
