package com.sunhome.framework.thread.core.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBootStrap {

    public static void main(String[] args) {

        final AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    atomicInteger.addAndGet(1);

                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum" + atomicInteger.get());

    }
}
