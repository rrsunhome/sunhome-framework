package com.sunhome.framework.thread.base.chapter4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 基本api测试demo
 */
public class LockApiBootstrap {

    public static void main(String[] args) {
        // testTryLock();
        // testLockInterruptibly();


    }

    private static void testLockInterruptibly() {
        Lock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            // 线程未被中断则获取锁
            try {
                // 执行业务逻辑，sleep和interrupt会终止线程抛出异常
                for (int i = 0; i < 50000; i++) {
                    if (i == 50000 - 1) {
                        break;
                    }
                }
                lock.lockInterruptibly();
                System.out.println("run");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        thread.start();

        // 终止线程
        thread.interrupt();

    }

    /**
     * 测试tryLock
     */
    private static void testTryLock() {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("睡眠三秒: run");
            lock.unlock();

        }).start();


        new Thread(() -> {
            try {
                // tryLock 指定时间内获取失败返回false,业务逻辑自动return
                boolean tryLock = lock.tryLock(2, TimeUnit.SECONDS);
                if (!tryLock) {
                    System.out.println("指定时间内获取锁失败");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();

        }).start();
    }
}


