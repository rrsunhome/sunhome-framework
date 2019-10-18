package com.renren.thread.core.chapter1;

/**
 * yield()方法 放弃当前cpu资源，使线程运行状态转换为可运行状态
 * 可能刚生效，立马获的cpu时间片
 */
public class ThreadYieldBootstrap {

    public static void main(String[] args) {
        ThreadYield run = new ThreadYield();
        run.start();

    }
}


class ThreadYield extends Thread {

    @Override
    public void run() {

        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 20000000; i++) {
            Thread.yield();
            count++;

        }
        long endTime = System.currentTimeMillis();


        System.out.println("time/ms:" + (endTime - beginTime));


    }
}



