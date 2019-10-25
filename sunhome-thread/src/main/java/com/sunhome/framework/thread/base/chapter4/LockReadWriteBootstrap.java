package com.sunhome.framework.thread.base.chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试demo
 * 读锁之间不互斥
 * 读写或写写互斥
 * 结论:涉及到写都互斥
 */
public class LockReadWriteBootstrap {

    public static void main(String[] args) throws InterruptedException {
        final ReadWriteService readWriteService = new ReadWriteService();
        //
//        new Thread(() -> {
//            readWriteService.read();
//        }).start();
        new Thread(() -> {
            readWriteService.read();
        }).start();

        new Thread(() -> {
            readWriteService.write();
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            readWriteService.read();
        }).start();


//        new Thread(() -> {
//            readWriteService.write();
//        }).start();

    }
}


class ReadWriteService {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();

    private Lock writeLock = readWriteLock.writeLock();


    public void read() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
        readLock.unlock();
    }

    public void write() {
        writeLock.lock();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "write:" + System.currentTimeMillis());
        writeLock.unlock();
    }


}
