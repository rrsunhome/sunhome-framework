package com.sunhome.framework.thread.core.chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 公平锁机制
 */
public class LockFairBootstrap {


    public static void main(String[] args) {
        // 采用公平锁
        final Lock lock = new ReentrantLock(true);

        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"process");
                lock.unlock();

            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"process");
                lock.unlock();

            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"process");
                lock.unlock();

            }
        }).start();



    }
}
