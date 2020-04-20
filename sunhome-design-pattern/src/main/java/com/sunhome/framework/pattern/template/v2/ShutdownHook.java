package com.sunhome.framework.pattern.template.v2;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午12:10
 */
public class ShutdownHook {


    private static class MainHook extends Thread {
        @Override
        public void run() {
            System.out.println("主线程结束");
        }
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new MainHook());
        System.out.println("main process");
    }
}
