package com.sunhome.framework.thread.core.chapter1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 采用synchronized/lock 对共享变量读写计算
 * 保证原子性，可见性
 */
public class ThreadCountBootstrap {


    public static void main(String[] args) {

//        ThreadCount threadCount = new ThreadCount();
//        Thread run1 = new Thread(threadCount, "ONE");
//        Thread run2 = new Thread(threadCount, "TWO");
//        Thread run3 = new Thread(threadCount, "THREE");
//
//        run1.start();
//        run2.start();
//        run3.start();


        ThreadLockCount lockCount = new ThreadLockCount();
        Thread run1 = new Thread(lockCount, "ONE");
        Thread run2 = new Thread(lockCount, "TWO");
        Thread run3 = new Thread(lockCount, "THREE");

        run1.start();
        run2.start();
        run3.start();


    }
}

class ThreadCount extends Thread {

    int count = 3;

    @Override
    synchronized public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + count);
        count--;
    }
}


class ThreadLockCount extends Thread {
    Lock lock = new ReentrantLock();

    int count = 3;

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ":" + count);
        count--;
        lock.unlock();

    }
}
