package com.sunhome.framework.thread.concurrent.control;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    private static Semaphore semaphor = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphor.acquire();


                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphor.release();
                }
            }).start();

        }
        TimeUnit.SECONDS.sleep(3);
        // 返回信号量中可用的许可证数
        System.out.println("availablePermits:" + semaphor.availablePermits());
        // 返回正在等待着线程数
        System.out.println("getQueueLength:" + semaphor.getQueueLength());

    }
}
