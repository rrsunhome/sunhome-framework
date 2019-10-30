package com.sunhome.framework.thread.concurrent.control;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    // 同步关键类，构造方法传入的数字是多少，则同一个时刻，只运行多少个进程同时运行制定代码
    private static Semaphore semaphor = new Semaphore(2);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public static void main(String[] args) throws InterruptedException {

        asynProcessTask();

         TimeUnit.SECONDS.sleep(3);
        // 返回信号量中可用的许可证数
        System.out.println("availablePermits:" + semaphor.availablePermits());
        // 返回正在等待着线程数
        System.out.println("getQueueLength:" + semaphor.getQueueLength());

    }

    private static void asynProcessTask() {
        new Thread(() -> {

            try {
                for (int i = 0; i < 10; i++) {
                    semaphor.acquire();
                    new Thread(() -> {
                        System.out.println(Thread.currentThread().getName() + "-begin time:" + LocalDateTime.now().format(dateTimeFormatter));
                        try {

                            TimeUnit.SECONDS.sleep(4);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            semaphor.release();
                        }
                        System.out.println(Thread.currentThread().getName() + "-end time:" + LocalDateTime.now().format(dateTimeFormatter));
                    }).start();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
