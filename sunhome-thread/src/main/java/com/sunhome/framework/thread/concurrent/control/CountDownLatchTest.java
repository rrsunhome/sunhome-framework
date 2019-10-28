package com.sunhome.framework.thread.concurrent.control;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());

            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            countDownLatch.countDown();


        }).start();

        try {
            countDownLatch.await();

            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
